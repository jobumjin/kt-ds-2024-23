package vending_machine;

// 확장은 한개의 클래스만 가져올 수 있다. 
public class TemperatureProduct extends Product{
	
	/**
	 * 상품이 뜨거운지 차가운지에 대한 정보
	 * true : 뜨거운 상품 False : 차가운 상품
	 */
	private boolean isHot;

	public boolean getIsHot() {
		return this.isHot;
	}

	public void setIsHot(boolean isHot) {
		this.isHot = isHot;
	}
	
	
}
