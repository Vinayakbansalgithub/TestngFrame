/*
 * #Project Name  : Gold Automation Framework
	#Version : V1.0
	# Author of the Code: PureSoftware
	#Reviewed By: PureSoftware
	# Description :   The Class used for Reporting into Excel.
*/
package util;


/**
 * The Class used for Reporting into Excel.
 */
public class Reporting {

	
	/**
	 * function to Report update. It updates the cell in excel as per parameter values given
	 *
	 * @param iRow the i row
	 * @param columnno the columnno
	 * @param actionname the actionname
	 * @param Path the path
	 * @param sheename the sheetname
	 * @throws Exception the exception
	 */
	public void reportUpdate(int iRow,int columnno, String actionname, String Path, String sheetname) throws Exception
	{
			ExcelUtils.setCellData(actionname,iRow,columnno,Path,sheetname);
	}
	
	/**
	 * function to Report update. It updates the cell in excel as per parameter values given, 
	 * Same as above but called with different name
	 *
	 * @param iRow the i row
	 * @param columnno the columnno
	 * @param actionname the actionname
	 * @param Path the path
	 * @param sheename the sheetname
	 * @throws Exception the exception
	 */
	public void dReportUpdate(int iRow,int columnno, String actionname, String Path, String sheetname) throws Exception
	{
			ExcelUtils.setCellData(actionname,iRow,columnno,Path,sheetname);
	}
	
	/**
	 * function to Report update. It updates the cell in excel as per parameter values given, 
	 * Same as above but called with different name
	 *
	 * @param iRow the i row
	 * @param columnno the columnno
	 * @param actionname the actionname
	 * @param Path the path
	 * @param sheename the sheetname
	 * @throws Exception the exception
	 */
	public void eReportUpdate(int iRow,int columnno, String actionname, String Path, String sheetname) throws Exception
	{
			ExcelUtils.setCellData(actionname,iRow,columnno,Path,sheetname);
	}
}
