package orengeHRM.testCases;

import orengeHRM.library.LoginPage;
import orengeHRM.library.User;
import utils.AppUtils;

public class NewUserRegistration {

	public static void main(String[] args) throws InterruptedException {
        AppUtils.launchApp("http://orangehrm.qedgetech.com");
		
		LoginPage lp = new LoginPage();
		lp.login("Admin", "Qedge123!@#");
		
		User us = new User();
		Boolean resTestCase = us.userRegistration("ESS", "Venkata Demo", "VenkataDemo", "Vinod@1994");
		if(resTestCase)
		{
			System.out.println("New User Registration is suceessfull---> Test Pass");
		}
		else 
		{
			System.out.println("New User not registred ---> Test Fail");
		}
		
		lp.logout();
		AppUtils.closeApp();

	}

}
