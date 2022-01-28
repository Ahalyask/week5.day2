package week5.day2classroomexercise;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static String[][] readExcel(String fileName) throws IOException {
				
		XSSFWorkbook wb = new XSSFWorkbook("./data/"+fileName+".xlsx");
		XSSFSheet ws = wb.getSheetAt(0);
		int lastRowNum = ws.getLastRowNum();
		int lastCellNum = ws.getRow(0).getLastCellNum();
		String[][] data = new String[lastRowNum][lastCellNum];	
		
		for(int i=1; i<=lastRowNum;i++) {
			XSSFRow row = ws.getRow(i);
			
		for(int j=0; j<lastCellNum;j++) {
			XSSFCell cell = row.getCell(j);					
			String stringCellValue = cell.getStringCellValue();
			data[i-1][j]=stringCellValue;
			System.out.println(stringCellValue);
		}
		}
		return data;
	}

}
