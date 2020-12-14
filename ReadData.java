package apachePOI;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadData {

	public static void main(String[] args) throws InvalidFormatException, IOException {
		File doc = new File("F:\\Selenium\\Material\\Sample.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(doc);
		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row = sheet.getRow(1);
		XSSFCell cell1 = row.getCell(1);
		String uName = cell1.getStringCellValue();
		System.out.println(uName);
		
		XSSFCell cell2 = row.getCell(2);
		String pwd = cell2.getStringCellValue();
		System.out.println(pwd);
		
		
		
		
		

	}

}
