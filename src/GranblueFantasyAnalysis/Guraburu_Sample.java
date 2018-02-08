package GranblueFantasyAnalysis;
 
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.BeforeClass;
import java.util.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import GranblueFantasyAnalysis.MembersLoginTimeSearchMethod;
import GranblueFantasyAnalysis.AncientBattlefieldResearch;
import GranblueFantasyAnalysis.TimeSleep;
import GranblueFantasyAnalysis.GuraburuConfig;

public class Guraburu_Sample{
	//@BeforeClass
	public static void initsetup() {	
		GuraburuConfig Conf = GuraburuConfig.getInstance();
		Conf.Config_Param_Init();
		if(Conf.OS_info.equals("MAC")) {
			System.setProperty("webdriver.chrome.driver", "exe/chromedriver");
		}
		else {
			System.setProperty("webdriver.chrome.driver", "exe/chromedriver.exe");
		}
	}
	
	public static void main(String[] args) throws Exception{	
	//@Test
	//public void GranblueFantasySample() throws Exception{
		if(args.length != 0) {
			if(args[0].equals("-Config")) {
				CUIConfigurator.ConfigurationExecute();
				System.exit(0);
			}
		}

		initsetup();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("user-data-dir=profile");
		TimeSleep TL = new TimeSleep();
		WebDriver driver = new ChromeDriver(options);
		driver.get("http://game.granbluefantasy.jp/#mypage");
		GuraburuConfig Conf = GuraburuConfig.getInstance();
		
		TL.Sleep();
		
		// this application super Object
		GuraburuPlayersSupport Korwa = null;
		
		if(Conf.ActiveMode.equals("MembersLoginTimeSearch")) {
			System.out.println("Mode: MembersLoginTimeSearch");
			Korwa = MembersLoginTimeSearchMethod.getInstance();
				
		}
		else if(Conf.ActiveMode.equals("AncientBattleFieldResearch")) {
			System.out.println("Mode: AncientBattleFieldResearch");
			Korwa = AncientBattlefieldResearch.getInstance();
		}		
		else if(Conf.ActiveMode.equals("ManualLogin")) {
			TL.Sleep(60000);
			driver.quit();
			System.exit(0);
		}
		else {
			System.out.println("Mode: Not Supported!");
			driver.quit();
			System.exit(0);
		}
		
		if(Korwa==null) {
			System.exit(1);
		}
		
		// Korwa Method Active
		try {
			Korwa.PlayersSupportMethod(driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		System.exit(0);
	}
	
}