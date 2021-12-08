package org.Apache.maven.archetypes.Maven.Archetype.Quickstart;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Base {
	public static WebDriver d;

	public static WebDriver browser(String type) {
		if(type.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"\\aji\\chromedriver.exe");
			d = new ChromeDriver();
		}
		else if (type.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\aji\\geckodriver.exe" );
			d = new FirefoxDriver();
		}
		d.manage().window().maximize();
		return d;
	}
	public static void url(String url) {
		d.get(url);
	}
	public static void ClickOnWebelement(WebElement ele) {
		ele.click();
	}
	public static void inputValueElement(WebElement ele, String Value) {
		ele.sendKeys(Value);
	}
	
	public static void actionsClass(String A, WebElement ele) {
		Actions ac = new Actions(d);
		if(A.equalsIgnoreCase("move")) {
			ac.moveToElement(ele).build().perform();	
			
		}
		else if(A.equalsIgnoreCase("click")) {
			ac.click(ele).build().perform();
		}
		}
		 public static void scroll(String type, String value, WebElement ele) {
			JavascriptExecutor j = (JavascriptExecutor) d ;
			
			if(type.equalsIgnoreCase("scrollby")) {
				j.executeScript(value);
			}
			else if (type.equalsIgnoreCase("scrollintoview")) {
			j.executeScript("arguments[0].scrollIntoView()", ele);
			}
		
	}
 
}
