/*
 * #Project Name  : Gold Automation Framework
	#Version : V1.0
	# Author of the Code: PureSoftware
	#Reviewed By: PureSoftware
	# Description : The Class ORGenerator.
	It is used to create a text file with the names of all the variables in the
	object repository file.
*/
package util;
import static java.nio.file.StandardOpenOption.*;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import configuration.Constant;


/**
 * The Class ORGenerator.
 * It is used to create a text file with the names of all the variables in the
 * object repository file. 
 */
public class ORGenerator {
	
	/** List to keep Applications names*/
	private static List<String> applications= new ArrayList<String>();
	
	/*
	 * 
	 * Method to generate the Field Names in a text file 
	 * for all the variable Names
	 * */
	
	/**
	 * function to read the Object Repository Java file and 
	 * create a text file with all the fields in that file
	 */
	public static void generate()
	{
		
		for(String app:applications)
		{
			// create a text file with the name	
			String FilePath = Constant.DATAENGINEPATH+"\\"+app.toString()+".txt";
			Path p = Paths.get(FilePath);
			byte[] newline = System.getProperty("line.separator").getBytes();
			try {
				Class<?> cls = Class.forName("objrepositories."+app);
				Field[] fields = cls.getFields();
				if(fields.length==0){
					System.out.println("Warning : Please check "+ 
				app + " doesn't have any members");
					
				}
				
				Files.deleteIfExists(p);
				
				for(Field f: fields)
				{
					byte[] data = f.getName().getBytes();
					try (OutputStream out = new BufferedOutputStream(
							Files.newOutputStream(p, CREATE, APPEND)))
					{
						out.write(data,0, data.length);
						out.write(newline,0,newline.length);
						
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
				
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
			
			System.out.println("Finished : Generated all objects for : " + app);
		}
	}
	
	/**
	 * The main method.
	 *
	 * @param main arguments
	 */
	public static void main(String[] main)
	{
		// Add the name of the repository to List Applications as below
		// to generate the list of logical names
		applications.add("GOLDObjectRepository");
		applications.add("GOLDStandAlone");
		generate();
		
	}
}
