package GranblueFantasyAnalysis;
 
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.BeforeClass;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.JavascriptExecutor;

import GranblueFantasyAnalysis.MembersLoginTimeSearchMethod;
import GranblueFantasyAnalysis.TimeSleep;
import GranblueFantasyAnalysis.GuraburuConfig;

public class Guraburu_Sample{
	//@BeforeClass
	public static void setup() {
		System.setProperty("webdriver.chrome.driver", "exe/chromedriver");	
		GuraburuConfig Conf = GuraburuConfig.getInstance();
		Conf.Config_Param_Init();
	}
	
	public static void main(String[] args) throws Exception{	
	//@Test
	//public void GranblueFantasySample() throws Exception{
		setup();
		ChromeOptions options = new ChromeOptions();
		//options.addArguments("--kiosk");
		options.addArguments("user-data-dir=profile");
		TimeSleep TL = new TimeSleep();
		WebDriver driver = new ChromeDriver(options);
		driver.get("http://game.granbluefantasy.jp/#mypage");
		Actions act = new Actions(driver);
		int mode = 0;
		
		TL.Sleep();
		
		if(mode == 0) {
			System.out.println("Mode: MembersLoginTimeSearch");
			MembersLoginTimeSearchMethod Method1 = new MembersLoginTimeSearchMethod(driver, act);
			try {
				Method1.MembersInfoGet();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				driver.quit();
			}
				
		}
		else {
			System.out.println("Mode: Not Supported!");
			driver.quit();
		}
		
		/*
		WebElement No1_LoginTime = driver.findElement(By.cssSelector("#prt-guild-list > div > div:nth-child(1) >"
				+ " div.prt-member-detail > div.prt-member-info > div"));
				*/
		/*
		WebElement chatlog = driver.findElement(By.xpath("//*[@id=252636714]"));
		String test1 = chatlog.getText();
		//String test2 = No1_LoginTime.getText();
		System.out.println(test1);
		*/
	}
	
}