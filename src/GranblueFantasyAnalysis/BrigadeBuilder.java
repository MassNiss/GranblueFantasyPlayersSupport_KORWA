package GranblueFantasyAnalysis;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.WebDriver;

import GranblueFantasyAnalysis.GuildMembersAccess;
import GranblueFantasyAnalysis.MembersInfoBoxCtrl;
import GranblueFantasyAnalysis.FileReadWrite.*;
import GranblueFantasyAnalysis.GuraburuConfig;

public class BrigadeBuilder {
	private int GuildMaxNum;
	
	private String[] BrigadeMembers = new String[]{
		"none",
		"none",
		"none",
		"none",
		"none",
		"none",
		"none",
		"none",
		"none",
		"none",
		"none",
		"none",
		"none",
		"none",
		"none",
		"none",
		"none",
		"none",
		"none",
		"none",
		"none",
		"none",
		"none",
		"none",
		"none",
		"none",
		"none",
		"none",
		"none",
		"none"
	};
	
	public void BrigadeMembersSetup(){
		GuraburuConfig Conf = GuraburuConfig.getInstance();
		for(int i=0; i<Conf.MaxMemberSize; i++) {
			BrigadeMembers[i] = Conf.GuildMembers.get(i);
		}
		this.GuildMaxNum = Conf.MaxMemberSize;
	}
	
	private MembersInfoBoxCtrl MIC;
	FileReadWrite FRW;
	FileReadWrite.FileWriting WR;
	
	BrigadeBuilder(){
		this.MIC = new MembersInfoBoxCtrl();
		FRW = new FileReadWrite();
		this.WR = FRW.new FileWriting();
		BrigadeMembersSetup();
	};
	
	public void BrigadeMebersInfoAdd(WebDriver driver, Calendar calendar, int offset) {
		int Short = this.GuildMaxNum - offset - 10;
		int diff = 0;
		if(Short<0) {
			diff = -Short;
		}
		GuildMembersAccess GMA = new GuildMembersAccess(diff);
		GMA.AddtoMembersList(driver, 0);
		for(int i=0; i<GMA.page_num-diff; i++) {
			String loginname = BrigadeMembers[i+offset];
			String loginfreq = GMA.LoginTimeInform(BrigadeMembers[i+offset]);
			String currenttime = calendar.getTime().toString();
			MIC.MembersListEdit(loginname, loginfreq, currenttime);
		}
	}
	
	public void PageBrigadeMembersExport(WebDriver driver, int offset) {
		int Short = this.GuildMaxNum - offset - 10;
		int diff = 0;
		if(Short<0) {
			diff = -Short;
		}
		GuraburuConfig Conf = GuraburuConfig.getInstance();
		GuildMembersAccess GMA = new GuildMembersAccess(diff);
		for(int i=0; i<GMA.page_num-diff; i++) {
			this.WR.WriteLine(Conf.OutputFilePath[i+offset], MIC.MembersListRead(i));
		}
	}

}
