package WesternUnionAssignment.Assignment;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Stocks_MoneyRediff {

	WebDriver driver;
	
	@BeforeTest
	public void driverSetUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://money.rediff.com/losers/bse/daily/groupall?");
	}
	
	@Test
	public void validateStockPrices() {
		HashMap<String,String> stockPricesDisplayed = readStockValueFromMoneyRediff();
		ReadExcel obj = new ReadExcel();
		HashMap<String,String> stockPricesExpected = obj.readStockValueFromExcel();
		assertTrue(stockPricesDisplayed.equals(stockPricesExpected), "The displayed values are not as expected");
	}
	
	
	public HashMap<String, String> readStockValueFromMoneyRediff() {
		List<WebElement> companies = driver.findElements(By.xpath("//table[@class=\"dataTable\"]//tr/td[1]"));		
		HashMap<String,String> stockPricesDisplayed = new HashMap<String, String>();
		System.out.println(companies.size());
		for(int i=0;i<10;i++) {
			String name = companies.get(i).getText();
			WebElement wb =  driver.findElement(By.xpath("(//table[@class='dataTable']//tr/td[4])["+(i+1)+"]"));
			String stockValue = wb.getText();
			stockPricesDisplayed.put(name, stockValue);
		}
		System.out.println(stockPricesDisplayed);
		return stockPricesDisplayed;
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
	
}
