package DataDrivenTesting;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

	public ReadExcelFile() {
		// TODO Auto-generated constructor stub
	}
	
		//Metodo General / Leer una hoja de excel fila x fila / celdas de las filas
	
		public void readExcel( String filepath, String sheetName) throws IOException {
		
		File file = new File(filepath);      //CrearElArchivo
		
		FileInputStream inputStream = new FileInputStream(file);   //LeerLosDatosDelArchivo
		
		XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);  //CrearLibroExcel
		
  		XSSFSheet newSheet = newWorkbook.getSheet(sheetName);    //CrearLaHoja
		
		int rowCount = newSheet.getLastRowNum() + newSheet.getFirstRowNum();
		
		for (int i = 0; i <= rowCount; i++) {
			XSSFRow row = newSheet.getRow(i);
			
			for (int j = 0; j < row.getLastCellNum(); j++) {     //Suponiendo que todas las filas tendran la misma cantidad de celdas
				System.out.println(row.getCell(j).getStringCellValue() + "||");
				
			}
			
		}
	}
	
		//MetodoLeerValorEspecificoDeUnaCelda
	
		public String getCellValue(String filepath, String sheetName, int rowNumber, int cellNumber) throws IOException {
		
		File file = new File(filepath);
		
		FileInputStream inputStream = new FileInputStream(file);
		
		XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
		
		XSSFSheet newSheet = newWorkbook.getSheet(sheetName);
		
		XSSFRow row = newSheet.getRow(rowNumber);
		
		XSSFCell cell = row.getCell(cellNumber);
		
		String cellValue = "";
		
		if (cell != null) {
	        if (cell.getCellType() == CellType.STRING) {
	            cellValue = cell.getStringCellValue();
	        } else if (cell.getCellType() == CellType.NUMERIC) {
	        	double numericValue = cell.getNumericCellValue();
	        	if (numericValue == (int) numericValue) {
	        		cellValue = String.format("%d", (int) numericValue);
	        	}else {
	                cellValue = String.valueOf(numericValue);
	            }
	        }
		}
	        return cellValue;
		
		
	}  	
}
