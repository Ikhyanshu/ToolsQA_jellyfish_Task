import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test1 {

	public static void main(String[] args) throws AWTException, InterruptedException  {
		// TODO Auto-generated method stub

		
		String Path = "C:\\Users\\jojo\\Downloads\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", Path);
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/automation-practice-form");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//NameField  register hard_coading
		driver.findElement(By.id("firstName")).sendKeys("Ikhyanshu");
		driver.findElement(By.id("lastName")).sendKeys("Ojha");
		driver.findElement(By.id("userEmail")).sendKeys("iojha@gmail.com");
		
		//Selecting radiobutton
		driver.findElement(By.xpath("//label[normalize-space()='Male']")).click();
		
		
		
	      //Entering Mobile number 
		 driver.findElement(By.id("userNumber")).sendKeys("123456789");
		
		 //Selecting date in calender 
		 driver.findElement(By.id("dateOfBirthInput")).click();
		driver.findElement(By.xpath("//div[@role=\"option\"]")).click();
	
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)");
	
		//Subject
		
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("subjectsInput")))).sendKeys("ojha");
	
		//Chechkbox
		
		driver.findElement(By.xpath("//label[normalize-space()='Sports']")).click();
		//upaod pic
			
		Thread.sleep(5000);
			driver.findElement(By.cssSelector("#uploadPicture")).click();
			
			StringSelection s = new StringSelection("C:\\Users\\jojo\\Downloads\\ikhyanshu pic.jpg");
		      // Clipboard copy
		      Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s,null);
		      //identify element and click
		      
		      Thread.sleep(2000);
		     
		      Thread.sleep(2000);
		      // Robot object creation
		      Robot r = new Robot();
		      //pressing enter
		      r.keyPress(KeyEvent.VK_ENTER);
		      //releasing enter
		      r.keyRelease(KeyEvent.VK_ENTER);
		      //pressing ctrl+v
		      r.keyPress(KeyEvent.VK_CONTROL);
		      r.keyPress(KeyEvent.VK_V);
		      //releasing ctrl+v
		      r.keyRelease(KeyEvent.VK_CONTROL);
		      r.keyRelease(KeyEvent.VK_V);
		      //pressing enter
		      r.keyPress(KeyEvent.VK_ENTER);
		      //releasing enter
		      r.keyRelease(KeyEvent.VK_ENTER);
		      
				
			
			//Current adress
			driver.findElement(By.id("currentAddress")).sendKeys("Adress");
			
			//driver.close();
	}

}
