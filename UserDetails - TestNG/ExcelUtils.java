import java.io.FileInputStream;
import java.io.File;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;

import org.apache.poi.ss.usermodel.DataFormatter;

public class ExcelUtils {  //Do not change the class name
    
	// Use the below declarations
    public static XSSFSheet worksheet;
    public static XSSFWorkbook workbook;
    public static FileInputStream work_file;
    public static String file_path;

	
	
    public static String[] readExcelData(String sheetName) throws Exception {

		//Get the excel file path
		File file = new File("userdetails.xlsx");
		file_path = file.getAbsolutePath();
		
		work_file = new FileInputStream(file_path);
		
        //Using the sheet name passed to this method, read the data and store it in a string array
        
        workbook = new XSSFWorkbook(work_file);
        worksheet = workbook.getSheet(sheetName);
        
        XSSFRow row;
        XSSFCell cell;
        
	    //create a string array to store the excel values
		String[] readData = new String[4];
		
		//DataFormatter formatter = new DataFormatter();
		
		//use switch case to read multiple datatypes
		for(int i=0; i<readData.length; i++) {
		    
		    // Storing cell value.
		    cell = worksheet.getRow(i).getCell(0);
		    
		    // To know the DataType.
		    Object object = (Object) worksheet.getRow(0).getCell(i);
		    String dataType = object.getClass().getName();
		    
		    switch(dataType) {
		        
		        case "java.lang.Integer":
		            readData[i] = String.valueOf(worksheet.getRow(i).getCell(0));
		          
		        case "java.lang.String":
		            readData[i] = String.valueOf(worksheet.getRow(i).getCell(0));
		            
		    }
		    
		    
		    
		} // End of for-loop
		
		return readData;
	
    }

}

