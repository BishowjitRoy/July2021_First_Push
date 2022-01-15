package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest_Junit {

	static WebDriver driver;
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("This is Before class !!");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("This is After class !!");
	}
 
	@Before
	public void launchBrowser() {
		System.out.println("This is Launch Browser !!");
		//Launching Chromedriver:
				//1st way launch chromedriver with path
				//System.setProperty("webdriver.chrome.driver", "C:\\Users\\bisho\\OneDrive\\Desktop\\July2021_Selenium\\Session1\\driver\\chromedriver.exe");
				
				// 2nd way to launch chromedriver with path
				//System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
				
				//3rd way to launch chromedriver with path
				//System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
				
				// 4th way to launch chromedriver with path
				System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
				
				driver = new ChromeDriver();
				
//				Go to the techfios website
				driver.get("https://techfios.com/billing/?ng=admin");
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				
			}
	
	@Test
	public void loginTest() throws InterruptedException {
		System.out.println("This is Login Test !!");
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();
		Thread.sleep(3000);
				
		}
	
	@Test
	public void negLoginTest() throws InterruptedException {
		System.out.println("This is Negetive Login Test !!");
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc12304");
		driver.findElement(By.name("login")).click();
		driver.findElement(By.className("btn btn-success block full-width")).click();
		Thread.sleep(3000);
	}
	
	@After
	public void tearDown() {
		System.out.println("This is Tear Down !!");
		driver.close();
		driver.quit();
	}
	
}	
	

	

