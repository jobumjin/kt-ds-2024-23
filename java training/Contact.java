package contact_manager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contact {
	
	private String name;
	private List<String> phoneNumber;
	private LocalDate birthDay;
	private String relationship;
	private boolean block;
	private LocalDate anniversary;
	private String memo;
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getPhoneNumber() {
		return this.phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		if(this.phoneNumber == null) {			
			this.phoneNumber = new ArrayList<>();
		}
		this.phoneNumber.add(phoneNumber);
	}
	public LocalDate getBirthDay() {
		return this.birthDay;
	}
	public void setBirthDay(LocalDate birthDay) {
		this.birthDay = birthDay;
	}
	public String getRelationship() {
		return this.relationship;
	}
	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	public boolean isBlock() {
		return this.block;
	}
	public void setBlock(boolean block) {
		this.block = block;
	}
	public LocalDate getAnniversary() {
		return this.anniversary;
	}
	public void setAnniversary(LocalDate anniversary) {
		this.anniversary = anniversary;
	}
	public String getMemo() {
		return this.memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("Contact [ ");
		sb.append("이름 : " + this.name);
		sb.append(" 핸드폰 번호 : " + this.phoneNumber);
		sb.append(" 관계 : " + this.relationship);
		sb.append(" 생일 : " + this.birthDay);
		sb.append(" 기념일 : " + this.anniversary);
		sb.append(" 차단여부 : " + this.block);
		sb.append(" 메모 : " + this.memo + " ]");
		
		return sb.toString();
	}
	
}
