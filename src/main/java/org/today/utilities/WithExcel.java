package org.today.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WithExcel {

	File f ;
	FileInputStream fis ;
	XSSFWorkbook wb ;
	XSSFSheet sheet ;
	
	
	public WithExcel(String sheets, String path) throws IOException {
		
		f = new File(path);
		fis = new FileInputStream(f);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(sheets);
	}
	
	public int rowCount() {
		int lastRowNum = sheet.getLastRowNum();
		lastRowNum = lastRowNum + 1 ;
		return lastRowNum;
	}

	public short columnCount() {
		short lastCellNum = sheet.getRow(0).getLastCellNum();
		return lastCellNum;
	}
	
	public String getData(int r, int c) {
		String stringCellValue = sheet.getRow(r).getCell(c).getStringCellValue();
		return stringCellValue;
	}
}
