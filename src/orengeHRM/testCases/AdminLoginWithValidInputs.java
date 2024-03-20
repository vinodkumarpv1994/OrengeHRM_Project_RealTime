package orengeHRM.testCases;

import orengeHRM.library.LoginPage;
import utils.AppUtils;

public class AdminLoginWithValidInputs {

	public static void main(String[] args) {
		AppUtils.launchApp("http://orangehrm.qedgetech.com");
		
		LoginPage lp = new LoginPage();
		lp.login("Admin", "Qedge123!@#");
		Boolean resTest = lp.isAdminModuleDisplayed();
		if(resTest) {
		System.out.println("Admin Test case is Pass");
		}
		else 
		{
		System.out.println("Admin Test case is Fail");
		}
		lp.logout();
		AppUtils.closeApp();

	}

}
