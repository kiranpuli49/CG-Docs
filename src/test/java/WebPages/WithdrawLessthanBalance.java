package WebPages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class WithdrawLessthanBalance extends Base{
	
	WebDriver driver;

	public WithdrawLessthanBalance(WebDriver driver) {
		this.driver = driver;
	}
	
	public void withdrawAmountHigher() throws InterruptedException   {
		SoftAssert SA = new SoftAssert();
		try {
		ExplicitwaitVis("withdrawlButton");
		click("withdrawlButton");
		Thread.sleep(2000);
		type("withdrawAmount","5000");
		System.out.println("withdraw amount:5000");	
		click("withdraw");}
		catch(NoSuchElementException e) {
			System.out.println("No Element "+e.getMessage());
		}
		String actualwithdraw=getText("withdrawfailsmeg");
		System.out.println("Transaction error message:"+actualwithdraw);
		screenshot("FailureTransaction");
		String Expected="Transaction Failed. You can not withdraw amount more than the balance.";
		Assert.assertEquals(Expected, actualwithdraw);
		click("home");
		//SA.assertAll();
		System.out.println("done");
		
	}	
	
}
