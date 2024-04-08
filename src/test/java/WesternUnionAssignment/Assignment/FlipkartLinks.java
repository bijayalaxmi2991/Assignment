	package WesternUnionAssignment.Assignment;

import java.time.Duration;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FlipkartLinks {
	WebDriver driver;
	@BeforeTest
	public void driverSetUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.flipkart.com/");
	}
	
	@Test
	public void getLinks_usingForEachLoop() {
	
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		
		links.forEach((link) -> {
			System.out.println(link.getText());
		});
	}
	
	@Test
	public void getLinks_usingStream() {
		
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		links.stream().map(link -> link.getText()).forEach(System.out::println);;
		
	}
	@Test
	public void getLinks_usingParallelStream() {
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		links.parallelStream().map(link -> link.getText()).forEach(System.out::println);;
		
	}
	
	@Test
	public void getLinks_usingLambda() {
		
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		
		links.forEach(link -> System.out.println(link.getText()));
	}
	
	
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
