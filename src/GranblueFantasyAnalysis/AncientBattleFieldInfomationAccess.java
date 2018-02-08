package GranblueFantasyAnalysis;

import java.util.ArrayList;

public class AncientBattleFieldInfomationAccess {
	
private ArrayList<ContributionDegreeStore> ContributionStructure = new ArrayList<>();
	
	public void ContributionDegreeAdd(int mycont, int mybricont, int oppcont, int diff, int most, int tentimes) {
		this.ContributionStructure.add(InstanceForStoring(mycont, mybricont, oppcont, diff, most, tentimes));
	}
	
	private class ContributionDegreeStore{
		int MyCont;
		int MyBriCont;
		int OppCont;
		int Diff;
		int MostRecent;
		int TenTimesRecent;
	}
	
	private ContributionDegreeStore InstanceForStoring
	(int mycont, int mybricont, int oppcont, int diff, int mostrecent, int tentimesrecent){
		ContributionDegreeStore CDS = new ContributionDegreeStore();
		CDS.MyCont = mycont;
		CDS.MyBriCont = mybricont;
		CDS.OppCont = oppcont;
		CDS.Diff = diff;
		CDS.MostRecent = mostrecent;
		CDS.TenTimesRecent = tentimesrecent;
		return CDS;
	}

}
