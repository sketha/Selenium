package apachePOI;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataproviderFunction {
	@Test(dataProvider="dpImplementation")
	public void test(String x, String y){
System.out.println(x+".............."+y);		
	}

	@DataProvider(name="dpImplementation")
	public Object[][] dataSource() throws InvalidFormatException, IOException{
		File docLocation = new File("F:\\workspace\\September 01\\TestData\\Login.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(docLocation);
		XSSFSheet sheet = wb.getSheetAt(0);
		int rCount= sheet.getLastRowNum();
		int cCount = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[rCount][cCount];
		for(int i=1;i<=rCount;i++){
			XSSFRow row = sheet.getRow(i);
			for(int j=0;j<cCount;j++){
				XSSFCell cell = row.getCell(j);
				data[i-1][j]=cell.getNumericCellValue();
			}
		}
		return data;
		

	}

}
