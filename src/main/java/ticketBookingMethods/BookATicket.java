package ticketBookingMethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BookATicket {
	public WebDriver driver = null;
	String result = "Fail";
	WebElement element = null;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	WebDriverWait wait;

	public String openBrowser_navigate(String url) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("-no-sandbox");
		options.addArguments("-disable-dev-shm-usage");
		options.addArguments("--disable-infobars");
		// options.addArguments("--headless");
		driver = new ChromeDriver(options);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		System.out.println("Window Maximised");
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		result = "Pass";
		return result;
	}

	public String search(String srchtxt) throws InterruptedException {
		element = driver.findElement(By.xpath("(//*[@name='searchtext'])[1]"));
		element.sendKeys(srchtxt);
		element = driver.findElement(By.xpath("(//*[@class='nbf_button'])[1]"));
		element.click();
		Thread.sleep(2000);
		return result;
	}

	public void verifyResults() throws InterruptedException {
		Thread.sleep(5000);
		element = driver.findElement(By.xpath("//*[@tabindex='3']"));
		element.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		element = driver.findElement(By.id("content"));

		if (element.isDisplayed()) {
			System.out.println("Success");
		} else {
			System.out.println("Fail");
		}
	}

	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			System.out.println("Is Present");
			return true;

		} catch (NoSuchElementException e) {
			System.out.println("Is Not Present");
			return false;

		}
	}

	public void clickMore() throws InterruptedException {

		element = driver.findElement(By.xpath("//*[@id='iterator_1_product_custom_more-info-button']"));
		element.click();
		Thread.sleep(2000);
		element = driver.findElement(By.id("product-title"));
		if (element.isDisplayed()) {
			System.out.println("Test is a success");
		} else {
			System.out.println("test is failed");
		}

	}

	public void bookOnline() throws InterruptedException {

		element = driver.findElement(By.xpath("//*[@id=\"book-2276432a15eaf65ebfc0ffb211e6bf09\"]"));
		element.click();

	}

	public void clickContinue() throws InterruptedException {
		// wait= new WebDriverWait(driver,30);
		// element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"paxDepDateForm\"]/div[4]/button")));
		Thread.sleep(2000);
		element = driver.findElement(By.xpath("//*[@id=\"paxDepDateForm\"]/div[4]/button"));
		element.click();
		//

	}
	public void clickRoomContinue() throws InterruptedException {
		// wait= new WebDriverWait(driver,30);
		// element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"paxDepDateForm\"]/div[4]/button")));
		//
		element = driver.findElement(By.xpath("//*[@id=\"accomForm-select\"]/button"));
		element.click();
		//

	}
	public void clickRoomWithoutExtra() throws InterruptedException {
		// wait= new WebDriverWait(driver,30);
		// element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"paxDepDateForm\"]/div[4]/button")));
		Thread.sleep(2000);
		element = driver.findElement(By.xpath("//*[@id=\"extrasButton\"]"));
		element.click();
		
	}
	public void defaultRadio() throws InterruptedException {

		element = driver.findElement(By.xpath("//*[@id=\"calbox-2276432a15eaf65ebfc0ffb211e6bf09-1\"]"));
		if (element.isSelected()) {
			System.out.println("defaultRadio-->Test is a success");
		} else {
			System.out.println("defaultRadio-->test is failed");
		}

	}

	public void selRoom() {
		element = driver.findElement(By.xpath("//*[@id=\"room-0-numselect\"]"));
		Select sel = new Select(element);
		sel.selectByIndex(1);
		String str2 =driver.findElement(By.xpath("//*[@id=\"room-0-1-pax\"]/td/table/tbody/tr/td[1]/span")).getText();
		System.out.println(str2);
	}
	public void passengerForm() throws InterruptedException  {
		System.out.println("passengerForm"  );
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Select sel11 =new Select(driver.findElement(By.xpath("//*[@id=\"pax-a-title-1\"]")));
		sel11.selectByVisibleText("Ms");
//		driver.findElement(By.xpath("//*[@id=\"pax-a-first-1\"]")).sendKeys("ABC");
		element = driver.findElement(By.id("pax-a-first-1"));
	
		element.sendKeys("ABC");
//		driver.findElement(By.xpath("//*[@id=\"pax-a-last-1\"]")).sendKeys("defg");
		driver.findElement(By.id("pax-a-last-1")).sendKeys("defg");
		Select sel12 =new Select(driver.findElement(By.xpath("//*[@id=\"pax-a-dobd-1\"]")));
		sel12.selectByIndex(12);
		Select sel13 =new Select(driver.findElement(By.xpath("//*[@id=\"pax-a-dobm-1\"]")));
		sel13.selectByVisibleText("March");
		Select sel14 =new Select(driver.findElement(By.xpath("//*[@id=\"pax-a-doby-1\"]")));
		sel14.selectByVisibleText("1984");
		Select sel21 =new Select(driver.findElement(By.xpath("//*[@id=\"pax-a-title-2\"]")));
		sel21.selectByVisibleText("Mrs");
		driver.findElement(By.xpath("//*[@id=\"pax-a-first-2\"]")).sendKeys("xgt");
		driver.findElement(By.xpath("//*[@id=\"pax-a-last-2\"]")).sendKeys("hfg");
		Select sel22 =new Select(driver.findElement(By.xpath("//*[@id=\"pax-a-dobd-2\"]")));
		sel22.selectByIndex(14);
		Select sel23 =new Select(driver.findElement(By.xpath("//*[@id=\"pax-a-dobm-2\"]")));
		sel23.selectByVisibleText("July");
		Select sel24 =new Select(driver.findElement(By.xpath("//*[@id=\"pax-a-doby-2\"]")));
		sel24.selectByVisibleText("2000");
		//driver.findElement(By.xpath("//*[@id=\"contact-name")).sendKeys("ABC");
		driver.findElement(By.xpath("//*[@id=\"contact-mobile\"]")).sendKeys("0576878544353");
		driver.findElement(By.xpath("//*[@id=\"contact-email\"]")).sendKeys("ABC@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"contact-address1\"]")).sendKeys("AB");
		driver.findElement(By.xpath("//*[@id=\"contact-address2\"]")).sendKeys("ABC");
		driver.findElement(By.xpath("//*[@id=\"contact-city\"]")).sendKeys("ABC");
		driver.findElement(By.xpath("//*[@id=\"contact-postcode\"]")).sendKeys("AB123C");
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		Select sel31 =new Select(driver.findElement(By.xpath("//*[@id=\"contact-country\"]")));
		sel31.selectByVisibleText("United Kingdom");
		
		Select sel32 =new Select(driver.findElement(By.xpath("//*[@id=\"contact-hearabout\"]")));
		sel32.selectByVisibleText("Email");
		driver.findElement(By.xpath("//*[@id=\"contact-promocode\"]")).sendKeys("agjh123");
		driver.findElement(By.xpath("//*[@id=\"paxform-select\"]/button")).click();
		
	}
	public void comp() {
	String str1 =driver.findElement(By.xpath("//*[@id=\"nbf_product_pricingsummary\"]/div[3]/div[2]")).getText();
	
	System.out.print(str1);
	}
}
