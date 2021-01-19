package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class ExcelSheetOperation extends WebDriverInitialization{

	WebDriver driver;
	static Workbook affirm_sheet = null;
	public static FileInputStream excelfile;
	public static String content=null;
	public static XSSFSheet sheet;

	public ExcelSheetOperation() {
		
	}

	public static ArrayList<String> readExecutionPlan() throws IOException {
		//File file = new File("C:\\Users\\rahul\\eclipse-workspace\\Affirm\\src\\main\\java\\Affirm_Sheet.xlsx");
		String path = prop.getProperty("Affirm_Sheet");
		excelfile = new FileInputStream(path );
		affirm_sheet = new XSSFWorkbook(excelfile);
		sheet = (XSSFSheet) affirm_sheet.getSheet("Execution_Plan");
		int rowNum = sheet.getPhysicalNumberOfRows();
		Row row= sheet.getRow(0);
		int colNum= row.getLastCellNum();
		ArrayList<String> data = new ArrayList<String>();
		
		for(int i=0; i< rowNum; i++) {
			
			Row rRow=  sheet.getRow(i);
			String exceloperation= rRow.getCell(1).toString();
			if(exceloperation.equalsIgnoreCase("Yes")) {
				//data[i]=rRow.getCell(0).toString();
				content=rRow.getCell(0).toString();
				data.add(content);
			}
		}
//		for(int j=0; j< data.length;j++) {
//		System.out.println(data[j]);
//		}
		System.out.println(data);
		affirm_sheet.close();
		return data;

	}
	
	public static String getCellData(String colname, String TC_Name, String sheetname) throws Exception {
		String cellvalue = null;
		Integer colIndex = 0;
		//File file = new File("C:\\Users\\rahul\\eclipse-workspace\\Affirm\\src\\main\\java\\Affirm_Sheet.xlsx");
		String path = prop.getProperty("Affirm_Sheet");
		excelfile = new FileInputStream(path);
		affirm_sheet = new XSSFWorkbook(excelfile);
		sheet= (XSSFSheet) affirm_sheet.getSheet(sheetname);
		
// Identify the column index where the column name is found
		Row rRow = sheet.getRow(0); //column name will be always in the zeroth row
		int colcount= rRow.getPhysicalNumberOfCells();
		for (int i=0; i< colcount;i++) {
			if(rRow.getCell(i).getStringCellValue().equalsIgnoreCase(colname)) {
				colIndex=i;
				break;
			}
		}
		
//Now, once the column Index has been stored, we have to identify the row in which desired test case needs to be executed.
// Row iterator will be used to iterate through the rows.
		
		Iterator<Row> rowIterator = sheet.iterator();
//hasNext() returns boolean value 
		while(rowIterator.hasNext()) {
			Row row= rowIterator.next();// returns the value
//since we are interested in finding the Test case, we are taking Cell(0), i.e. zeroth column for each row.
			Cell colvalue= row.getCell(0);// returns the cell for each row traversed. 

			if(colvalue.getStringCellValue().equalsIgnoreCase(TC_Name)) {
				Cell cell_for_column_row = row.getCell(colIndex);// with the help of colIndex we will get the cell for which the value needs to be obtained.
//Identify whether the cell type is numeric or string
				CellType type= cell_for_column_row.getCellType();
				switch(type) {
				case NUMERIC:
					Double temp = cell_for_column_row.getNumericCellValue();
					cellvalue = temp.toString();
					break;
				case STRING:
					cellvalue =cell_for_column_row.getStringCellValue();
					break;
				}
			}
		}
		excelfile.close();
		
		return cellvalue;
		
	}

	public void excelDataWrite() {

	}

}
