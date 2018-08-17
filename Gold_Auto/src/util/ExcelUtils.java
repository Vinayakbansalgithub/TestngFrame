/*
 * #Project Name  : Gold Automation Framework
	#Version : V1.0
	# Author of the Code: PureSoftware
	#Reviewed By: PureSoftware
	# Description :  The Class ExcelUtils. 
	It contains all functions to handle operations on Excel Workbook, Sheets and Cells
*/
package util;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.*;
import org.apache.poi.ss.formula.FormulaParser;
import org.apache.poi.ss.formula.FormulaRenderer;
import org.apache.poi.ss.formula.FormulaType;
import org.apache.poi.ss.formula.SharedFormula;
import org.apache.poi.ss.formula.ptg.Ptg;
/*import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;*/

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellFormula;
import org.python.icu.text.SimpleDateFormat;



import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.xssf.usermodel.*;

import configuration.Constant;

// TODO: Auto-generated Javadoc
/**
 * The Class ExcelUtils. 
 * It contains all functions to handle operations on Excel Workbook, Sheets and Cells
 */
@SuppressWarnings("unused")
public class ExcelUtils {


	/** The variable to keep Row object. */
	private static XSSFRow row = null;
	
	private static int _cellNum;
	
	/** The variable to keep Excel w sheet object. */
	private static XSSFSheet excelWSheet;
	
	/** The variable to keep Excel w book object */
	private static XSSFWorkbook excelWBook;
	
	/** The variable to keep Cell object */
	private static XSSFCell cell;
	
	/** The variable to keep evaluator. */
	static FormulaEvaluator evaluator;

	// This method is to set the File path and to open the Excel file
	/**
	 * function to Set the context to passed the excel file path and sheet Name.
	 *
	 * @param Path the path
	 * @param SheetName the sheet name
	 * @throws Exception the exception
	 */
	// Pass Excel Path and SheetName as Arguments to this method
	public static void setExcelFile(String path, String SheetName)
			throws Exception {

		FileInputStream excelFile = new FileInputStream(path);
		
		try{
		excelWBook = new XSSFWorkbook(excelFile);
		excelWSheet = excelWBook.getSheet(SheetName);
		evaluator = excelWBook.getCreationHelper().createFormulaEvaluator();
		}catch(Exception e){}
		
//		XSSFFormulaEvaluator.evaluateAllFormulaCells(excelWBook);
	}
	
	/**
	 * function to Get the column no by name.
	 *
	 * @param ColumnName the column name
	 * @return the column no by name
	 */
	public static Integer getColumnNoByName(String columnName)
	{
		int startCol = excelWSheet.getRow(0).getFirstCellNum();
		int lastCol = excelWSheet.getRow(0).getLastCellNum();
		String sheetCellValue = null;
		Integer columnNo = 0;
		for(int i=startCol ; i<=lastCol-1; i++)
		{
			sheetCellValue = excelWSheet.getRow(0)
					.getCell(i).getStringCellValue().trim();
			if(sheetCellValue.toUpperCase().equals(columnName.toUpperCase()))
			{
				columnNo=i;
				break;
			}
		}
		return columnNo;
	}
	
	/**
	 * function to Get the row no by text.
	 *
	 * @param RowText the row text
	 * @param ColumnNo the column no
	 * @return the row no by text
	 */
	public static Integer getRowNoByText(String rowText, Integer columnNo)
	{
		int startRow = 1;
		int lastRow = excelWSheet.getLastRowNum();
		String sheetCellValue = null;
		Integer rowNo = null;
		for(int i=startRow ; i<=lastRow; i++)
		{
			sheetCellValue = excelWSheet.getRow(i)
					.getCell(columnNo).getStringCellValue();
			if(sheetCellValue.toUpperCase().equals(rowText.toUpperCase()))
			{
				rowNo=i;
				break;
			}
		}
		return rowNo;
	}
	
	/**
	 * function to Gets the data for object by logical Name.
	 *
	 * @param LogicalName the logical name
	 * @return the datafor object
	 * @throws Exception the exception
	 */
	public static String getDataforObject(String logicalName) throws Exception
	{
		String objectData = null;
		ExcelUtils.setExcelFile(Constant.SPATH, "TestData");
		int lastRow = excelWSheet.getLastRowNum();
		for(int i = 1; i<=lastRow; i++)
		{
			String sheetTCID = 
					excelWSheet.getRow(i).getCell(getColumnNoByName("TestcaseId")).getStringCellValue();
						
			if(sheetTCID.equalsIgnoreCase(Constant.CURRENTTESTCASE))
			{
				objectData = getCellData(i, getColumnNoByName(logicalName));
				break;
			}
		}
		
		return objectData;
	}
	
	/**
	 * function to get the Last row num.
	 *
	 * @return the integer
	 */
	// return the last row of the current sheet
	public static Integer lastRowNum()
	{
		Integer ix = excelWSheet.getLastRowNum(); 
		return ix;
	}
	// This method is to read the test data from the Excel cell
	/**
	 * Gets the cell data.
	 *
	 * @param RowNum the row num
	 * @param ColNum the col num
	 * @return the cell data
	 * @throws Exception the exception
	 */
	// In this we are passing parameters/arguments as Row Num and Col Num
	public static String getCellData(int rowNum, int colNum) throws Exception {
		// CellValue CellValue = null;
		String cellData = null;
		
	/*	if(colNum==4){
			System.out.println("gg");
			
			try{
			System.out.println(excelWSheet.getRow(rowNum).getCell(colNum));}
			
			catch(Exception e){
				System.out.println(excelWSheet.getRow(rowNum).getCell(colNum).getReference());}

				
			}*/
			
		
		try {
			cell = excelWSheet.getRow(rowNum).getCell(colNum);	
			
			
//			System.out.println(cell);
		} catch (Exception e) {
			Log.warn(excelWSheet.getSheetName() 
					+ " did not have cell with Row " + rowNum
					+ " and column number " + colNum);
			cellData = "";
			return cellData;
		}
		
		

		if (cell == null) 
		{
			cellData = "";
			//java.lang.NullPointerException e = null;
			
			/*
			Log.info(ExcelUtils.getCellData(RowNum, Constant.Testcaseid)+
					"; Value is not present in Cell:"+RowNum+ ","+ColNum+"; ");
					*/
			
		} else {
		
			if (cell.getCellType() == org.apache.poi.ss.usermodel.Cell.CELL_TYPE_FORMULA) 

			{
				evaluator.clearAllCachedResultValues();
				evaluator.evaluateFormulaCell(cell);

				if (cell.getCachedFormulaResultType() == org.apache.poi.ss.usermodel.Cell.CELL_TYPE_NUMERIC) {
					if (DateUtil.isCellDateFormatted(cell)) {
						java.util.Date date = cell.getDateCellValue();
						SimpleDateFormat sdf = new SimpleDateFormat(Constant.DATAFORMATE);
						cellData = sdf.format(date);
					} else {
						cellData = String.valueOf(cell.getNumericCellValue());
					}
				} else if (cell.getCachedFormulaResultType() == org.apache.poi.ss.usermodel.Cell.CELL_TYPE_BOOLEAN) {
					cellData = String.valueOf(cell.getBooleanCellValue());
					// System.out.println(CellData);
					// System.out.println(Cell.getBooleanCellValue());
				} else {
					cellData = cell.getStringCellValue();
				}
			} else if (cell.getCellType() == org.apache.poi.ss.usermodel.Cell.CELL_TYPE_NUMERIC) {
				cellData = String.valueOf(cell.getNumericCellValue());

			} else if (cell.getCellType() == org.apache.poi.ss.usermodel.Cell.CELL_TYPE_BOOLEAN) {
				cellData = String.valueOf(cell.getBooleanCellValue());
			} else {
				cellData = cell.getStringCellValue();
			}

		}
		//System.out.println(CellData);
		return cellData;
	}
	
	/**
	 * function to Create the new row.
	 *
	 * @param RowNum the row num
	 */
	public static void createNewRow(int rowNum){
		excelWSheet.createRow(rowNum);
	}
	// This method is use to write value in the excel sheet
	// This method accepts four arguments (Result, Row Number, Column Number &
	// Sheet Name)

	/**
	 * function to write the data in excel sheet cell.
	 *
	 * @param Result the result
	 * @param RowNum the row num
	 * @param ColNum the col num
	 * @param Path the path
	 * @param SheetName the sheet name
	 * @throws Exception the exception
	 */
	
	public static void setCellData(String result, int rowNum, int colNum,
			String Path, String SheetName) throws Exception {
		try {
			
			
			
			
			
			
			
			
			
			
			FileInputStream excelFile = new FileInputStream(Path);
			
			try{
			excelWBook = new XSSFWorkbook(excelFile);
			excelWSheet = excelWBook.getSheet(SheetName);
			}catch(Exception e){}
			row = excelWSheet.getRow(rowNum);
			// ensure that the row exists with the current test case ID
			///*
			if(row==null){
				row = excelWSheet.createRow(rowNum);
				// update the 1st column with the current test case ID
				cell = row.createCell(0);
				cell.setCellValue(Constant.COMPONENT);
				cell = row.createCell(1);
				cell.setCellValue(Constant.CURRENTTESTCASE);
				cell = row.createCell(2);
				cell.setCellValue(Constant.CURRENTTESTCASEDESCRIPTION);
			}
			//*/
			
			cell = row.getCell(colNum, Row.RETURN_BLANK_AS_NULL);
			
			if (cell == null) {
				cell = row.createCell(colNum);
				// Cell.setCellValue(Result);
				cell.setCellValue(result);
			} else {
				
				cell.setCellType(Cell.CELL_TYPE_STRING);
				cell.setCellValue(result);
			}
			// Constant variables Test Data path and Test Data file name
			FileOutputStream fileOut = new FileOutputStream(Path);
			excelWBook.write(fileOut);
			 fileOut.flush();
			fileOut.close();
			excelFile.close();
			
			//System.out.println(">>>>> closed output stream.");
			excelWBook = new XSSFWorkbook(new FileInputStream(Path));
			
		//	System.out.println(">>>>> New instance of file created.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/** Shared formula method *//*
	
	private String convertSharedFormula(int si) {
	    CTCellFormula f = excelWSheet.getSharedFormula(si);
	    if (f == null)
	        throw new IllegalStateException(
	                "Master cell of a shared formula with sid=" + si
	                        + " was not found");

	    String sharedFormula = f.getStringValue();
	    //Range of cells which the shared formula applies to
	    String sharedFormulaRange = f.getRef();

	    CellRangeAddress ref = CellRangeAddress.valueOf(sharedFormulaRange);

	    int sheetIndex = excelWSheet.getWorkbook().getSheetIndex(excelWSheet);
	    XSSFEvaluationWorkbook fpb = XSSFEvaluationWorkbook.create(excelWSheet
	            .getWorkbook());
	    SharedFormula sf = new SharedFormula(SpreadsheetVersion.EXCEL2007);

	    Ptg[] ptgs = FormulaParser.parse(sharedFormula, fpb,
	            FormulaType.CELL, sheetIndex);
	    Ptg[] fmla = sf.convertSharedFormulas(ptgs,
	            getRowIndex() - ref.getFirstRow(),
	            getColumnIndex() - ref.getFirstColumn());
	    return FormulaRenderer.toFormulaString(fpb, fmla);
	}
	
	*//**
     * Returns row index of a row in the sheet that contains this cell
     *
     * @return zero-based row index of a row in the sheet that contains this cell
     *//*
    public int getRowIndex() {
        return row.getRowNum();
    }
    
    *//**
     * Returns column index of this cell
     *
     * @return zero-based column index of a column in a sheet.
     *//*
    public int getColumnIndex() {
        return this._cellNum;
    }*/

}
