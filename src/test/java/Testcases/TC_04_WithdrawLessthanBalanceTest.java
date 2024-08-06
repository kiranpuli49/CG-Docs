package Testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import Baseclass.Driver;
import WebPages.DepostANDWithdraw;
import WebPages.WithdrawLessthanBalance;
//This Class contains customer tries to withdraw more than balance by object creation of BankMangerLogin Class
public class TC_04_WithdrawLessthanBalanceTest extends Driver{
	
	@Test
	public void Withdraw_Higherthan_Balance() throws InterruptedException  {
		DepostANDWithdraw DW = new DepostANDWithdraw(driver);
		DW.customerloginButton();
		DW.customerlogin();
		DW.deposit();
		WithdrawLessthanBalance WLB= new WithdrawLessthanBalance(driver);
		WLB.withdrawAmountHigher();
	}

}
