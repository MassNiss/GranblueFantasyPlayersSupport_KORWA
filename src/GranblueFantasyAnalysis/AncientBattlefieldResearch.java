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
	private int interval = 120000;
	

	private AncientBattlefieldResearch(){
	}
	
	static GuraburuPlayersSupport getInstance() {
		return (GuraburuPlayersSupport) Korwa;
	}
	
	public void PlayersSupportMethod(WebDriver driver) throws Exception{
		/* common setup */
		this.PlayersSupportMethodSetup(this, driver);
		
		/* Control Method */
		WebElement menubutton = this.WEG.GetElements_byxpath("//*[@id=\"wrapper\"]/header/div[4]");
		if(Conf.WindowSize.equals("middle")) {
			this.act.moveToElement(menubutton).moveByOffset(200, 10).click().build().perform();
		}
		else {
			menubutton.click();
		}
		TL.Sleep();
		
		// loop method
		while(true) {
			AncientBattleFieldAnalysis ABFA = new AncientBattleFieldAnalysis(driver);
			Calendar calendar = Calendar.getInstance();
			int sleep_cnt = 0;
			
			ABFA.InfomationAnalysis();
			ABFA.PageAncientBattleFieldInfoExport(driver, calendar.getTime().toString());
			
			TL.Sleep(this.interval-sleep_cnt*this.Sleep_time);
			
		}
		
	}
	
	
}
