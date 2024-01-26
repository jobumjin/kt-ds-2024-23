package vehicle;

// 상속이 되지 않게하려면 class 앞에 final을 붙이면 됩니다.
public class Vehicle {
	
	
	private String modelName;
	private boolean engineStatus;
	
	public Vehicle(String name) {
		
	}
	
	public String getModelName() {
		return this.modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	
	public boolean isEngineStatus() {
		return this.engineStatus;
	}

	public void setEngineStatus(boolean engineStatus) {
		this.engineStatus = engineStatus;
	}

	public void startEngine(Vehicle vehicle) {
		vehicle.setEngineStatus(true);
	}
} 
