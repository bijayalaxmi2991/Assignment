package WesternUnionAssignment.Assignment;

import java.io.FileInputStream;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	public HashMap<String,String> readStockValueFromExcel(){
		HashMap<String,String> stockPrices = new HashMap<String, String>();		
		try
        {
            FileInputStream file = new FileInputStream(".\\StockPrices.xlsx");
 
            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook wb = new XSSFWorkbook(file);
 
            //Get first/desired sheet from the workbook
            XSSFSheet ws = wb.getSheet("Stocks");
            
            int rows = ws.getLastRowNum();
            for(int i=1;i<=rows;i++) {
            	String company="", value="";
    
            	company= ws.getRow(i).getCell(0).getStringCellValue();
            	value =  ws.getRow(i).getCell(1).getRawValue();
            	
            	stockPrices.put(company,value);
            	
            }
           
            file.close();
        } 
        catch (Exception ex) 
        {
            ex.printStackTrace();
        }
		System.out.println(stockPrices);
		return stockPrices;

	}
}
