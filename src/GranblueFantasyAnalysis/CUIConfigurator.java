package GranblueFantasyAnalysis;

import java.util.Scanner;

public class CUIConfigurator {
	CUIConfigurator(){
		
	}
	static void ConfigurationExecute() {
		System.out.println("Which is your OS environment?");
		Scanner scan = new Scanner(System.in);
		if(scan.hasNext("MAC")) {
			System.out.println("Confirmed MAC OS");
		}
		else if(scan.hasNext("WINDOWS")){
			System.out.println("Confirmed WINDOWS OS");
		}
		else {
			System.out.println("Confirmed not supported OS!!");
		}
		scan.close();
		
		return;
	}

}
