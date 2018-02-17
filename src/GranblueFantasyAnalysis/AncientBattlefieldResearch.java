package GranblueFantasyAnalysis;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import GranblueFantasyAnalysis.AncientBattleFieldAnalysis;


public class AncientBattlefieldResearch extends GuraburuPlayersSupport{
	static AncientBattlefieldResearch Korwa = new AncientBattlefieldResearch();
	private int interval;
	private String UFNum;
	

	private AncientBattlefieldResearch(){
	}
	
	static GuraburuPlayersSupport getInstance() {
		return (GuraburuPlayersSupport) Korwa;
	}
	
	public void PlayersSupportMethod(WebDriver driver) throws Exception{
		/* common setup */
		this.PlayersSupportMethodSetup(this, driver);
		this.UFNum = Conf.ufnum;
		this.interval = Conf.Get_time;
		boolean firstget = true;
		
		/* Control Method */
		WebElement menubutton = this.WEG.GetElements_byxpath("//*[@id=\"wrapper\"]/header/div[4]");
		if(Conf.WindowSize.equals("middle")) {
			this.act.moveToElement(menubutton).moveByOffset(200, 10).click().build().perform();
		}
		else {
			menubutton.click();
		}
		TL.Sleep();
		driver.navigate().to("http://game.granbluefantasy.jp/#event/teamraid0"+this.UFNum);
		// Please Manual Enter Key
		TL.Sleep();
		AncientBattleFieldAnalysis ABFA = new AncientBattleFieldAnalysis(driver);
		// loop method
		while(true) {
			Calendar calendar = Calendar.getInstance();
			int sleep_cnt = 0;
			
			WebElement reloadbutton = this.WEG.GetElements_byxpath("//*[@id=\"treasure-footer\"]/div[1]/div[3]");
			reloadbutton.click();
			sleep_cnt += TL.Sleep();
			ABFA.InfomationAnalysis("main");
			ABFA.PageAncientBattleFieldInfoExport(driver, calendar.getTime().toString(), "current", firstget);
			firstget = false;
			
			TL.Sleep(this.interval-sleep_cnt*this.Sleep_time);
			
			
		}
		
	}
	
	
}
