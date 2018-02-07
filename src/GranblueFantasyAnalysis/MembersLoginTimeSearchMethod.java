package GranblueFantasyAnalysis;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.*;

import GranblueFantasyAnalysis.TimeSleep;
import GranblueFantasyAnalysis.WebElementGet;
import GranblueFantasyAnalysis.BrigadeBuilder;

public class MembersLoginTimeSearchMethod extends GuraburuPlayersSupport{
	// pageNo list
	static MembersLoginTimeSearchMethod Korwa = new MembersLoginTimeSearchMethod();
	
	private MembersLoginTimeSearchMethod(){
		
	}
	
	static GuraburuPlayersSupport getInstance() {
		return (GuraburuPlayersSupport) Korwa;
	}
	
	public void PlayersSupportMethod(WebDriver driver) throws Exception {
		// Common Instance bellow
		this.act = new Actions(driver);
		this.WEG = new WebElementGet(driver);
		FRW = new FileReadWrite();
		this.RD = FRW.new FileReading();
		this.WR = FRW.new FileWriting<String>();
		
		/* Time Param Setting */
		this.TL = new TimeSleep();
		this.Sleep_time = Conf.Wait_time;
		this.Get_time = Conf.Get_time;
		
		WebElement menubutton = this.WEG.GetElements_byxpath("//*[@id=\"wrapper\"]/header/div[4]");
		if(Conf.WindowSize.equals("middle")) {
			this.act.moveToElement(menubutton).moveByOffset(200, 10).click().build().perform();
		}
		else {
			menubutton.click();
		}
		TL.Sleep();
		WebElement guild_btn = this.WEG.GetElements_byxpath("//*[@id=\"wrapper\"]/div[1]/div/div[3]/div[4]");
		if(Conf.WindowSize.equals("middle")) {
			this.act.moveToElement(guild_btn).moveByOffset(200, 80).click().build().perform();
		}
		else {
			guild_btn.click();
		}
		TL.Sleep();
		WebElement guildmem = this.WEG.GetElements_byxpath("//*[@id=\"position-type\"]/div[3]/div[2]");
		if(Conf.WindowSize.equals("middle")) {
			this.act.moveToElement(guildmem).moveByOffset(110, 160).click().build().perform();	
		}
		else {
			guildmem.click();
		}
		TL.Sleep();
		WebElement Nothing = this.WEG.GetElements_byxpath("//*[@id=\"wrapper\"]/header/div[3]");
		
		Nothing.click();
		TL.Sleep();
		
		//page shift
		for(int i=0; i<30; i++) {
			this.act.sendKeys(Keys.DOWN).perform();
			TL.Sleep(200);			
		}
		
		//bellow loop
		while(true) {
			int sleep_cnt = 0;
			int offset = Conf.NumforPage*pageNo.page1.ordinal();
			BrigadeBuilder MBBpage1 = new BrigadeBuilder();
			BrigadeBuilder MBBpage2 = new BrigadeBuilder();
			BrigadeBuilder MBBpage3 = new BrigadeBuilder();
			// 1page infomation
			sleep_cnt += TL.Sleep();		
			Calendar calendar = Calendar.getInstance();
			MBBpage1.BrigadeMebersInfoAdd(driver, calendar, offset);
			MBBpage1.PageBrigadeMembersExport(driver, offset);
			MBBpage1 = null;
			calendar = null;
			
			// 2page infomation
			offset = Conf.NumforPage*pageNo.page2.ordinal();
			WebElement page2button = this.WEG.GetElements_byxpath("//*[@id=\"pagination-member\"]/div/div[2]/div/ul/li[2]");
			if(Conf.WindowSize.equals("middle")) {
				this.act.moveToElement(page2button).moveByOffset(100, 160).click().build().perform();
			}
			else {
				page2button.click();
			}
			sleep_cnt += TL.Sleep();	
			Calendar calendar2 = Calendar.getInstance();
			MBBpage2.BrigadeMebersInfoAdd(driver, calendar2, offset);
			MBBpage2.PageBrigadeMembersExport(driver, offset);
			MBBpage2 = null;
			calendar2 = null;
			
			// 3page information
			
			offset = Conf.NumforPage*pageNo.page3.ordinal();
			WebElement page3button = this.WEG.GetElements_byxpath("//*[@id=\"pagination-member\"]/div/div[2]/div/ul/li[3]");
			if(Conf.WindowSize.equals("middle")) {
				this.act.moveToElement(page3button).moveByOffset(140, 160).click().build().perform();	
			}
			else {
				page3button.click();
			}
			sleep_cnt += TL.Sleep();
			Calendar calendar3 = Calendar.getInstance();
			MBBpage3.BrigadeMebersInfoAdd(driver, calendar3, offset);
			MBBpage3.PageBrigadeMembersExport(driver, offset);
			MBBpage3 = null;
			calendar3 = null;

			//1page loop back
			TL.Sleep(this.Get_time-sleep_cnt*this.Sleep_time);
			WebElement page1button = this.WEG.GetElements_byxpath("//*[@id=\"pagination-member\"]/div/div[2]/div/ul/li[1]");
			if(Conf.WindowSize.equals("middle")) {
				this.act.moveToElement(page1button).moveByOffset(60, 110).click().build().perform();	
			}	
			else {
				page1button.click();
			}
			//driver.navigate().refresh();

		}
	}
	
	

}
