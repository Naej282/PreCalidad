package DataDrivenTesting;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelFile {

	public WriteExcelFile() {
		// TODO Auto-generated constructor stub
	}
		//Metodo 1 Escribir Una Lista De Datos Al Excel
	
		public void writeExcel(String filepath, String sheetName, String[] dataToWrite) throws IOException {
		
		File file = new File(filepath);
		
		FileInputStream inputStream = new FileInputStream(file);
		
		XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
		
		XSSFSheet newSheet = newWorkbook.getSheet(sheetName);
		
		int rowCount = newSheet.getLastRowNum()-newSheet.getFirstRowNum();
				
		XSSFRow row = newSheet.getRow(0);
		
		XSSFRow newRow = newSheet.createRow(rowCount+1);
		
		for (int i = 0; i < row.getLastCellNum(); i++) {
			XSSFCell newCell = newRow.createCell(i);
			newCell.setCellValue(dataToWrite[i]);
		}
				
		inputStream.close();
		
		FileOutputStream outputStream = new FileOutputStream(file);		//Escribir Informacion en el Excel
		
		newWorkbook.write(outputStream);
		
		outputStream.close();
		
	}
	
	//Metodo 2 Crear Valor en una Celda Especifica
	
	public void writeCellValue(String filepath, String sheetName, int rowNumber, int cellNumber, String resultText) throws IOException {
		
		File file = new File(filepath);
		
		FileInputStream inputStream = new FileInputStream(file);
		
		XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
		
		XSSFSheet newSheet = newWorkbook.getSheet(sheetName);
		
		XSSFRow	row = newSheet.getRow(rowNumber);	//Fila
		
		XSSFCell firstCell = row.getCell(cellNumber-1);
		
		System.out.println("first cell value is: " + firstCell.getStringCellValue());
		
		XSSFCell nextCell = row.createCell(cellNumber);
		nextCell.setCellValue(resultText);
		
		System.out.println("nextcell value:" + nextCell.getStringCellValue());
		
		inputStream.close();
		
		FileOutputStream outputStream = new FileOutputStream(file);
		
		newWorkbook.write(outputStream);
		
		outputStream.close();
		
		
	}
	
}

