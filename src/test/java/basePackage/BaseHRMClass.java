package basePackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utility.timeutils;

public class BaseHRMClass {

	public static Properties prop=new Properties();
	public static WebDriver driver;
	
	//Step1
	public BaseHRMClass() {
		try {
	FileInputStream file=new FileInputStream("C:\\Jamuna\\Eclipse\\HRmanagement\\src\\test\\java\\environmentvariables\\Config.properties");	
		prop.load(file);
			
		}
	catch(FileNotFoundException e) {
		e.printStackTrace();
        }
		
		catch(IOException a) {
		a.printStackTrace();
		}
	}
	//Step2
		
		public static void initiation() {
		String browsername =prop.getProperty("browser");
		
		if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "chrome.exe");
			
			driver=new ChromeDriver();}
		else if(browsername.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(timeutils.timepage, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
				
				
				
				
				
		}
		
		
		
		
		
}}