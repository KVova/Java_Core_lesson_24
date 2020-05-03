package volodymyr;

public class Time {

	private int min;
	private int hour;

	public Time(int min, int hour) throws Exception {
		if (min < 0 || min > 60)
			throw new Exception("You incorrect inputs minutes");
		this.min = min;
		if (hour < 0 || hour > 24)
			throw new Exception("You incorrect inputs hour");
		this.hour = hour;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int compareTo(Time t) {
		return (hour * 60 + min) - (t.getHour() * 60 + t.getMin());
	}
	
	public static Time allTime(Time timea, Time timeb) throws Exception{
		int hour = timea.getHour()+timeb.getHour();
		int min = timea.getMin()+timeb.getMin();
		
		return new Time(min, hour); 
	}

	@Override
	public String toString() {
		return "Time: " + "hour - " + hour + " min - " + min;
	}

}
