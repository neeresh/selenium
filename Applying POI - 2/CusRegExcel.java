import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.util.*;


public class CusRegExcel {     //DO NOT change the class name


    public static void writeExcelData() throws Exception  {         //DO NOT change the method signature
	    //Implement code to write the names 'John', 'Peter', 'Sam' to in the excel sheet on the first column
	    //As shown in the image
	    
	    XSSFWorkbook workbook = new XSSFWorkbook();
	    XSSFSheet sheet = workbook.createSheet("TestCase");
	    
	    
	    Map<String, Object[]> dataset = new TreeMap<String, Object[]>();
	    dataset.put("1", new Object[] {"John", "Peter", "Sam"});
	    
	    Set<String> set = dataset.keySet(); // Storing all keys from map.
	    
	    
	    Cell cell;
	    int rowNum = 0;
	    
	    
	    for(String key: set) {
	        
	        Row row = sheet.createRow(rowNum++);
	        
	        Object[] values = dataset.get(key);
	        
	        int cellNum = 0;	        
	        for(Object value : values) {
	            
	            
	            cell = row.createCell(cellNum++);
	            
	            if(value instanceof String) {
	                cell.setCellValue((String) value);
	                
	            }else if(value instanceof Integer) {
	                cell.setCellValue((Integer) value);
	            }
	            
	        } // End of inner for-loop
	        
	        
	    } // End of outer for-loop
	    
	    FileOutputStream out = new FileOutputStream(new File("CustReg.xlsx"));
	    workbook.write(out);
	    
	    out.close();
	    
    }
    
    
    
    public static void main(String[] args) throws Exception 
	{ 
	    CusRegExcel customer = new CusRegExcel();
	    //Add required code
	    
	    writeExcelData();
	}
}

  