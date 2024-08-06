package WebPages;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class Customer_Deposit extends Base{	
	WebDriver driver;
	public Customer_Deposit(WebDriver driver) {
		this.driver = driver;
	}
	
	/* Customer deposit functionality /* Customer Login */	
	public void customerlogin() {
		ExplicitwaitVis("CustomerLoginButton");
		click("CustomerLoginButton");
		ExplicitwaitVis("yourname");
		select("yourname",2);
		click("login");	
		
	}
	public void deposit() {
		try {
			FluentWait(By.xpath(OR.getProperty("depositButton")));
			click("depositButton");
			ExplicitwaitVis("Amount");
			type("Amount", "1000");
			click("submit");
		} catch (Exception e) {
			System.out.println("Unexpected error :" + e.getMessage());
		}
		String s = getText("sucessmsg");
		System.out.println("Desposit message:" + getText("sucessmsg"));
		Assert.assertTrue(s.contentEquals("Deposit Successful"));
		screenshot("DepositSucessful");
		String act = getText("validBalance");
		System.out.println("Available Balance  :" + getText("validBalance"));
		int exp = 1000;
		int act1 = Integer.parseInt(act);
		Assert.assertEquals(exp, act1);
		System.out.println("Validated Balance");
	}
	/* Transactions History */
	public void Transactions() {
		try {
			FluentWait(By.xpath(OR.getProperty("TransButton")));
			click("TransButton");
			ExplicitwaitVis("Reset");
			click("Reset");
			click("back");
		}

		catch (Exception e) {
			System.out.println("Unexpected error :" + e.getMessage());
		}
		String act = getText("validBalance");
		int exp = 0;
		int act1 = Integer.parseInt(act);
		Assert.assertEquals(exp, act1);
		System.out.println("Available Balance after reset  :" + getText("validBalance"));
		screenshot("AfterResetTransaction");
		assertTrue(isElementPresent(By.xpath(OR.getProperty("logout"))));
		click("logout");
		
	}

}
