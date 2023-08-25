package store;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends MainClass {

	public ProductsPage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy (xpath = "(//div[@class='caption']/h4/a)")
	public WebElement firstProduct;
	
	public void SelectTheFirstProduct() {
		clickOnButton(firstProduct);
	}
}