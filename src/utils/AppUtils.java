package utils;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppUtils
{
   public static WebDriver myDriver;
   
   public static void launchApp(String url)
   {
	   System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	   
	   myDriver = new ChromeDriver();
	   myDriver.manage().deleteAllCookies();
	   myDriver.manage().window().maximize();
	   myDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   myDriver.get(url);
   }
   
   public static void closeApp()
   {
      myDriver.close();
   }
}
