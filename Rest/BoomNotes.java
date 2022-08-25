import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BoomiPETNotes extends APIImplementation{

    @BeforeTest()
    public void ticketNotes_DataPrep() throws IOException, InvalidFormatException {

        String[][] testdata =dataSource("./src/test/resources/testdata/TestData/BoomiAutomationFeed.xlsx","TicketNotes");
        String ticketID=dataGeneration_TicketCreation();
        for (String[] testdatum : testdata) {
            dataUpdate(testdatum[0], testdatum[1], testdatum[2], testdatum[3], testdatum[4], testdatum[5],testdatum[6],testdatum[7],ticketID);
        }
    }
    public void dataUpdate(String rowNum, String header, String payload, String notes, String statusCode, String flag, String errorType, String errorMessage,String ticketID){
        try {

            FileInputStream file = new FileInputStream(new File("./src/test/resources/testdata/TestData/BoomiAutomationMain.xlsx"));

            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheet("TicketNotes");
            Cell cell = null;

            //Update the value of cell
            cell = sheet.getRow(Integer.parseInt(rowNum)).getCell(5);
            if(cell.getStringCellValue().equals("true")){

                cell = sheet.getRow(Integer.parseInt(rowNum)).getCell(2);
                String dataPayload = cell.getStringCellValue();
                JSONObject inputPayload = new JSONObject(dataPayload);
                inputPayload.remove("ticket_id");
                inputPayload.put("ticket_id",ticketID);
                System.out.println("*********** Value of the Excel Spreadsheet Changed to"+inputPayload.toString());
                cell.setCellValue(inputPayload.toString());
            }

            file.close();

            FileOutputStream outFile =new FileOutputStream(new File("./src/test/resources/testdata/TestData/BoomiAutomationMain.xlsx"));
            workbook.write(outFile);
            outFile.close();
            workbook.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

@Test(description = "PET Ticket Notes Validation", dataProvider = "datasource")
    public void ticketNotes(String rowNum, String header, String payload, String notes, String statusCode, String flag, String errorType, String errorMessage){
    validate_DisputeNotes(header,payload,notes,statusCode,flag,errorType,errorMessage);
    }
}
