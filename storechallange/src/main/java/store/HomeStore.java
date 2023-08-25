package store;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomeStore extends MainClass{

	public HomeStore(WebDriver driver) {
		super(driver);
	}
	@FindBy(css = "input[name='search']")
	private WebElement searchbar;
	
	@FindBy(css = "button[class='btn btn-default btn-lg']")
	private WebElement searchIcon;
	public void SearchProduct(String prouct) {
		fillfiled(searchbar, prouct);
	}
	public void clickOnSearchIcon() {
		clickOnButton(searchIcon);
	}

}