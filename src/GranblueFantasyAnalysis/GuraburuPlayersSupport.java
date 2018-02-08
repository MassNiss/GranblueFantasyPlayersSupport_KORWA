package GranblueFantasyAnalysis;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import GranblueFantasyAnalysis.FileReadWrite.FileReading;
import GranblueFantasyAnalysis.FileReadWrite.FileWriting;

public abstract class GuraburuPlayersSupport implements IGuraburuPlayersSupport{
	public Actions act;
	public int Get_time = 60000;	//default
	public int wait_time = 100;	//default
	public int Sleep_time = 0;
	public TimeSleep TL;
	public WebElementGet WEG;
	FileReadWrite FRW;
	public GuraburuConfig Conf = GuraburuConfig.getInstance();
	
	FileReadWrite.FileReading RD;
	FileReadWrite.FileWriting<?> WR;
	
	enum pageNo{
		page1,
		page2,
		page3
	}
	
	public abstract void PlayersSupportMethod(WebDriver driver) throws Exception;
	
	public GuraburuPlayersSupport PlayersSupportMethodSetup(GuraburuPlayersSupport obj, WebDriver driver) {
		obj.act = new Actions(driver);
		obj.WEG = new WebElementGet(driver);
		obj.FRW = new FileReadWrite();
		obj.RD = FRW.new FileReading();
		obj.WR = FRW.new FileWriting<String>();
		
		/* Time Param Setting */
		obj.TL = new TimeSleep();
		obj.Sleep_time = Conf.Wait_time;
		obj.Get_time = Conf.Get_time;
		return obj;
	}

}
