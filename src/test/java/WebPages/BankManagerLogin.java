package WebPages;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


/* Bank Manager operations */
public class BankManagerLogin extends Base {

	WebDriver driver;

	public BankManagerLogin(WebDriver driver) {
		this.driver = driver;
	}
   /* Bank Manager Login  */
	public void ClickBMlogin() {
		ExplicitwaitVis("BankManagerloginB");	
		click("BankManagerloginB");
	}
	/* Bank Manager able to ADD Customers  */
	public void ADDCustomer(String Firstname,String Lastname,String Pincode){
		ExplicitwaitVis("addcustomerButton");
		assertTrue(isElementPresent(By.xpath(OR.getProperty("addcustomerButton"))));
		click("addcustomerButton");	
		ExplicitwaitVis("firstname");
		try {
		type("firstname", Firstname);		
		type("lastname",Lastname);		
		type("pincode",Pincode);
		click("Submit");}
		catch (Exception e) {
			System.out.println("Unexpected error :" + e.getMessage());
		}
		
		try {
			explicitwait();}
			catch(NoAlertPresentException e){
				System.out.println("No Alert Present to switch");
			}
		
		String act=driver.switchTo().alert().getText();
		System.out.println(act);
		Assert.assertTrue(act.contains("Customer added successfully with customer id "));
		String []act1=act.split(":");
		int customerID= Integer.parseInt(act1[1]);
		String exp="Customer added successfully with customer id :"+customerID;
		Assert.assertEquals(act, exp);	
		driver.switchTo().alert().dismiss();
		
		
			
	}	
	/* Bank Manager Open the Accounts for Customers  */
	public void OpenAccount() {
		ExplicitwaitVis("openaccountButton_CSS");
		click("openaccountButton_CSS");	
		ExplicitwaitVis("customername_CSS");
		try {
		select("customername_CSS",6);	
		select("Currency_CSS",2);
		click("Process_CSS");}
		catch(Exception e) {
			System.out.println("Unexpected error :" +e.getMessage());
		}
		
		try {
		explicitwait();}
		catch(NoAlertPresentException e){
			System.out.println("No Alert Present to switch");
		}
		String act=driver.switchTo().alert().getText();
		String []act1=act.split(":");
		int Accountnumber= Integer.parseInt(act1[1]);
		System.out.println(act);
		String exp="Account created successfully with account Number :"+Accountnumber;
		Assert.assertEquals(act, exp);
		driver.switchTo().alert().dismiss();	
		
	}	
	/* customersList  */
	public void Customers() {
		ExplicitwaitVis("CustomersButton");
		click("CustomersButton");
		assertTrue(isElementPresent(By.xpath(OR.getProperty("CustomersButton"))));
		FluentWait(By.xpath(OR.getProperty("Searchname")));
		try {
			type("Searchname", "Kiran");
			screenshot("CustomerSearch");
			click("delete");
			click("home");
		} catch (Exception e) {
			System.out.println("Unexpected error :" + e.getMessage());
		}
				
	}

}
