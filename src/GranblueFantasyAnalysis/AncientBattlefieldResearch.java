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
import GranblueFantasyAnalysis.FileReadWrite.FileReading;
import GranblueFantasyAnalysis.FileReadWrite.FileWriting;
import GranblueFantasyAnalysis.BrigadeBuilder;

public class AncientBattlefieldResearch extends GuraburuPlayersSupport{
	// Utility set declaration

	AncientBattlefieldResearch(){
	}
	
	public void PlayersSupportMethod(WebDriver driver) throws Exception{
		this.act = act;
		this.WEG = new WebElementGet(driver);
		FRW = new FileReadWrite();
		this.RD = FRW.new FileReading();
		this.WR = FRW.new FileWriting();
		
		/* Time Param Setting */
		this.TL = new TimeSleep();
		this.Sleep_time = Conf.Wait_time;
		this.Get_time = Conf.Get_time;
	}
	
	
}
