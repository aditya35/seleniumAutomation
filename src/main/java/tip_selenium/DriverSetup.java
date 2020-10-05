package tip_selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Scanner;

public class DriverSetup {
	static String workspace = System.getProperty("user.dir");


	public static WebDriver getWebDriver() {
		System.out.println("Enter the browser:");
		System.out.println("1.Chrome");
		System.out.println("2. Firefox");
		System.out.println("Enter the choice: ");
		Scanner sc = new Scanner(System.in);
		int choice = 1;
		WebDriver driver = null;
		switch (choice) {
			case 1:
				//Setup for chrome browser
				WebDriver driver1;
				System.setProperty("webdriver.chrome.driver", workspace+"\\resources\\drivers\\chromedriver_win32\\chromedriver.exe");
				driver1 = new ChromeDriver();
				driver = driver1;
				break;

			case 2:
				//Setup for firefox browser
				WebDriver driver2;
				System.setProperty("webdriver.gecko.driver", workspace+"\\resources\\drivers\\geckodriver-v0.27.0-win64\\geckodriver.exe");
				driver2 = new FirefoxDriver();
				driver = driver2;
				break;
		}
		driver.manage().window().maximize();
		return driver;
	}


}
