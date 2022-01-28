package week5.day2classroomexercise;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DuplicateLead extends BaseClassForLeads{
	
	
	@BeforeClass
	public void setup() {
		filename = "DuplicateLeadData";
	}	
	
  @Test(dataProvider="FetchData")
  public void duplicateLead(String lName) throws InterruptedException {
	  driver.findElement(By.linkText("Find Leads")).click();
//		driver.findElement(By.linkText("Email")).click();
		driver.findElement(By.xpath("(//div[@class='x-form-element']/input[@name='firstName'])[3]")).sendKeys(lName);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
//		String name = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName'])[1]")).getText();
//		System.out.println(name);
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName'])[1]/a[@class='linktext']")).click();
		driver.findElement(By.linkText("Duplicate Lead")).click();
		
		String title = driver.getTitle();
		if(title.contains("Duplicate Lead")) {
			System.out.println("correct page - "+title);
		}else {
			System.out.println("wrong page - "+title);
		}
		
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		String name1 = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		System.out.println(name1);
		if(lName.contains(name1)) {
			System.out.println("yes "+lName+ " is duplicate lead");
		}else {
			System.out.println(lName+" is not duplicate lead");
		}
  }
}
