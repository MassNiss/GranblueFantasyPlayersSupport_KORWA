package GranblueFantasyAnalysis;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public abstract class GuraburuPlayersSupport{
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
	
	abstract void PlayersSupportMethod(WebDriver driver) throws Exception;

}
