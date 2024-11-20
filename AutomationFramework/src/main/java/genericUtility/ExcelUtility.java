package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getStringDataFromExcel(String sheetname,int rowindex,int cellindex) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/TestData/DemoWebShopProject-1.xlsx");
		Workbook workbook=WorkbookFactory.create(fis);
		return workbook.getSheet(sheetname).getRow(rowindex).getCell(cellindex).getStringCellValue();
	}
	public Boolean getBooleanDataFromExcel(String sheetname,int rowindex,int cellindex) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/TestData/TestScript data.xlsx");
		Workbook workbook=WorkbookFactory.create(fis);
		return workbook.getSheet(sheetname).getRow(rowindex).getCell(cellindex).getBooleanCellValue();
	}
	public double getNumericDataFromExcel(String sheetname,int rowindex,int cellindex) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/TestData/TestScript data.xlsx");
		Workbook workbook=WorkbookFactory.create(fis);
		return workbook.getSheet(sheetname).getRow(rowindex).getCell(cellindex).getNumericCellValue(	);
	}
	public LocalDateTime getDateFromExcel(String sheetname,int rowindex,int cellindex) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/TestData/TestScript data.xlsx");
		Workbook workbook=WorkbookFactory.create(fis);
		return workbook.getSheet(sheetname).getRow(rowindex).getCell(cellindex).getLocalDateTimeCellValue();
	}
}
