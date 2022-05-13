import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

public class CargoShipping   //DO NOT change the class name
{
	
    
    public static void writeExcelData(String fileName,String result) throws Exception { //Do not change the method signature
        //Write the Test result to the excel sheet
    	
    	XSSFWorkbook workbook = new XSSFWorkbook();
    	XSSFSheet sheet = workbook.createSheet("TestCase");
    	
    	Row row = sheet.createRow(0);
    	
    	row.createCell(0).setCellValue(result);
    	
    	
    	FileOutputStream out = new FileOutputStream(new File(fileName));
    	workbook.write(out);
    	
    	out.close();
    	
    }
    
}

  