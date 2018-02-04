package GranblueFantasyAnalysis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MembersInfoBoxCtrl {
	private ArrayList<MembersInfoBox> MembersArray;
	
	MembersInfoBoxCtrl() {
		this.MembersArray = new ArrayList<>();
	};
	
	public void MembersListEdit(String name, String loginfreq, String logintime) {
		this.MembersArray.add(MembersInfoBoxEdit(name, loginfreq, logintime));
	}
	
	public List<String> MembersListRead(int index){
		List<String> Array = new ArrayList<>();
		String name = this.MembersArray.get(index).Name;
		String loginfreq = this.MembersArray.get(index).LoginFreq;
		String logintime = this.MembersArray.get(index).LoginTime;
		Collections.addAll(Array, name, loginfreq, logintime);
		return Array;
	}
	
	public class MembersInfoBox{
		public String Name;
		public String LoginFreq;
		public String LoginTime;
	}
	
	private MembersInfoBox MembersInfoBoxEdit(String name, String loginfreq, String logintime) {
		MembersInfoBox MIB = new MembersInfoBox();
		MIB.Name = name;
		MIB.LoginFreq = loginfreq;
		MIB.LoginTime = logintime;
		return MIB;
	}
	
}
