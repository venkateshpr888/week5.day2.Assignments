package week5.day2.Assignments;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel_Ddparametrization {
public static String[][]readData(String fileName) throws IOException {
	XSSFWorkbook workbook = new XSSFWorkbook("./data/"+fileName+".xlsx");
	XSSFSheet sheetAt = workbook.getSheet("Sheet1");
	int row = sheetAt.getLastRowNum();
	System.out.println("row "+row);
	short column = sheetAt.getRow(0).getLastCellNum();
	System.out.println("col "+column);
	String[][] data=new String[row][column];
	for (int i = 1; i <=row; i++) {
		XSSFRow row2 = sheetAt.getRow(i);
		for (int j = 0; j < column; j++) {
			data[i-1][j]=row2.getCell(j).getStringCellValue();
		System.out.println(data);
		}
	}

workbook.close();
return data;
}
}
