package GranblueFantasyAnalysis;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import GranblueFantasyAnalysis.WebElementGet;

public class GuildMembersAccess {
	final String headPath = "//*[@id=\"prt-guild-list\"]/div/div[";
	final int page_num = 10;
	private String memberNamePath = "";
	private String memberLoginPath = "";
	private String NameTailPath = "]/div[2]/div[1]/div[1]";
	private String LoginTailPath = "]/div[2]/div[2]/div";
	private WebElement NameElement;
	private WebElement LoginElement;
	private int diff = 0;
	WebElementGet WG;

	GuildMembersAccess(int diff){
		this.diff = diff;
		MembersList.MemberName = new String[page_num];
		MembersList.MemberLogin = new String[page_num];
		for(int i=0; i<page_num-this.diff; i++) {
			MembersList.MemberName[i] = "";
			MembersList.MemberLogin[i] = "";
		}
	}
	
	static public class MembersList{
		static public String[] MemberName;
		static public String[] MemberLogin;
		
		MembersList(){					
			
		}
	}
	

	
	private String NameInfo(int number){
		this.memberNamePath = headPath + number + NameTailPath;
		return this.memberNamePath;
	}
	
	private String LoginInfo(int number) {
		this.memberLoginPath = headPath + number + LoginTailPath;
		return this.memberLoginPath;
	}
	
	public void AddtoMembersList(WebDriver driver, int offset) {
		WG = new WebElementGet(driver);
		for(int i=offset; i<page_num+offset-this.diff; i++) {
			NameInfo(i+1);
			LoginInfo(i+1);
			NameElement = WG.GetElements_byxpath(this.memberNamePath);
			LoginElement = WG.GetElements_byxpath(this.memberLoginPath);
			MembersList.MemberName[i] = NameElement.getText();
			MembersList.MemberLogin[i] = LoginElement.getText();
		}
			
	}
	
	public String LoginTimeInform(String Name) {
		String value = "";
		
		for(int i=0; i<page_num-this.diff; i++) {
			if(MembersList.MemberName[i].equals(Name)) {
				value = MembersList.MemberLogin[i];
				return value;
			}
			else {
				value = "none";
			}
		}

		return value;
	}

}
