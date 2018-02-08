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
		/* common setup */
		this.PlayersSupportMethodSetup(this, driver);
	}
	
	
}
