package orengeHRM.testCases;

import orengeHRM.library.LoginPage;
import utils.AppUtils;

public class EmployessLogin_ValidInputs {

	public static void main(String[] args) {
		AppUtils.launchApp("http://orangehrm.qedgetech.com");
		
		LoginPage lp = new LoginPage();
		lp.login("UdayKumar", "Vinod@1994");
		Boolean resTest = lp.isEmployeeModuleDisplayed();
		if(resTest) {
		System.out.println("Employee Test case ---> Pass");
		}
		else 
		{
		System.out.println("Admin Test case ---> Fail");
		}
		lp.logout();
		AppUtils.closeApp();

	}


}
