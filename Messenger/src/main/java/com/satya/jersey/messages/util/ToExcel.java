package com.satya.jersey.messages.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ToExcel {
	private String FILE_NAME;
	private FileOutputStream fos = null;
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private String Result;

	public String MapToExcel(String FILE, LinkedHashMap<String, List<Object>> data) {
		this.FILE_NAME = FILE;
		// Workbook created
		workbook = new XSSFWorkbook();
		// WorkSheet Created
		sheet = workbook.createSheet("Emp Details");
		// Map Object added
		Map<String, List<Object>> empObjs = data;
		//System.out.println("Creating Excel Object----------------");
		Cell cell = null;
		int rowCounter = 0;
		Row row = sheet.createRow(rowCounter++);
		int cellCounter = 0;
		// Printing Header ROW-----------------------------
		for (String key : empObjs.keySet()) {
			cell = row.createCell(cellCounter++);
			cell.setCellValue((String) key);
			//System.out.println(row.getLastCellNum());
		}
		// End of Printing Header ROW----------------------
		// Printing Remaining Row
		cellCounter = 0; // Reseting Cell Counter
		rowCounter = 1;
		for (Map.Entry<String, List<Object>> emp : empObjs.entrySet()) {

			for (Object value : emp.getValue()) {
				if (sheet.getRow(rowCounter + 1) != null) {
					//System.out.println("Row exits");
					row = sheet.getRow(rowCounter++);
				} else {
					//System.out.println("Row doesnot exits");
					row = sheet.createRow(rowCounter++);
				}
				if (row.getCell(cellCounter) != null) {
					//System.out.println("cell doesnot exits");
				}
				cell = row.createCell(cellCounter);
				//System.out.println(value);

				if (value instanceof String) {
					cell.setCellValue((String) value);
				} else if (value instanceof Integer) {
					cell.setCellValue((Integer) value);
				}
			}
			cellCounter++;
			rowCounter = 1;

		}
		// End of Printing Remaining Row------------------
		try {
			fos = new FileOutputStream(FILE_NAME);
			//System.out.println("file created");
			workbook.write(fos);
			fos.close();
			Result="Sucessfully ended";
		} catch (FileNotFoundException e) {
			Result="Error";
		} catch (IOException e) {
			Result="Error";
		}
		return Result;

	}

}
