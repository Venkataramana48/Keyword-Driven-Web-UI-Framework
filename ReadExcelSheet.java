package excelUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import utility.Constant;

public class ReadExcelSheet {

	public ArrayList readExcelData(int colNo) throws IOException {
		
		File file = new File(Constant.filePath);
		
		
			FileInputStream fis = new FileInputStream(file);
			
			
				XSSFWorkbook wb = new XSSFWorkbook(fis);
				XSSFSheet sheet = wb.getSheet("login");
				
				Iterator<Row> row = sheet.rowIterator();
				row.next();
				
				ArrayList<String> ar = new ArrayList<String>();
				
				while(row.hasNext()) {
					Row r = row.next();
					
					Cell c = r.getCell(colNo);
					
					String data = c.getStringCellValue();
					
					ar.add(data);
				}
				
				System.out.println("List :" +ar);

				return ar;
				
			
		
		
	}
	

}
