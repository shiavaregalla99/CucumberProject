package com.hrms.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	private static Workbook book;
	private static Sheet sheet;

	private static void openExcel(String filePath) {
		try {
			FileInputStream fileIS = new FileInputStream(filePath);
			book = new XSSFWorkbook(fileIS);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void loadSheet(String sheetName) {
		sheet = book.getSheet(sheetName);
	}

	private static int rowCount() {
		return sheet.getPhysicalNumberOfRows();
	}

	private static int colsCount(int rowIndex) {
		return sheet.getRow(rowIndex).getLastCellNum();
	}

	private static String cellData(int rowIndex, int colIndex) {
		return sheet.getRow(rowIndex).getCell(colIndex).toString();
	}

	public static List<Map<String,String>> excelintolistofMaps(String filepath,String sheetName){
		openExcel(filepath);
		loadSheet(sheetName);
		List<Map<String,String>> list= new ArrayList<>();
		Map<String,String> excelMap;
		for(int row=1;row<rowCount();row++) {
			excelMap=new LinkedHashMap<>();
			for(int c=0;c<=colsCount(row);c++) {
				excelMap.put(cellData(0,c), cellData(row,c));
			}
			list.add(excelMap);
		}
		return list;
		
	}
}
