package GranblueFantasyAnalysis;

public class RingbufferExecute {
	private int[] num;
	private int max;
	private int ave;
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
		// Array Initialize
		for(int i=0; i<MaxSize; i++) {
			this.num[i] = 0;
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
	
	private void maxCalc() {
		this.max = 0;
		for(int i=0; i<MaxSize; i++) {
			this.max = this.num[i]++;
		}
	}
	
	private void aveCalc(int num) {
		this.ave = 0;
		this.ave = this.max / num;
	}
	
	public int maxCalcRet() {
		maxCalc();
		return this.max;
	}
	
	public int aveCalcRet(int num) {
		this.maxCalc();
		this.aveCalc(num);
		return this.ave;
	}
	
	
}
