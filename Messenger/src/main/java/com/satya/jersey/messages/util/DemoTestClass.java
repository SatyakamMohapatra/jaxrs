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

public class DemoTestClass {
	
	private static final String FILE_NAME = "MyWorkBook.xlsx" ;
	
	public static void main(String[] args) {
		LinkedHashMap<String, List<Object>> empObjs = new LinkedHashMap<String, List<Object>>();
		//Dummy empObj added -- it can be commented out--------
				empObjs.put("Emp Name",Arrays.asList("Satya","Ram","Sam","qaz"));
				empObjs.put("Emp ID", Arrays.asList(13,2,45,55));
				empObjs.put("Emp age", Arrays.asList(13,2,45,55));
		//End of Dummy empObj added -- it can be commented out-
	    ToExcel excel = new ToExcel();
	    excel.MapToExcel(FILE_NAME, empObjs);
}
}
