package Utilities;
import java.io.File;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	
	private static ExtentReports extent;
	
	public static ExtentReports getInstance() {
		if(extent==null) {
			extent = new ExtentReports(System.getProperty("user.dir")+"\\test-output\\extent.html",true,DisplayOrder.OLDEST_FIRST);
			extent.loadConfig(new File("C:\\Users\\kipuli\\eclipse\\XYZBank_dec\\src\\test\\resource\\extentconfig\\reportconfig.xml"));
		}
		return extent;
		
	}

}
