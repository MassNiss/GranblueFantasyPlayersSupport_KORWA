package GranblueFantasyAnalysis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import GranblueFantasyAnalysis.WebElementGet;

public class AncientBattleFieldInfomationAccess {
	// Contribution points paths
	private String PreBriContPath;
	private String MainBriContPath;
	private String MyContPath;
	private String MyBriContPath;
	private String MyBriRankPath;
	private String OppContPath;
	protected String mycont;
	protected String mybricont;
	protected String oppbricont;
	WebElementGet WG;
	
	AncientBattleFieldInfomationAccess(WebDriver driver){
		this.PreBriContPath = "//*[@id=\"cnt-fv-battle\"]/div[5]/div[2]/div[2]/div[2]";
		this.MainBriContPath = "//*[@id=\"cnt-fv-battle\"]/div[5]/div[3]/div[2]/div[1]/div[1]";
		this.MyContPath = "//*[@id=\"cnt-teamraid-top\"]/div[6]/div/div[3]/div[4]/div[2]/div[2]/span";
		this.MyBriContPath = "//*[@id=\"cnt-fv-battle\"]/div[5]/div[2]/div[2]/div[2]";
		this.MyBriRankPath = "//*[@id=\"cnt-fv-battle\"]/div[5]/div[2]/div[1]/div[2]/span";
		this.OppContPath = "//*[@id=\"cnt-fv-battle\"]/div[5]/div[3]/div[2]/div[1]/div[2]";
		this.WG = new WebElementGet(driver);
		this.mycont = "0";
		this.mybricont = "0";
		this.oppbricont = "0";
	}
	
	// public access
	public List<String> ContributionDegreeReadMyBri(String value, String time){
		List<String> Array = new ArrayList<>();
		Collections.addAll(Array, this.mybricont, value, time);
		return Array;
	}
	
	public List<String> ContributionDegreeRead(){
		List<String> Array = new ArrayList<>();
		Collections.addAll(Array, this.mycont, this.mybricont, this.oppbricont);
		return Array;
	}
	
	public List<String> ContributionDegreeRead(String value1){
		List<String> Array = new ArrayList<>();
		Collections.addAll(Array, this.mycont, this.mybricont, this.oppbricont, value1);
		return Array;
	}
	
	public List<String> ContributionDegreeRead(String value1, String value2){
		List<String> Array = new ArrayList<>();
		Collections.addAll(Array, this.mycont, this.mybricont, this.oppbricont, value1, value2);
		return Array;
	}
	
	public List<String> ContributionDegreeRead(String value1, String value2, String value3, String value4){
		List<String> Array = new ArrayList<>();
		Collections.addAll(Array, this.mycont, this.mybricont, this.oppbricont, value1, value2, value3, value4);
		return Array;
	}
	
	public void FightModeSet(String UAF_mode) {
		if(UAF_mode=="pre") {
			this.MyBriContPath = this.PreBriContPath;
		}
		else {
			this.MyBriContPath = this.MainBriContPath;
		}
	}
	
	public void ContributionValueSet(String UAF_mode) {
		if(UAF_mode.equals("pre")) {
			this.mycont = this.WG.GetElements_byxpath(this.MyContPath).getText();
			this.mybricont = this.WG.GetElements_byxpath(this.MyBriContPath).getText();
			this.mybricont = this.mybricont.replace(",", "");
		}
		else {
			this.mycont = this.WG.GetElements_byxpath(this.MyContPath).getText();
			this.mybricont = this.WG.GetElements_byxpath(this.MyBriContPath).getText();
			this.mybricont = this.mybricont.replace(",", "");
			this.oppbricont = this.WG.GetElements_byxpath(this.OppContPath).getText();
			this.oppbricont = this.oppbricont.replace(",", "");
		}
	}
}
