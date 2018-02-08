package GranblueFantasyAnalysis;

import org.openqa.selenium.WebDriver;

public interface IGuraburuPlayersSupport {
	// Must be instanced Method
	void PlayersSupportMethod(WebDriver driver) throws Exception;
	// abstract method
	GuraburuPlayersSupport PlayersSupportMethodSetup(GuraburuPlayersSupport obj, WebDriver driver);
}
