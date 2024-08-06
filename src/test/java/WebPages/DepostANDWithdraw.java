package WebPages;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DepostANDWithdraw extends Base {

	WebDriver driver;

	public DepostANDWithdraw(WebDriver driver) {
		this.driver = driver;
	}

	/* Customer Login Button */
	public void customerloginButton() {
		ExplicitwaitVis("CustomerLoginButton");
		click("CustomerLoginButton");
	}

	/* Customer Login */
	public void customerlogin() {
		try {
			ExplicitwaitVis("yourname");
			select("yourname", 2);
			Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("login"))));
			click("login");
		} catch (NoSuchElementException e) {
			System.out.println("Element not found:" + e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/* customer Deposit */
	public void deposit() {
		FluentWait(By.xpath(OR.getProperty("depositButton")));
		click("depositButton");
		ExplicitwaitVis("Amount");
		type("Amount", "1000");
		click("submit");
		System.out.println(getText("sucessmsg"));
		System.out.println("Available Balance  :" + getText("validBalance"));
	}

	/* Withdraw the Amount */
	public void withdrawAmount() {
		String act = getText("validBalance");
		int amount = 500;
		try {
			ExplicitwaitVis("withdrawlButton");
			click("withdrawlButton");
			Thread.sleep(2000);
			type("withdrawAmount", "500");
			System.out.println("withdraw amount:500");
			ExplicitwaitVis("withdraw");
			click("withdraw");
			ExplicitwaitVis("withdrawsuccesmeg");
			String actualwithdraw = getText("withdrawsuccesmeg");
			screenshot("Withdraw_Sucessfully");
			System.out.println("Transaction success msg :" + actualwithdraw);
			String Except = "Transaction successful";
			Assert.assertEquals(Except, actualwithdraw);

		} catch (AssertionError e) {
			System.out.println("Assert Fail" + e.getMessage());

		} catch (Exception e) {
			System.out.println(e.getMessage());

		} finally {
			int act1 = Integer.parseInt(act);
			int ExceptedBalance = act1 - amount;
			String updatedBalance = getText("validBalance");
			int Actual = Integer.parseInt(updatedBalance);
			Assert.assertEquals(ExceptedBalance, Actual);
			System.out.println("Validated Balance after withdraw :" + getText("validBalance"));
			click("home");

		}

	}
}
