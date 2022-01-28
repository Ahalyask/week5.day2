package week5.day2classroomexercise;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class BaseClassForLeads {
 
	public ChromeDriver driver;
	public String filename;
	
	@Parameters({"url", "uname", "password"})
  @BeforeMethod
  public void beforeMethod(String url, String uname, String pword) {
	  WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.findElement(By.id("username")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(pword);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
  }
	
	  @DataProvider(name="FetchData")
	  public String[][] sendData() throws IOException{
		  return ReadExcel.readExcel(filename); 
	  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
