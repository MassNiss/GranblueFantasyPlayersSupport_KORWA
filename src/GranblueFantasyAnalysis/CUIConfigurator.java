package GranblueFantasyAnalysis;

import java.util.Scanner;

public class CUIConfigurator {
	CUIConfigurator(){
		
	}
	static void ConfigurationExecute() {
		GuraburuConfig Conf = GuraburuConfig.getInstance();
		System.out.println("Which is your OS environment?");
		Scanner scan = new Scanner(System.in);
		if(scan.hasNext("MAC")) {
			System.out.println("Confirmed MAC OS");
			Conf.WR.CreanFile("./ExtData/OSInfo.txt");
			Conf.WR.WriteLine("./ExtData/OSInfo.txt", "MAC");
		}
		else if(scan.hasNext("WINDOWS")){
			System.out.println("Confirmed WINDOWS OS");
			Conf.WR.CreanFile("./ExtData/OSInfo.txt");
			Conf.WR.WriteLine("./ExtData/OSInfo.txt", "WINDOWS");
		}
		else {
			System.out.println("Confirmed not supported OS!!");
		}
		scan.close();
		
		return;
	}

}
