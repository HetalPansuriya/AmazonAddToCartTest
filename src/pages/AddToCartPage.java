package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage {

	WebDriver driver;	
	
	//We will use PAge FActory
	
		@FindBy(id = "twotabsearchtextbox")
		public WebElement searchbox;
		@FindBy(xpath = "//div[@aria-label=\\\"sadhguru books\\\"]")
		public WebElement listAllOption;
		@FindBy(xpath = "//span[contains(text(),'in Books')]")
		public WebElement openBooksPage;
		@FindBy(xpath = "//span[contains(text(),'Death; An Inside Story: A Book For All Those Who S')]")
		public WebElement clickOnCartPage;
		@FindBy(id = "productTitle")
		public WebElement page;
		@FindBy(id = "add-to-cart-button")
		public WebElement clickOnAddToCartButton;
		@FindBy(id = "add-to-cart-confirmation-image")
		public WebElement image;
		@FindBy(id = "sw-gtc")
		public WebElement verifyCart;
		@FindBy(id = "//div[@data-itemtype=\\\"active\\\"]")
		public WebElement ShoppingCart;
	
	
	public void openbrowser() {
		
		String browser = "FireFox";// chrome,safari

		if (browser.equals("FireFox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\seleniumJars\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\seleniumJars\\chromedriver.exe");
			driver = new ChromeDriver();
		} else {
			
			System.setProperty("webdriver.safari.driver", "C:\\seleniumJars\\s.exe");
			driver = new FirefoxDriver();
		}
		PageFactory.initElements(driver, this);//initialize driver to find elements
		
	}
	
	public void closeBrowser() {
		driver.quit();
	}
	
	public void openAmazon() {
		driver.get("https://www.amazon.ca/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	public void openSearchBox() throws InterruptedException {
		searchbox.sendKeys("sadhguru books");
		Thread.sleep(3000);
	}
	
	public void listAllOption() throws InterruptedException {
		List<WebElement> allList = driver.findElements(By.xpath("//div[@aria-label=\"sadhguru books\"]"));
		Thread.sleep(2000);
		System.out.println(allList.size());

		for (int i = 0; i < allList.size(); i++) {
			System.out.println(allList.get(i).getText());
		}
	}
	
	public void openBooksPage() throws InterruptedException {
		//driver.findElement(By.xpath("//span[contains(text(),'in Books')]")).click();
		openBooksPage.click();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0, 500)");
		Thread.sleep(4000);
	}
	
	public void clickOnCartPage() throws InterruptedException {
		//driver.findElement(By.xpath("//span[contains(text(),'Death; An Inside Story: A Book For All Those Who S')]")).click();
		clickOnCartPage.click();
		
		WebElement page = driver.findElement(By.id("productTitle"));
		Thread.sleep(2000);

		if (page.isDisplayed()) {
			System.out.println("We are on the page");
		} else {
			System.out.println("We are on the page");
		}
	}
	
	public void clickOnAddToCartButton(){
		//driver.findElement(By.id("add-to-cart-button")).click();
		clickOnAddToCartButton.click();
		WebElement image = driver.findElement(By.id("add-to-cart-confirmation-image"));

		if (image.isDisplayed()) {
			System.out.println("Item added to cart.");
		} else {
			System.out.println("Item is not in cart.");
		}
	}
	
	public void verifyCart() throws InterruptedException {
		Thread.sleep(2000);
		//driver.findElement(By.id("sw-gtc")).click();
		verifyCart.click();
		List<WebElement> ShoppingCart = driver.findElements(By.xpath("//div[@data-itemtype=\"active\"]"));
		System.out.println(ShoppingCart.size());

		for (int i = 0; i < ShoppingCart.size(); i++) {
			System.out.println(ShoppingCart.get(i).getText());
		}
	}
	}


