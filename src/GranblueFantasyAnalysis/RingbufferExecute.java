package GranblueFantasyAnalysis;

public class RingbufferExecute {
	private int[] num;
	private int head = 0;
	private int tail = 0;
	private final int MaxSize = 24;
	
	RingbufferExecute(int maxnum){
		if(maxnum <= MaxSize) {
			this.num = new int[maxnum];
		}
		else {
			this.num = new int[MaxSize];
		}
		
	}
	
	public void push(int value) {
		this.num[tail] = value;
		this.tail = (this.tail + 1) % this.num.length;
	}
	
	public int pull() {
		final int buf = this.num[head];
		this.head =(this.head + 1) % this.num.length;
		return buf;
	}
	
	
}
