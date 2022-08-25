import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;

public class Utils {
    @DataProvider(name="datasource")
    public Object[][] datastation(Method m) throws Exception {
        System.out.println("Method Name:"+m.getName());
        String spreadsheetName = dynamicLoader(m.getName());
       // String[][] dataset = dataSource("/Users/suketha/Documents/Velocity_Boomi/BoomiAutomationMain.xlsx",spreadsheetName);
        String[][] dataset = dataSource("./src/test/resources/testdata/TestData/BoomiAutomationMain.xlsx",spreadsheetName);
        return (Object[][]) dataset;
    }

    public String dynamicLoader(String args){
        String sheetName="";
        switch (args){
            case "disputeDetails": sheetName= "DisputeDetails"; break;
            case "getMetadata": sheetName= "GetMetadata"; break;
            case "pictureAPIDetails": sheetName="PictureAPI"; break;
            case "ticketTemplate": sheetName="TicketTemplate"; break;
            case "dynamicTicketTemplate": sheetName="DynamicTemplate"; break;
            case "ticketMetadata": sheetName="TicketMetadata"; break;
            case "ticketCreation": sheetName="TicketCreation"; break;
            case "ticketNotes" : sheetName="TicketNotes"; break;
            case "ticketMetrics": sheetName="TicketMetrics"; break;
            case "ticketDetails": sheetName="TicketDetails";break;
            case "ticketSummary": sheetName="TicketSummary";break;
            case "ticketAttachments": sheetName="TicketAttachment";break;
            case "disputeNotes": sheetName="DisputeNotes";break;
            case "voiceBioMetrics": sheetName="VoiceBio";break;
            case "disputeMetrics": sheetName="DisputeMetrics";break;
            case "disputeAttachments": sheetName="DisputeAttachments";break;
            case "disputeSummary": sheetName="DisputeSummary";break;
            default: sheetName= null;
        }
        return sheetName;
    }


    public String[][] dataSource(String filePath, String spreadsheetName) throws IOException, InvalidFormatException {
        XSSFWorkbook wb;
        wb = new XSSFWorkbook(new File(filePath));

        XSSFSheet sheet = wb.getSheet(spreadsheetName);
        int rowCount = sheet.getLastRowNum();
        int columnCount = sheet.getRow(0).getLastCellNum();
        System.out.println("Row Count :" + rowCount + " Column Count:" + columnCount);
        String[][] data = new String[rowCount][columnCount];
        Iterator<Row> iterator = sheet.iterator();
        int skipHeader = 0;
        int i = 0, j = 0;
        while (iterator.hasNext()) {
            Row currentRow = iterator.next();
            if (skipHeader == 0) {
                skipHeader = 1;
                continue;
            }
            i++;
            Iterator<Cell> cellIterator = currentRow.iterator();
            while (cellIterator.hasNext()) {
                Cell currentCell = cellIterator.next();
                data[i - 1][j++] = currentCell.getStringCellValue();
                //System.out.println(new String (currentCell.getStringCellValue().getBytes("UTF-8")));
            }
            j = 0;
        }
        wb.close();
        return data;
    }
}
