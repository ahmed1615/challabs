package storeTest;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBase {
	public static WebDriver driver;
	public static String user=System.getProperty("user.dir");
	public String applink="http://opencart.abstracta.us/";
	 
	 
	
	@BeforeSuite
	@Parameters({"browser"})
	public void StartDriver(@Optional("chrome") String browsername) throws InterruptedException {
		
		if(browsername.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.http.factory", "jdk-http-client");
		System.setProperty("webdriver.chrome.driver",user+"/drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000, 1));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60, 1)); 
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
		
		else if (browsername.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.http.factory", "jdk-http-client");
			System.setProperty("webdriver.chrome.driver",user+"/drivers/msedgedriver.exe");
			driver=new EdgeDriver(); 
		}
		
		driver.manage().window().maximize();
		driver.get(applink);

		driver.manage().deleteAllCookies();
	}
	
	@AfterSuite
	public void CloseTab() throws Exception {
		driver.quit();
	}
}