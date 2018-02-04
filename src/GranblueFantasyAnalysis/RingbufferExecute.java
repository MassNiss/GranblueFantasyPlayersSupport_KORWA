package GranblueFantasyAnalysis;

public class RingbufferExecute {
	private int[] num;
	private int head = 0;
	private int tail = 0;
	private final int MaxSize = 24;
	
	RingbufferExecute(int maxnum){
		if(maxnum <= MaxSize) {
			num = new int[maxnum];
		}
		else {
			num = new int[MaxSize];
		}
		
	}
	
	public void push(int value) {
		num[tail] = value;
		tail = (tail + 1) % num.length;
	}
	
	public int pull() {
		final int buf = num[head];
		head =(head + 1) % num.length;
		return buf;
	}
	
	
}
