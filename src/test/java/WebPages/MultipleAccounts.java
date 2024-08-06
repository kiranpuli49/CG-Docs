package WebPages;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class MultipleAccounts extends Base{	
	WebDriver driver;

	public MultipleAccounts(WebDriver driver) {
		this.driver = driver;
	}
	/* Bank Manager add duplicate data */
	public void multipleacc()  {
		try {
			
			type("firstname", "Kiran");
			type("lastname", "Puli");
			type("pincode", "53112EB");
			click("Submit");
		} catch (Exception e) {
			System.out.println("Unexpected error :" + e.getMessage());
		}
		try {
			explicitwait();
		} catch (NoAlertPresentException e) {
			System.out.println("No Alert Present to switch");
		}
		String act = driver.switchTo().alert().getText();
		System.out.println(driver.switchTo().alert().getText());
		Assert.assertTrue(act.contains("Please check the details. Customer may be duplicate."));
		try {
			driver.switchTo().alert().dismiss();
		} catch (NoAlertPresentException e) {
			System.out.println("No Alert Present to dismiss");
		}
	}
	/* Bank Manager open Multiple Accounts */
	public void OpenAccount() {
		ExplicitwaitVis("openaccountButton_CSS");
		try {
			click("openaccountButton_CSS");
			ExplicitwaitVis("customername_CSS");
			select("customername_CSS", 6);
			select("Currency_CSS", 3);
			click("Process_CSS");
			explicitwait();
		} catch (Exception e) {
			System.out.println("Unexpected error :" + e.getMessage());
		}
		String act=driver.switchTo().alert().getText();	
		
		String []act1=act.split(":");
		int Accountnumber= Integer.parseInt(act1[1]);		
		System.out.println("account with Rupee  :"+act);
		String exp="Account created successfully with account Number :"+Accountnumber;
		Assert.assertEquals(act, exp);
		driver.switchTo().alert().dismiss();
		try {
		select("customername_CSS",6);
		select("Currency_CSS",2);
		click("Process_CSS");}
		catch (Exception e) {
			System.out.println("Unexpected error :" + e.getMessage());
		}
		String act2=driver.switchTo().alert().getText();
		System.out.println("account with Pound :"+act2);
		String []act3=act2.split(":");
		int Accountnumber2= Integer.parseInt(act3[1]);	
		String exp2="Account created successfully with account Number :"+Accountnumber2;
		Assert.assertEquals(act2, exp2);
		driver.switchTo().alert().dismiss();		
	}
	/* Customer List  Associated with Account Numbers*/
	public void CustomersList() {
		ExplicitwaitVis("CustomersButton");
		try {
			click("CustomersButton");
			ExplicitwaitVis("Searchname");
			type("Searchname", "kiran");
		} catch (Exception e) {
			System.out.println("Unexpected error"+e.getMessage());
		}
		System.out.println("List of Accounts for Customer: "+getText("Accounts"));
		String ACT=getText("Accounts");
		String EXP="1016 1017";
		Assert.assertEquals(EXP, ACT);
		System.out.println("Accounts Validated");
		screenshot("MultipleAccounts");	
	}	
}
