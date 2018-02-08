package GranblueFantasyAnalysis;

import org.openqa.selenium.WebElement;
import GranblueFantasyAnalysis.AncientBattleFieldInfomationAccess;
import GranblueFantasyAnalysis.RingbufferExecute;

public class AncientBattleFieldAnalysis {
	final String headPath = "//*[@id=\"prt-guild-list\"]/div/div[";
	private WebElement MyContribution;
	private WebElement MyBrigadeContribution;
	private WebElement OpponentContribution;
	private AncientBattleFieldInfomationAccess ABFIA;
	private int[] TenTimesBox = new int[10];
	private int getInterval = 20; //interval 20 minutes default
	
	private int MyCont;
	private int MyBriCont;
	private int OppCont;
	private int Diff;
	private int MostRecent;
	private int TenTimesRecent;
	private RingbufferExecute RingBuf;
	
	AncientBattleFieldAnalysis(){
		this.Init();
		this.RingBuf = new RingbufferExecute(this.TenTimesBox.length);
	}
	
	private void Init() {
		for(int i=0; i<10; i++) {
			this.TenTimesBox[i] = 0;
		}
	}
	
	private boolean TenTimesRecentMethod() {
		boolean done = false;
		this.RingBuf.push(this.MostRecent);
		
		return done;
	}
	
	// string parser
	private int ABFStrParser(String strdata) {
		return Integer.parseInt(strdata);
	}
	
	private void InfomationSetup() {
		
	}
	
	public void BattleFieldInfomationInform() {
		
	}
	
	
	
	
}
