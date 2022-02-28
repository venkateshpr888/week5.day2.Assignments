package week5.day2.Assignments;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass_DdParametrization {
	public  String fileName;
	public static ChromeDriver driver;
	@Parameters ({"url"})
	@BeforeMethod
	public void preCondition(String url){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);

}
	@DataProvider(name="Add")
	public String[][] sendData() throws IOException {
		return ReadExcel_Ddparametrization.readData(fileName);
}
	
	@AfterMethod 
	public void postCondition() 
	{
		driver.close();
	}
}
