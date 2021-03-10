package Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Pages.TestBase;



public class ExcelUtils {

	public static Map<String,List<String>> readExcel(String testSuite) {

		Map<String, List<String>> testSuiteData = new HashMap<String, List<String>>();


		try {
			FileInputStream fis = new FileInputStream(testSuite);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheetAt(0);
			for(int k=0;k<=sheet.getLastRowNum();k++) {
				
				String key;
				
				List<String> value = new ArrayList<String>();

				//read method name as key
				//key = row.getCell(1).getStringCellValue();	
				key=sheet.getRow(k).getCell(1).getStringCellValue();
				
				
				for(int j=2;j<sheet.getRow(k).getLastCellNum();j++) {
					String strCell = sheet.getRow(k).getCell(j).getStringCellValue();
					value.add(strCell);
				}
				
				testSuiteData.put(key, value);
				
			}
			
			wb.close();	

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}

		return testSuiteData;
	}

	
	/*
	 * @description : reads the data from a map corresponding to the key passed as String argument
	 * @param  : key for which data is to be fetched
	 * @param  : map in which data is stored
	 * @return : row data as a list
	 * @date   : 04 Feb 2019
	 * @author : Jewel R
	 */
	public static List<String> getTestData(String methodName, Map<String,List<String>> testSuiteData) {

		List<String> testData = new ArrayList<String>();

		testData = testSuiteData.get(methodName);

		return testData;
	}

}
