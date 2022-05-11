import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.util.Iterator;

public class CusRegExcel {    //Do NOT change the class name
	
	static int i = 0;
	
	static String[] names=new String[2];
	
    public static String[] readExcelData(String sheetName) throws Exception {    //DO NOT change the method signature
		//Implement code to read the name 'Rajesh' and 'Velu' from the excel sheet.
		//Store the name in the 'names' array and return it.
		
		
	    FileInputStream readFile = new FileInputStream("CustReg.xlsx");
	        
	    XSSFWorkbook workbook = new XSSFWorkbook(readFile);
	    XSSFSheet sheet = workbook.getSheet(sheetName);
	    
		Row row;
		Cell cell;
			
		Iterator<Row> rowIterator = sheet.iterator();
			
		while(rowIterator.hasNext()) {
		    
		    row = rowIterator.next();
		    
		    Iterator<Cell> cellIterator = row.iterator();
		    
		    while(cellIterator.hasNext()) {
		        
		        cell = cellIterator.next();
		       
		        DataFormatter formatter = new DataFormatter();
		        String text = formatter.formatCellValue(cell);
		        
		        while(i < 2) {
		            
		            System.out.println(text);
		            
		            
		            names[i] = text;
		            i = i + 1;
		            
		            break;
		            
		        }
		            break;
		        
		    }
		    
		}
		
		return names;
    }



    public static String getExcelPath(String sheetName) 
    {
	    //Implement code to locate the excel file. Return the filepath
	    
	    File file = new File("CustReg.xlsx");
	    
	    String filePath = file.getAbsolutePath();
	    
	    return filePath;
	    
    }

    public static void main(String[] args) throws Exception 
	{ 
	    CusRegExcel customer = new CusRegExcel();
	    //Add required code
	    
	    
	    customer.getExcelPath("CustReg.xlsx");
	    customer.readExcelData("customervalid");
	    
	    
	    
	    
	    
	    
	    
	}
}

  