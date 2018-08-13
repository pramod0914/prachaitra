package com.crm.GenericLib;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * @author shefali
 *
 */


public class FileUtils {

	
		String excelPath="./test_data_excel.xlsx";
		String propertyFilePath="./Data.properties";
		/**
		 *
		 * it returns object of property physical file & load all the keys 
		 * @throws IOException 
		 */
public Properties getPropertiesFileObj() throws IOException
{
		FileInputStream fis=new FileInputStream("./Data.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		return pobj;
}
public String getExcelData(String sheetName,int rowNum,int colNum) throws EncryptedDocumentException, InvalidFormatException, IOException
{ 
	FileInputStream fis= new FileInputStream("./test_data_excel.xlsx");
	Workbook wrk=WorkbookFactory.create(fis);
	Sheet sh= wrk.getSheet(sheetName);
    Row row=sh.getRow(rowNum);
    Cell cel=row.getCell(colNum);
    String data=cel.getStringCellValue();
    wrk.close();
    return data;
}
public void setExcelData(String sheetName,int rowNum,int colNum,String data) throws EncryptedDocumentException, InvalidFormatException, IOException
{ 
	FileInputStream fis= new FileInputStream("./test_data_excel.xlsx");
	Workbook wrk=WorkbookFactory.create(fis);
	Sheet sh= wrk.getSheet(sheetName);
    Row row=sh.getRow(rowNum);
    Cell cel=row.createCell(colNum);
    cel.setCellValue(data);
    FileOutputStream fos= new FileOutputStream("./test_data_excel.xlsx");
    wrk.write(fos);
    wrk.close();
}

}