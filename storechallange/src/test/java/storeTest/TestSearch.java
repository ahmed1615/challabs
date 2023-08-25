package storeTest;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import store.AddCartPage;
import store.HomeStore;
import store.ProductsPage;

public class TestSearch extends TestBase {
	HomeStore home;
	ProductsPage product;
	AddCartPage cart;
    String productName;
    String PNIC;
	@Test(alwaysRun = true, priority = 1)
	public void Searchproduct() {
		home=new HomeStore(driver);
		home.SearchProduct("iphone");
		home.clickOnSearchIcon();
		
	}
	@Test( priority = 2, dependsOnMethods ="Searchproduct" )
	public void selectproduct(){
		product =new ProductsPage(driver);
		cart = new AddCartPage(driver);
		productName = product.firstProduct.getText();
		product.SelectTheFirstProduct();
		cart.AddToCart();
		cart.showCart();
		PNIC =cart.productNameInCart.getText();
		cart.viewCart();
		System.out.println(cart.productNameInCart.getText());
		assertEquals(productName, PNIC);	
	}
	@Test(priority = 3)
	public void removeItem() throws InterruptedException {
		cart = new AddCartPage(driver);
		cart.removeItemFromTheCart();
		Thread.sleep(1000);
		cart.showCart();
		assertEquals(cart.itemMessage.getText(), "Your shopping cart is empty!");
	}
}
