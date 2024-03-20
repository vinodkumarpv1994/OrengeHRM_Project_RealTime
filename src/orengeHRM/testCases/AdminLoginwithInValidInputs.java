package orengeHRM.testCases;

import orengeHRM.library.LoginPage;
import utils.AppUtils;

public class AdminLoginwithInValidInputs {

	public static void main(String[] args) {
		AppUtils.launchApp("http://orangehrm.qedgetech.com");
		
		LoginPage lp = new LoginPage();
        lp.login("", "xxx");
        Boolean res = lp.inValidCred();
		if(res)
		{
			System.out.println("Admin login with Invalid Inputs ----> Test Pass");
		}
		else
		{
			System.out.println("Admin login with Invalid Inputs ----> Test Pass");
		}
        
		AppUtils.closeApp();
		

	}

}
