package variousConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		launchBrowser();
		loginTest();
		tearDown();
		
		launchBrowser();
		negLoginTest();
		tearDown();
	}
		
		// Multiple method
	public static void launchBrowser() {
		
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
				
				// Go to the techfios website
				driver.get("https://techfios.com/billing/?ng=admin");
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				
			
			}
		
	public static void loginTest() throws InterruptedException {
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();
		Thread.sleep(3000);
		
		
		}
	
	public static void negLoginTest() throws InterruptedException {
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc1234");
		driver.findElement(By.name("login")).click();
		Thread.sleep(3000);
	}
	
	public static void tearDown() {
		driver.close();
	}
	
}	
	
	
	
	

