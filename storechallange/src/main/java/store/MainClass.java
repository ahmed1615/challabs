package store;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
public class MainClass {

	protected static WebDriver driver;
	 WebDriverWait wait; 
	
	
	public MainClass(WebDriver driver) {
		PageFactory.initElements(driver, this);
	     
	}
	protected WebDriver getDriver() {
        return driver;
    }
	
	public static void clickOnButton(WebElement element){
	
		if(element.isDisplayed()==true &&element.isEnabled()) {
			element.click();
		}
		else {
			String notable=element.getText();
			String message=String.format(notable+" button with tag name "+element.getTagName()+" is not able to click");
			System.out.println(message);
		}
	}
	public static void fillfiled(WebElement element, String value) {
		 
			element.click();
			element.sendKeys(Keys.CONTROL,"a");
			element.sendKeys(Keys.DELETE);
			element.sendKeys(value);
	}
}
