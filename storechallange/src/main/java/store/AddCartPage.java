package store;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddCartPage extends MainClass {

	public AddCartPage(WebDriver driver) {
		super(driver);
	}

	
	@FindBy (id = "button-cart")
	private WebElement AddToCart;
	
	@FindBy(id = "cart")
	public WebElement items_button;
	
    @FindBy(xpath = "//p[@class='text-right']/a")
	private WebElement viewCart;
    
    @FindBy(xpath = "//td[@class='text-left']/a")
    public WebElement productNameInCart;
    
    @FindBy(css = "button[class='btn btn-danger']")
    private WebElement remove_b;
    
    @FindBy(xpath = "//div[@id='content']/p")
    private WebElement CartMessage;
    
    @FindBy(className = "text-center")
    public WebElement itemMessage;
  
    public void AddToCart() {
		clickOnButton(AddToCart);
	}
	public void showCart() {
		clickOnButton(items_button);
	}
	
	
	public void viewCart() {
		clickOnButton(viewCart);
	}
	
	
	public void removeItemFromTheCart() {
		clickOnButton(remove_b);
	}
}
