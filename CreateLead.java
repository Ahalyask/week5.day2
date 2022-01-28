package week5.day2classroomexercise;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateLead extends BaseClassForLeads{
	
	@BeforeClass
	public void setup() {
		filename = "CreateLeadData";
	}
	
  	
  @Test(dataProvider = "FetchData")
  public void createLead(String cmpName, String fstName, String lstName ) throws InterruptedException {
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cmpName);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fstName);		
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lstName);
		driver.findElement(By.name("submitButton")).click();
}
  

}
