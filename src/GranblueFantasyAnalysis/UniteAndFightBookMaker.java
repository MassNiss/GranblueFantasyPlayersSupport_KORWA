package GranblueFantasyAnalysis;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UniteAndFightBookMaker extends GuraburuPlayersSupport{
	static UniteAndFightBookMaker Korwa = new UniteAndFightBookMaker();
	private String UFNum;
	private int interval = 120000;
	private String NorthLandPath = "//*[@id=\"wrapper\"]/div[3]/div[2]/div[2]/div/div[2]/div[1]/div";
	private String WestLandPath = "//*[@id=\"wrapper\"]/div[3]/div[2]/div[2]/div/div[2]/div[2]/div";
	private String EastLandPath = "//*[@id= \"wrapper\"]/div[3]/div[2]/div[2]/div/div[2]/div[3]/div";
	private String SouthLandPath = "//*[@id=\"wrapper\"]/div[3]/div[2]/div[2]/div/div[2]/div[4]/div";
	

	private UniteAndFightBookMaker(){
	}
	
	static GuraburuPlayersSupport getInstance() {
		return (GuraburuPlayersSupport) Korwa;
	}

	public void PlayersSupportMethod(WebDriver driver) throws Exception {
		/* common setup */
		this.PlayersSupportMethodSetup(this, driver);
		
		this.UFNum = Conf.ufnum;

		driver.navigate().to("http://game.granbluefantasy.jp/#event/teamraid0"+this.UFNum+"/bookmaker");

		// Please Manual Enter Key
		//TL.Sleep();
		
		while(true) {
			int sleep_cnt = 0;
			WebElement NorthElement = this.WEG.GetElements_byxpath(NorthLandPath);
			String NorthareaScore = NorthElement.getText();
			System.out.println(NorthareaScore);
			
			WebElement WestElement = this.WEG.GetElements_byxpath(WestLandPath);
			String WestareaScore = WestElement.getText();
			System.out.println(WestareaScore);
			
			WebElement EastElement = this.WEG.GetElements_byxpath(EastLandPath);
			String EastareaScore = EastElement.getText();
			System.out.println(EastareaScore);
			
			WebElement SouthElement = this.WEG.GetElements_byxpath(SouthLandPath);
			String SouthareaScore = SouthElement.getText();
			System.out.println(SouthareaScore);
			TL.Sleep(1200000 - sleep_cnt * this.wait_time);
		}
	}

}
