package vehicle;

public class EV extends Vehicle{
	
	int battery;
	
	public EV(String name) {
		super(name);
	}
	
	public int getBattery() {
		return this.battery;
	}

	public void setBattery(int battery) {
		this.battery = battery;
	}
	
	public void checkBattery() {
		
	}
	
}
