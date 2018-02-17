package GranblueFantasyAnalysis;

public class RingbufferExecute {
	private int[] num;
	private int max;
	
	private int ave;
	private int head = 0;
	private int tail = 0;
	private final int MaxSize = 24;
	private int maxsize = MaxSize;
	private int pastdata = 0;
	private int currentdata = 0;
	
	public int diff;
	
	RingbufferExecute(int maxnum){
		if(maxnum <= MaxSize) {
			this.num = new int[maxnum];
			this.maxsize = maxnum;
		}
		else {
			this.num = new int[MaxSize];
		}
		// Array Initialize
		for(int i=0; i<maxnum; i++) {
			this.num[i] = 0;
		}
		
	}
	
	public void push(int value) {
		this.num[tail] = value;
		this.tail = (this.tail + 1) % this.num.length;
		this.maxCalc();
		this.pastdata = this.currentdata;
		this.currentdata = value;
		this.diff = this.currentdata - this.pastdata;
	}
	
	public int pull() {
		final int buf = this.num[head];
		this.head =(this.head + 1) % this.num.length;
		return buf;
	}
	
	private void maxCalc() {
		this.max = 0;
		for(int i=0; i<this.maxsize; i++) {
			this.max += this.num[i];
		}
	}
	
	private void aveCalc(int num) {
		this.ave = 0;
		this.ave = this.max / num;
	}
	
	public int maxCalcRet() {
		return this.max;
	}
	
	public int aveCalcRet(int num) {
		this.aveCalc(num);
		return this.ave;
	}
	
}
