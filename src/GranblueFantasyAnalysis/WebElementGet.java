package GranblueFantasyAnalysis;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

import GranblueFantasyAnalysis.IElementGet;

public class WebElementGet{
	private WebElement Element;
	private WebDriver Driver;
	WebElementGet(WebDriver driver){
		Driver = driver;

	}
	// xpath method
	WebElement GetElements_byxpath(String xpath) {
		IElementGet<String> pathget = (path) -> {return this.Driver.findElement(By.xpath(path));};
		this.Element = pathget.ElementGet(xpath);
		return this.Element;
	}
	// id method
	WebElement GetElements_byid(String id) {
		IElementGet<String> idget = (Id) -> {return this.Driver.findElement(By.id(id));};
		this.Element = idget.ElementGet(id);
		return this.Element;
	}
	
}
