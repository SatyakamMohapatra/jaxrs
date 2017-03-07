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
		Map<String, List<Object>> empObjs = new LinkedHashMap<String, List<Object>>();
		
		//Dummy empObj added -- it can be commented out--------
		empObjs.put("Emp Name",Arrays.asList("Satya","Ram","Sam","qaz"));
		empObjs.put("Emp ID", Arrays.asList(13,2,45,56));
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
		int rownum=1;
		for (Map.Entry<String,List<Object>> emp : empObjs.entrySet()) {
			for(Object value:emp.getValue()){
				if(sheet.getRow(rownum+1) != null){
					System.out.println("Row exits");
					row= sheet.getRow(rownum+1);	
				}else{
					System.out.println("Row doesnot exits");
					row= sheet.createRow(rownum++);
				}
				Cell cell=row.createCell(cellNo);
				System.out.println(value);
				
				if(value instanceof String){
					cell.setCellValue((String)value);
				}if(value instanceof Integer){
					cell.setCellValue((Integer)value);
				}
				
			}
			rownum=1;
			cellNo++;
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
