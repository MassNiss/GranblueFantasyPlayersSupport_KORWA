package GranblueFantasyAnalysis;

import GranblueFantasyAnalysis.AncientBattleFieldInfomationAccess;
import GranblueFantasyAnalysis.RingbufferExecute;

import java.util.List;

import org.openqa.selenium.WebDriver;

public class AncientBattleFieldAnalysis {
	final String headPath = "//*[@id=\"prt-guild-list\"]/div/div[";
	private AncientBattleFieldInfomationAccess ABFIA;
	private int[] TenTimesBox = new int[10];
	private int cnt = 0;
	private int tenaverage = 0;
	private String TenAverageStr = "";
	
	private RingbufferExecute RingBuf;
	FileReadWrite FRW;
	FileReadWrite.FileWriting<List<String>> WR;
	
	AncientBattleFieldAnalysis(WebDriver driver){
		this.RingBuf = new RingbufferExecute(this.TenTimesBox.length);
		this.ABFIA = new AncientBattleFieldInfomationAccess(driver);
	}
	
	private boolean TenTimesRecentMethod() {
		boolean cntup = false;
		this.RingBuf.push(Integer.parseInt(ABFIA.mybricont));
		if(this.cnt < this.TenTimesBox.length) {
			this.tenaverage = this.RingBuf.aveCalcRet(++this.cnt);
		}
		else {
			cntup = true;
			this.tenaverage = this.RingBuf.aveCalcRet(this.TenTimesBox.length);
		}
		return cntup;
	}
	
	public void BattleInfoCollect(String value) {
		this.ABFIA.ContributionValueSet(value);
	}
	
	public void InfomationAnalysis() {
		this.TenTimesRecentMethod();
		this.TenAverageStr = String.valueOf(this.tenaverage);
	}
	
	public void PageAncientBattleFieldInfoExport(WebDriver driver, String NowTime) {
		GuraburuConfig Conf = GuraburuConfig.getInstance();
		this.WR.WriteLine(Conf.BattleInfoPath, this.ABFIA.ContributionDegreeRead(this.TenAverageStr, NowTime));
	}
	
}
