package StepDefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NJITStepDefinition {
	
	WebDriver driver;
	
	@Given("^User is on transcript portal$")
	public void user_is_on_transcript_portal() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver","D:\\Eclipse\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://portal-dev.measureone.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("firstName")).sendKeys("Bharat");
		driver.findElement(By.id("lastName")).sendKeys("Hirani");
		driver.findElement(By.id("email")).sendKeys("bhirani@m1.com");
		driver.findElement(By.id("terms-condition")).click();
		
		 // explicit wait - to wait for the compose button to be click-able
		
		WebDriverWait wait = new WebDriverWait(driver,120);
		
		 
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("submitBtn")));
		
		              // click on the compose button as soon as the "compose" button is visible
		
		driver.findElement(By.id("submitBtn")).click();
		
		System.out.println("Clicked on Continue");
		
		Thread.sleep(2000);
		
		       

		
		
	    System.out.println("Inside Given");

	}

	@When("^User selects NJIT as school and redirect to website$")
	public void user_selects_NJIT_as_school_and_redirect_to_website() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Inside When");
		
		driver.findElement(By.id("schoolNameMain")).sendKeys("New Jersey institute of");
		driver.findElement(By.xpath("//button[@class='dropdown-item active']")).click();
		
		Boolean checkboxselected = driver.findElement(By.id("radio1")).isSelected();
		
		
		if (checkboxselected) {
			System.out.println("Undergraduate already selected");
			} else {
				driver.findElement(By.id("radio1")).click();
				System.out.println("Selected Undergraduate as Academic Level");
			}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='col-4 col-lg-4 col-md-4 sticky-button pr-0']//button[@id='submitBtn']")).click();
		System.out.println("Click on continue with selected school");
		
		driver.findElement(By.xpath("//div[@class='col-5 col-lg-4 col-md-4 sticky-button last-btn']//button[@id='submitBtn']")).click();
		System.out.println("Click on continue and selected upload from school site");
		
		Thread.sleep(2000);
	   
	}

	@Then("^Upload transcript and submit the transaction$")
	public void upload_transcript_and_submit_the_transaction()  {
		System.out.println("Inside Then");
	//	driver.close();
	    
	}
	
}
