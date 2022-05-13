import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import java.io.IOException;
import java.util.Iterator;

public class CusRegExcel { // Do not change the class name

	// Use this declaration to store values parsed from excel
	public static String[] customerData = new String[5];

	public static String[] readExcelData(String fileName) throws IOException { // Do not change the method signature

		// Implement code to read data from excel file. Store the values in
		// 'customerData' array. Return the array. */

		FileInputStream readFile = new FileInputStream(fileName);

		XSSFWorkbook workbook = new XSSFWorkbook(readFile);
		XSSFSheet sheet = workbook.getSheet("customervalid");
		
		
		for(int i=0; i<5; i++) {
		    customerData[i] = String.valueOf(sheet.getRow(0).getCell(i));
		}
		

		return customerData;

	}

	public static void getExcelPath(String sheetName) {
		// Locate the excel sheet. Return the file path
		
		File file = new File("CustReg.xlsx");
		
		String filePath = file.getAbsolutePath();
		
		
	}

}
