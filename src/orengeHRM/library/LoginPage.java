package orengeHRM.library;

import org.openqa.selenium.By;


import utils.AppUtils;

public class LoginPage extends AppUtils
{
	public void login(String uid, String pwd)
	{
		myDriver.findElement(By.id("txtUsername")).sendKeys(uid);
		myDriver.findElement(By.id("txtPassword")).sendKeys(pwd);
		myDriver.findElement(By.id("btnLogin")).click();
	}
	
	public Boolean isAdminModuleDisplayed() 
	{
		try 
		{
			myDriver.findElement(By.linkText("Admin")).isDisplayed();
			return true;
		} 
		catch (Exception e) 
		{
			return false;
		}
				
	}
	
	public Boolean isEmployeeModuleDisplayed() 
	{
        try 
        {
        	myDriver.findElement(By.linkText("Admin")).isDisplayed();	
        	return false;
		} 
        catch (Exception e) 
        {
        	return true;
		}
		
	}
	
	public void logout()
	{
		myDriver.findElement(By.partialLinkText("Welcome")).click();
		myDriver.findElement(By.linkText("Logout")).click();
	}
	
	public Boolean inValidCred()
	{
		String errorMessage = myDriver.findElement(By.id("spanMessage")).getText();
		
		if(errorMessage.toLowerCase().contains("invalid") || errorMessage.toLowerCase().contains("empty"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
}
