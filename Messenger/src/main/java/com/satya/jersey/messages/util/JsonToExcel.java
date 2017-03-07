package com.satya.jersey.messages.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class JsonToExcel {
	
	private static final String FILE_NAME = "MyWorkBook.xlsx" ;
	public static void main(String[] args) {
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Emp Details");
		Map<String, List<String>> empObjs = new LinkedHashMap<String, List<String>>();
		
		//Dummy empObj added -- it can be commented out--------
		empObjs.put("Emp Name",Arrays.asList("Satya","Ram"));
		empObjs.put("Emp ID", Arrays.asList("1","2"));
		//End of Dummy empObj added -- it can be commented out-
		
		System.out.println("Creating Excel Object");
		
		//Printing Header ROW
		int rowNo = 0;
		Row HeaderRow = sheet.createRow(rowNo++);
		int cellNo = 0;
		for(String key : empObjs.keySet()){
			Cell cell = HeaderRow.createCell(cellNo++);
			cell.setCellValue((String) key);
		}
		//End of Printing Header ROW----------------------
		
		//Printing Remaining Row
		cellNo = 0; //Reseting Cell Counter 
		Row row;
		for (Map.Entry<String,List<String>> emp : empObjs.entrySet()) {
			for(String value:emp.getValue()){
				
				int rownum=1;
				if(sheet.getRow(rownum+1) != null){
					System.out.println("Row exits");
					row= sheet.getRow(rownum+1);
				}else{
					System.out.println("Row doesnot exits");
					row= sheet.createRow(rownum++);
				}
				Cell cell=row.createCell(cellNo);
				cell.setCellValue(value);
				cellNo++;
			}
		}
		//End of Printing Remaining Row------------------
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(FILE_NAME);
			System.out.println("file created");
			workbook.write(fos);
			fos.close();
		} catch (FileNotFoundException e) {
			e.getStackTrace();
		}catch (IOException e) {
            e.printStackTrace();
        }
		finally {
			System.out.println("end");
		}
	}
}
