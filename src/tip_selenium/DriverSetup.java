package tip_selenium;

import java.util.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSetup {
	
	 
	public static WebDriver getWebDriver() {
		// TODO Auto-generated method stub
	 System.out.println("Enter the browser:");
     System.out.println("1.Chrome");
     System.out.println("2. Firefox");
     System.out.println("Enter the choice: ");
     Scanner sc = new Scanner(System.in);
     int choice = sc.nextInt();
     WebDriver driver=null; 
     switch (choice){
     case 1:
    	 //Setup for chrome browser
    	  WebDriver driver1;
    	  System.setProperty("webdriver.chrome.driver","C:\\Users\\870653\\Downloads\\chromedriver_win32\\chromedriver.exe");
     	  driver1 = new ChromeDriver();
     	  driver = driver1;
     	  break;
    
     case 2:
    	 //Setup for firefox browser
    	 WebDriver driver2;
    	 System.setProperty("webdriver.gecko.driver","C:\\Users\\870653\\Downloads\\geckodriver-v0.27.0-win64\\geckodriver.exe");
    	 driver2 = new FirefoxDriver();
    	 driver = driver2;
    	 break;
     }
     driver.manage().window().maximize();
     return driver;
	}


}
