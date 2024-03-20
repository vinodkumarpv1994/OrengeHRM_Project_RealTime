package orengeHRM.library;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.AppUtils;

public class Employee extends AppUtils
{
   public Boolean addEmployee(String fName, String lName) 
   {
	   //Create new Employee
	   myDriver.findElement(By.linkText("PIM")).click();
	   myDriver.findElement(By.linkText("Add Employee")).click();
	   myDriver.findElement(By.id("firstName")).sendKeys(fName);
	   myDriver.findElement(By.id("lastName")).sendKeys(lName);
	   String newEmpId = myDriver.findElement(By.id("employeeId")).getAttribute("value");
	   myDriver.findElement(By.id("btnSave")).click();
	   
	   //Verify New Employee in Employee List
	   myDriver.findElement(By.linkText("Employee List")).click();
	   myDriver.findElement(By.id("empsearch_id")).sendKeys(newEmpId);
	   myDriver.findElement(By.id("searchBtn")).click();
	   WebElement resTable = myDriver.findElement(By.id("resultTable"));
	   List<WebElement> tableRows = resTable.findElements(By.tagName("tr"));
	   
	   Boolean isEmpIdExit = false;
	   
	   for(int i=1;i<tableRows.size();i++)
	   {
		List<WebElement> tableCol = tableRows.get(i).findElements(By.tagName("td"));
		if(tableCol.get(1).getText().equals(newEmpId))
		{
			isEmpIdExit = true;
		}
		
	   }
	   return isEmpIdExit;
	 
	   
   }
}
