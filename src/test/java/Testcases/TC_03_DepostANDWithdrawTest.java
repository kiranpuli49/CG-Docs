package Testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import Baseclass.Driver;
import WebPages.DepostANDWithdraw;
//This Class contains Customer Deposit and Withdraw by object creation of DepositandWithdraw Class
public class TC_03_DepostANDWithdrawTest extends Driver{
	
	@Test
	
public void Deposit_and_withdraw() {
		
		DepostANDWithdraw DW = new DepostANDWithdraw(driver);
		DW.customerloginButton();
		DW.customerlogin();
		DW.deposit();
		DW.withdrawAmount();		
	}

}
