package orengeHRM.library;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import utils.AppUtils;

public class User extends AppUtils
{
	public Boolean userRegistration(String role, String empName, String userName, String pwd) throws InterruptedException 
	{
	   //Navigation to new user registration page
		
       myDriver.findElement(By.linkText("Admin")).click();
       Actions act = new Actions(myDriver);
       act.moveToElement(myDriver.findElement(By.linkText("User Management")));
       act.build().perform();
       myDriver.findElement(By.linkText("Users")).click();
       myDriver.findElement(By.id("btnAdd")).click();
       
       //Enter details in user registration page
       
       Select userRole = new Select(myDriver.findElement(By.id("systemUser_userType")));
       userRole.selectByVisibleText(role);
       myDriver.findElement(By.id("systemUser_employeeName_empName")).sendKeys(empName);
       myDriver.findElement(By.id("systemUser_userName")).sendKeys(userName);
       Select userStatus = new Select(myDriver.findElement(By.id("systemUser_status")));
       userStatus.selectByVisibleText("Enabled");
       myDriver.findElement(By.id("systemUser_password")).sendKeys(pwd);
       Thread.sleep(2000);
       myDriver.findElement(By.id("systemUser_confirmPassword")).sendKeys(pwd);
       Thread.sleep(2000);
       myDriver.findElement(By.id("btnSave")).click();
       
       //verify new user is displayed in user table or not?
       
       myDriver.findElement(By.id("searchSystemUser_userName")).sendKeys(userName);
       myDriver.findElement(By.id("searchBtn")).click();
       
       WebElement resTable = myDriver.findElement(By.id("resultTable"));
	   List<WebElement> tableRows = resTable.findElements(By.tagName("tr"));
	   
       Boolean isEmpIdExit = false;
	   
	   for(int i=1;i<tableRows.size();i++)
	   {
		List<WebElement> tableCol = tableRows.get(i).findElements(By.tagName("td"));
		if(tableCol.get(1).getText().equals(userName))
		{
			isEmpIdExit = true;
		}
		
	   }
	   return isEmpIdExit;

       
	}
}
