package orengeHRM.testCases;

import orengeHRM.library.Employee;
import orengeHRM.library.LoginPage;
import utils.AppUtils;

public class NewEmployeeRegistration {

	public static void main(String[] args) {
		AppUtils.launchApp("http://orangehrm.qedgetech.com");
		
		LoginPage lp = new LoginPage();
		lp.login("Admin", "Qedge123!@#");
		
		Employee emp = new Employee();
		Boolean resTestCase = emp.addEmployee("Venkata", "Demo");
		if(resTestCase)
		{
			System.out.println("New Employee Registration is suceessfull---> Test Pass");
		}
		else 
		{
			System.out.println("New Employee is registred ---> Test Fail");
		}
		
		lp.logout();
		AppUtils.closeApp();
		

	}

}
