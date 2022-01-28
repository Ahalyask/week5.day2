package week5.day2classroomexercise;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DeleteLead extends BaseClassForLeads{
	
	@BeforeClass
	public void setup() {
		filename = "DeleteLeadData";
	}
	
  @Test(dataProvider="FetchData")
  public void deleteLead(String lName) throws InterruptedException {
	  driver.findElement(By.linkText("Find Leads")).click();
	  driver.findElement(By.xpath("(//div[@class='x-form-element']/input[@name='firstName'])[3]")).sendKeys(lName);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(5000);
		String leadId1 = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]")).getText();
		System.out.println("lead 1 id "+leadId1);
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]//a[@class='linktext']")).click();
		driver.findElement(By.linkText("Delete")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.name("id")).sendKeys(leadId1);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
		String tableInfo = driver.findElement(By.className("x-paging-info")).getText();
		if(tableInfo.contains("No records to display") == true) {
			System.out.println("data does not exist");			
		}else {
			System.out.println("data exist");
		}
  }
}
