package web;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/himanshusakwaya/Documents/java/selenium/chromedriver");
		WebDriver chromedriver = new ChromeDriver();
		chromedriver.manage().window().maximize();
		//chromedriver.manage().deleteAllCookies();
		
		
		chromedriver.get("https://jqueryui.com/droppable/");
		chromedriver.switchTo().frame(0);
		
		JavascriptExecutor js = (JavascriptExecutor) chromedriver;
		WebElement element = chromedriver.findElement(By.xpath("//*[@id=\"droppable\"]"));
		js.executeScript("arguments[0].scrollIntoView();", element);
		
		Actions action = new Actions(chromedriver);
		action.clickAndHold(chromedriver.findElement(By.xpath("//*[@id=\"draggable\"]")))
		.moveToElement(chromedriver.findElement(By.xpath("//*[@id=\"droppable\"]")))
		.release().build().perform();
		
		try {
			Thread.sleep(5000);
		}
		catch(Exception e) {
			System.out.println("Exception : " + e);
		}
		
		chromedriver.quit();
		
		

	}

}
