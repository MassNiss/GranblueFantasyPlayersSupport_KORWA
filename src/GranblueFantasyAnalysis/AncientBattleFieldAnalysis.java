package GranblueFantasyAnalysis;

import GranblueFantasyAnalysis.AncientBattleFieldInfomationAccess;
import GranblueFantasyAnalysis.RingbufferExecute;

import java.util.List;

import org.openqa.selenium.WebDriver;

public class AncientBattleFieldAnalysis {
	final String headPath = "//*[@id=\"prt-guild-list\"]/div/div[";
	public AncientBattleFieldInfomationAccess ABFIA;
	private int[] TenTimesBox = new int[10];
	private int cnt = 0;
	private int myaverage = 0;
	private int oppaverage = 0;
	private String myAverageStr = "";
	private String oppAverageStr = "";
	private int aveTerm = 3;
	
	private String mybridiff = "";
	private String oppbridiff = "";
	
	private RingbufferExecute MyRingBuf;
	private RingbufferExecute OppRingBuf;
	FileReadWrite FRW = new FileReadWrite();
	FileReadWrite.FileWriting<List<String>> WR;
	
	AncientBattleFieldAnalysis(WebDriver driver){
		this.MyRingBuf = new RingbufferExecute(this.TenTimesBox.length);
		this.OppRingBuf = new RingbufferExecute(this.TenTimesBox.length);
		this.ABFIA = new AncientBattleFieldInfomationAccess(driver);
		this.WR = FRW.new FileWriting<>();
	}
	
	private boolean AverageRecentMethod(String mycontValue, String oppcontValue) {
		boolean cntup = false;
		this.MyRingBuf.push(Integer.parseInt(mycontValue));
		this.OppRingBuf.push(Integer.parseInt(oppcontValue));
		if(this.cnt < this.aveTerm) {
			this.cnt++;
			this.myaverage = this.MyRingBuf.aveCalcRet(this.cnt);
			this.oppaverage = this.OppRingBuf.aveCalcRet(this.cnt);
		}
		else {
			cntup = true;
			this.myaverage = this.MyRingBuf.aveCalcRet(this.aveTerm);
			this.oppaverage = this.OppRingBuf.aveCalcRet(this.aveTerm);
		}
		return cntup;
	}
	
	private void DiffCalcMethod(boolean firstGet) {
		if(firstGet == true) {
			this.mybridiff = "0";
			this.oppbridiff = "0";
		}
		else {
			this.mybridiff = String.valueOf(this.MyRingBuf.diff);
			this.oppbridiff = String.valueOf(this.OppRingBuf.diff);
		}
	}
	
	public void BattleInfoCollect(String value) {
		this.ABFIA.ContributionValueSet(value);
	}
	
	public void InfomationAnalysis(String UAF_mode) {
		this.ABFIA.FightModeSet(UAF_mode);
		this.ABFIA.ContributionValueSet(UAF_mode);
		boolean cntup = this.AverageRecentMethod(this.ABFIA.mybricont, this.ABFIA.oppbricont);
		this.myAverageStr = String.valueOf(this.myaverage);
		this.oppAverageStr = String.valueOf(this.oppaverage);
	}
	
	public void PageAncientBattleFieldInfoExport(WebDriver driver, String NowTime, String mode, boolean firstget) {
		GuraburuConfig Conf = GuraburuConfig.getInstance();
		DiffCalcMethod(firstget);
		if(mode.equals("current")) {
			this.WR.WriteLine(Conf.GuildContributionInfoPath, 
					this.ABFIA.ContributionDegreeRead(this.mybridiff, this.oppbridiff, NowTime));	
		}
		
	}
	
}
