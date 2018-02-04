package GranblueFantasyAnalysis;

import GranblueFantasyAnalysis.GuraburuConfig;

public class TimeSleep {
	private int time;
	
	TimeSleep(){
		GuraburuConfig Conf = GuraburuConfig.getInstance();
		this.time = Conf.TL_Time;
	}
	
	TimeSleep(int millisec){
		this.time = millisec;
	}
	public int Sleep(){
		try {
			Thread.sleep(this.time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("wait error!¥n");
		}
		return 1;
	}
	public int Sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("wait error!¥n");
		}
		return 1;
	}
}
