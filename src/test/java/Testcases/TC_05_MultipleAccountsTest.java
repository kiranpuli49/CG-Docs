package Testcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Baseclass.Driver;
import WebPages.BankManagerLogin;
import WebPages.MultipleAccounts;
//This Class  contains customers having multiple accounts by object creation of MultipleAccounts Class & BankManagerLogin Class
public class TC_05_MultipleAccountsTest extends Driver{
	
	
	@Test(dataProvider = "getData")
	public void Customer_MultipleAccounts(String Firstname,String Lastname,String Pincode)    {
		BankManagerLogin BML = new BankManagerLogin(driver);
		BML.ClickBMlogin();
		BML.ADDCustomer(Firstname,Lastname,Pincode);
		MultipleAccounts MA= new MultipleAccounts(driver);
		MA.multipleacc();
		MA.OpenAccount();
		MA.CustomersList();
		
	}
	@DataProvider
	public Object[][] getData() {
		String sheetname = "ADDCUSTOMER";
		int rows = excel.getRowCount(sheetname);
		int cols = excel.getColumnCount(sheetname);
		Object[][] data = new Object[rows - 1][cols];// object[1][1]
		for (int rowNum = 2; rowNum <= rows; rowNum++) {
			for (int colNum = 0; colNum < cols; colNum++) {
				// data[0][0]
				data[rowNum - 2][colNum] = excel.getCellData(sheetname, colNum, rowNum);

			}
		}
		return data;
	}
}
