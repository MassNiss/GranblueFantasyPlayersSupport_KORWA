package GranblueFantasyAnalysis;

import java.util.ArrayList;
import java.util.List;

import GranblueFantasyAnalysis.FileReadWrite.*;

public class GuraburuConfig extends LogMessage{
	private static GuraburuConfig ConfInstance = new GuraburuConfig();
	
	private GuraburuConfig() {
		
	}
	
	public static GuraburuConfig getInstance() {
		return ConfInstance;
	}
	
	enum TimeManagementConfigParam{
		gettimeTitle,
		gettime,
		waittimeTitle,
		waittime
	}
	
	enum MiscConfigParam{
		membersizeTitle,
		membersize,
		windowsizeTitle,
		windowsize,
		modeTitle,
		mode
	}
	
	String[] WindowSizeParam = {
		"minimum",
		"middle",
		"large",
		"maximum",
	};
	
	// Config Parameter Members
	public int TL_Time = 0;
	public int Get_time = 0;
	public int Wait_time = 0;
	public int MaxMemberSize = 0;
	public String WindowSize = "";
	public String OS_info = "";
	public String ActiveMode = "";
	final int NumforPage = 10;
	final String[] OutputFilePath = new String[] {
			"./ExtData/MembersInfo/Members1.txt",
			"./ExtData/MembersInfo/Members2.txt",
			"./ExtData/MembersInfo/Members3.txt",
			"./ExtData/MembersInfo/Members4.txt",
			"./ExtData/MembersInfo/Members5.txt",
			"./ExtData/MembersInfo/Members6.txt",
			"./ExtData/MembersInfo/Members7.txt",
			"./ExtData/MembersInfo/Members8.txt",
			"./ExtData/MembersInfo/Members9.txt",
			"./ExtData/MembersInfo/Members10.txt",
			"./ExtData/MembersInfo/Members11.txt",
			"./ExtData/MembersInfo/Members12.txt",
			"./ExtData/MembersInfo/Members13.txt",
			"./ExtData/MembersInfo/Members14.txt",
			"./ExtData/MembersInfo/Members15.txt",
			"./ExtData/MembersInfo/Members16.txt",
			"./ExtData/MembersInfo/Members17.txt",
			"./ExtData/MembersInfo/Members18.txt",
			"./ExtData/MembersInfo/Members19.txt",
			"./ExtData/MembersInfo/Members20.txt",
			"./ExtData/MembersInfo/Members21.txt",
			"./ExtData/MembersInfo/Members22.txt",
			"./ExtData/MembersInfo/Members23.txt",
			"./ExtData/MembersInfo/Members24.txt",
			"./ExtData/MembersInfo/Members25.txt",
			"./ExtData/MembersInfo/Members26.txt",
			"./ExtData/MembersInfo/Members27.txt",
			"./ExtData/MembersInfo/Members28.txt",
			"./ExtData/MembersInfo/Members29.txt",
			"./ExtData/MembersInfo/Members30.txt"
	};
	
	public List<String> GuildMembers = new ArrayList<>();
	
	FileReadWrite FRW = new FileReadWrite();
	FileReadWrite.FileReading RD = FRW.new FileReading();
	FileReadWrite.FileWriting<String> WR = FRW.new FileWriting<>();
	
	private class ConfigParameter{
		final String LogPath = "./ExtData/Log.txt";
		final String OS_typepath = "./ExtData/OSInfo.txt";
		final String TimeManagementConfigPath = "./ExtData/Timeconfig.txt";
		final String GuildMembersInfoPath = "./ExtData/GuildMembers.txt";
		final String OthersPath = "./ExtData/Misc.txt";
		final int WindowModeNum = 4;
	}
	
	public void Config_Param_Init() throws Exception{
		ConfigParameter param = new ConfigParameter();
		// LogPath Confirmation
		try {
			RD.RetLine(param.LogPath);
		}catch(Exception e){
			throw e;
		}
		// OS type set
		OS_Setting(param);
		// Time parameter set
		TimeConfigParamSet(param);
		// Brigade members set
		BrigadeListUp(param);
		// Brigade members max set
		BrigadeMaxMemberSetup(param);
		// Window size set
		WindowsizeSetting(param);
		// Page sleep time set
		Tl_TimeSetting();
		// Active mode
		ActiveModeSetup(param);
	}
	
	private void Tl_TimeSetting() {
		this.TL_Time = this.Wait_time;
	}
	
	private void OS_Setting(ConfigParameter param) {
		this.OS_info = this.RD.RetLine(param.OS_typepath);
	}
	
	// Utility method
	private String[] ConfigParamSet(String pathparam) {
		String ConfParam;
		String[] ConfParamArray;
		ConfParam = this.RD.RetLine(pathparam);
		if(this.OS_info.equals("MAC")) {
			ConfParamArray = ConfParam.split("\n", -1);
		}
		else {
			ConfParamArray = ConfParam.split("\r\n", -1);
		}
		return ConfParamArray;
	}
	
	public void TimeConfigParamSet(ConfigParameter param) {
		String[] TCP = this.ConfigParamSet(param.TimeManagementConfigPath);
		final int Get_Time_upper = 6000000;
		final int Get_Time_bottom = 60000;
		final int Wait_Time_upper = 100000;
		final int Wait_Time_bottom = 100;
		int gettime, waittime;
		gettime = Integer.parseInt(TCP[TimeManagementConfigParam.gettime.ordinal()]);
		waittime = Integer.parseInt(TCP[TimeManagementConfigParam.waittime.ordinal()]);
		
		if(gettime > Get_Time_upper) {this.Get_time = Get_Time_upper;}
		else if(gettime < Get_Time_bottom) {this.Get_time = Get_Time_bottom;}
		if(waittime > Wait_Time_upper) {this.Wait_time = Wait_Time_upper;}
		else if(waittime < Wait_Time_bottom) {this.Wait_time = Wait_Time_bottom;}
		
		else{
			this.Get_time = Integer.parseInt(TCP[TimeManagementConfigParam.gettime.ordinal()]);
			this.Wait_time = Integer.parseInt(TCP[TimeManagementConfigParam.waittime.ordinal()]);	
		}
		
	}
	
	public void BrigadeListUp(ConfigParameter param) {
		String[] BrigadeAll = this.ConfigParamSet(param.GuildMembersInfoPath);
		String BrigadeMember;
		this.MaxMemberSize = BrigadeAll.length;
		for(int index=0; index<BrigadeAll.length; index++) {
			BrigadeMember = BrigadeAll[index];
			GuildMembers.add(BrigadeMember);
		}
	}
	
	public void BrigadeMaxMemberSetup(ConfigParameter param) {
		String[] OthersAll = this.ConfigParamSet(param.OthersPath);
		int MemberNum = Integer.parseInt(OthersAll[MiscConfigParam.membersize.ordinal()]);
		if(MemberNum < this.MaxMemberSize) {
			this.MaxMemberSize = MemberNum;
		}
	}
	
	public void WindowsizeSetting(ConfigParameter param) {
		String[] OthersAll = this.ConfigParamSet(param.OthersPath);
		this.WindowSize = OthersAll[MiscConfigParam.windowsize.ordinal()];
	}
	
	public void ActiveModeSetup(ConfigParameter param) {
		String[] OthersAll = this.ConfigParamSet(param.OthersPath);
		this.ActiveMode = OthersAll[MiscConfigParam.mode.ordinal()];
	}
	
}
