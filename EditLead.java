package week5.day2classroomexercise;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EditLead extends BaseClassForLeads{
	
	@BeforeClass
	public void setup() {
		filename = "EditLeadData";
	}
	
  @Test(dataProvider="FetchData")
  public void editLead(String cName, String name) throws InterruptedException {
	  driver.findElement(By.linkText("Find Leads")).click();
		//driver.findElement(By.name("firstName")).click();
		driver.findElement(By.xpath("(//div[@class='x-form-element']/input[@name='firstName'])[3]")).sendKeys(name);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName'])[1]/a[@class='linktext']")).click();
		System.out.println(driver.getTitle());
		if(driver.getTitle().contains("View Lead")) {
			System.out.println("correct page - "+driver.getTitle());
		}else {
			System.out.println("wrong page - "+driver.getTitle());
		}
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(cName);
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		String companyname = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		if(companyname.contains(cName)) {
			System.out.println("company name updated");
		}else {
			System.out.println("company name is not updated");
		}
  }
}
