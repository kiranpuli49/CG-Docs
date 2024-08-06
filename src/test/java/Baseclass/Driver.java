package Baseclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import Utilities.ExcelReader;
import Utilities.ExtentManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {
    public static WebDriver driver;	
    public static ExtentReports report = ExtentManager.getInstance();
	public static ExtentTest test;
	public static Properties OR = new Properties();
	public static FileInputStream fis;
          
    public static ExcelReader excel = new ExcelReader(
    		"C:\\Users\\kipuli\\eclipse\\XYZBank_dec\\src\\test\\resource\\excel\\exceldata.xlsx");
          
    
	@BeforeClass
	public void browsersetup() throws IOException{	
		
	WebDriverManager.chromedriver().setup();
	
	driver = new ChromeDriver();
		
		driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
		driver.manage().window().maximize();
		
		fis = new FileInputStream(
		"C:\\Users\\kipuli\\eclipse\\XYZBank_dec\\src\\test\\resource\\Properties\\OR.properties");
		OR.load(fis);
				
	}
	@AfterClass
	public void closeBrowser() {
		if(driver != null)
		driver.quit();
	}
	
	

}
