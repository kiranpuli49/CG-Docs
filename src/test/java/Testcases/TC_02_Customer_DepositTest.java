package Testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import Baseclass.Driver;
import WebPages.Customer_Deposit;
//This Class contains Customer  deposit Operations by object creation of Customer_Deposit Class
public class TC_02_Customer_DepositTest extends Driver{
	@Test
	public void Customer_Deposit()  {
		Customer_Deposit cs =  new Customer_Deposit(driver);
		cs.customerlogin();
		cs.deposit();
		cs.Transactions();
	}

}
