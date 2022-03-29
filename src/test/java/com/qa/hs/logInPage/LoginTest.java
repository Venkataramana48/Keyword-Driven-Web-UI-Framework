package logInPage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import excelUtility.ReadExcelSheet;
import utility.Constant;

public class LoginTest {
	
	public static WebDriver driver;
	
	public void loginSetUp() throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium Jars\\Selenium Projects\\LocalBadabing Project with Selenium"
				+ "\\Badabing Project\\DataDrivenFrameworkUsingPOI\\chromedriver.exe");
System.out.println("************************");
		driver = new ChromeDriver();
		
		
		driver.manage().window().maximize();
		
		
		driver.get(Constant.URL);
		
		driver.manage().timeouts().implicitlyWait(Constant.implicitlyWait, TimeUnit.SECONDS);
		
		ReadExcelSheet rs = new ReadExcelSheet();
		
		ArrayList userName = rs.readExcelData(1);
		ArrayList passWord = rs.readExcelData(2);
		
		for(int i = 0; i<userName.size(); i++) {
			
		WebElement username = driver.findElement(By.id("username"));
		String str1 = (String) userName.get(i);
		username.sendKeys(str1);
		
		WebElement password = driver.findElement(By.id("password"));
		String str2 = (String) passWord.get(i);
		password.sendKeys(str2);
		
		WebElement signIn = driver.findElement(By.xpath("//button[contains(text(),'Sign in')]"));
		signIn.click();
		
		
		}
		
		
		
		
	}

}
