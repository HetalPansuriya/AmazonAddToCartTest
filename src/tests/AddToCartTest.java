package tests;

import org.testng.annotations.Test;
import pages.AddToCartPage;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class AddToCartTest {

	WebDriver driver;
	AddToCartPage atcp = new AddToCartPage();

	@BeforeMethod
	public void beforeMethod() {
		// open browser and open amazon
		atcp.openbrowser();
		atcp.openAmazon();
	}

	@AfterMethod
	public void afterMethod() {
		// close browser
		atcp.closeBrowser();
	}

	@Test(priority = 1)
	public void OpenSearchBox() throws InterruptedException {
		// OpenSearchBox
		atcp.openSearchBox();
	}
	@Test(priority = 2)
	public void listAllOption() throws InterruptedException {
		// ListAllOptions
		atcp.openSearchBox();
		atcp.listAllOption();
	}
	@Test(priority = 3)
	public void openBooksPage() throws InterruptedException {
		// OpenBooksPage
		atcp.openSearchBox();
		atcp.listAllOption();
		atcp.openBooksPage();
	}
	@Test(priority = 4)
	public void clickOnCartPage() throws InterruptedException {
		// clickOnCartPage
		atcp.openSearchBox();
		atcp.listAllOption();
		atcp.openBooksPage();
		atcp.clickOnCartPage();
	}
	@Test(priority = 5)
	public void clickOnAddToCartButton() throws InterruptedException{
		// clickOnAddToCartButton
		atcp.openSearchBox();
		atcp.listAllOption();
		atcp.openBooksPage();
		atcp.clickOnCartPage();
		atcp.clickOnAddToCartButton();
	}
	@Test(priority = 6)
	public void verifyCart() throws InterruptedException {
		// VerifyCart
		atcp.openSearchBox();
		atcp.listAllOption();
		atcp.openBooksPage();
		atcp.clickOnCartPage();
		atcp.clickOnAddToCartButton();
		atcp.verifyCart();

	}

}
