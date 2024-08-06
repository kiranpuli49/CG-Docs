package Testcases;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Baseclass.Driver;
import WebPages.BankManagerLogin;

//This Class contains All Bank Manager Operations by object creation of BankMangerLogin Class
public class TC_01_BankMangerLoginTest extends Driver{

	@Test(dataProvider = "getData")
	public void BankManagerLogin(String Firstname,String Lastname,String Pincode)  {
		BankManagerLogin BML = new BankManagerLogin(driver);
		BML.ClickBMlogin();
		BML.ADDCustomer(Firstname,Lastname,Pincode);
		BML.OpenAccount();
		BML.Customers();	
	}
	
	@DataProvider
	public Object[][] getData() {
		String sheetname = "ADDCUSTOMER"; // Sheet Name
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
