package Neha.GoogleTest;

import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
public class SearchGoogleTest {
  @Test
  public void searchGoogle() {
	  	WebDriver Driver;
	  	ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		WebDriverManager.chromedriver().setup();
		Driver = new ChromeDriver(options); 
		Driver.manage().window().maximize();
		Driver.get("https://www.google.com/");
		WebElement linkEnglish =  (new WebDriverWait(Driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[text()='English']")));
		linkEnglish.click();
		WebElement edtSearchBox =  (new WebDriverWait(Driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@class='gLFyf gsfi']")));
		edtSearchBox.sendKeys("Programming");
		edtSearchBox.sendKeys(Keys.RETURN);
		Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		int intPageCoumt=1;
		while(intPageCoumt<=2) {
			List<WebElement> areaSections = Driver.findElements(By.xpath(".//*[@class='LC20lb']//ancestor::div[@id='rso']//h2"));
			for(int i=0;i<areaSections.size();i++) {
				String Sections = areaSections.get(i).getText();
				System.out.println("Sections :");			

				System.out.println(Sections);			
			}
			
			List<WebElement> lnkResults = Driver.findElements(By.xpath(".//*[@class='LC20lb']"));
			for(int i=0;i<lnkResults.size();i++) {
				String Title = lnkResults.get(i).getText();
				if(Title.isEmpty()) {}else{
					System.out.println("Title :");			

					System.out.println(Title);}						
			}
			WebElement lnkPage2 =  (new WebDriverWait(Driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='navcnt']//td[3]")));
			lnkPage2.click();
			intPageCoumt = intPageCoumt+1;
		}
		
  }
}
