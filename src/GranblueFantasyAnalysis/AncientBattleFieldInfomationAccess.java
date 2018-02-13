package GranblueFantasyAnalysis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import GranblueFantasyAnalysis.WebElementGet;

public class AncientBattleFieldInfomationAccess {
	// Contribution points paths
	private String MyContPath;
	private String MyBriContPath;
	private String OppContPath;
	protected String mycont;
	protected String mybricont;
	protected String oppcont;
	WebElementGet WG;
	
	AncientBattleFieldInfomationAccess(WebDriver driver){
		this.MyContPath = "";
		this.MyBriContPath = "";
		this.OppContPath = "";
		this.WG = new WebElementGet(driver);
		this.mycont = "";
		this.mybricont = "";
		this.oppcont = "";
		
	}
	
	// public access
	public List<String> ContributionDegreeRead(){
		List<String> Array = new ArrayList<>();
		Collections.addAll(Array, this.mycont, this.mybricont, this.oppcont);
		return Array;
	}
	
	public List<String> ContributionDegreeRead(String value1){
		List<String> Array = new ArrayList<>();
		Collections.addAll(Array, this.mycont, this.mybricont, this.oppcont, value1);
		return Array;
	}
	
	public List<String> ContributionDegreeRead(String value1, String value2){
		List<String> Array = new ArrayList<>();
		Collections.addAll(Array, this.mycont, this.mybricont, this.oppcont, value1, value2);
		return Array;
	}
	
	private String ContributionValueRet(String path) {
		return this.WG.GetElements_byxpath(path).getText();
	}
	
	private void ContributionValueImport(String setCont, String path) {
		setCont = ContributionValueRet(path);
	}
	
	public void ContributionValueSet(String value) {
		if(value.equals("MyContribution")) {
			this.ContributionValueImport(this.mycont, this.MyContPath);
		}
		else if(value.equals("MyBrigadeContribution")) {
			this.ContributionValueImport(this.mybricont, this.MyBriContPath);
		}
		else if(value.equals("OpponentContribution")) {
			this.ContributionValueImport(this.oppcont, this.OppContPath);
		}
		else {
			
		}
	}
	

}
