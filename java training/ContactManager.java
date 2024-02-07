package contact_manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactManager {
	private List<Contact> contacts;
	
	public ContactManager() {
		this.contacts = new ArrayList<>();
	}

	/**
	 * 이름검색을 통한 연락처 정보조회 및 수정
	 * @param name 연락처 검색을 위한 이름
	 */
	public void printAndUpdateDetailContact(String name) {
		// add 와 비슷하게..감.. 그냥 받아와버릴까.. 
	}
	
	/**
	 * 모든 연락처 보여주기
	 */
	public void printAllContact() {
		for ( Contact contact  : this.contacts ) {
			if(contact != null) {				
				System.out.println(contact);
			}
		}
	}
	
	/**
	 * 이름검색을 통한 연락처 정보조회
	 * @param name 연락처 검색을 위한 이름
	 */
	public void printSearchContact(String name) {
		if(contacts != null) {
			int count = 0;
			for ( Contact contact  : this.contacts ) {		
				if(contact.getName().equals(name)) {
					System.out.println("검색한 이름의 연락처 정보입니다.");
					System.out.println(contact);
					count++;
				}	
			}
			if(count == 0) {
				System.out.println("검색한 이름의 연락처 정보가 없습니다.");
			}
		}
	}
	
	/**
	 * 이름을 통한 연락처 정보 삭제
	 * @param name 삭제할 연락처 정보
	 */
	public void deleteOneContact(String name) {
		if(contacts != null) {
			int count = 0;
			for(Contact contact : this.contacts) {
				if (contact.getName().equals(name)) {
					contacts.remove(contact);
					System.out.println(name + "의 연락처 정보가 삭제가 되었습니다.");
					count++;
				}
			}
			if(count == 0) {
				System.out.println("삭제할 이름의 연락처 정보가 없습니다.");
			}
		}
			
		
	}
	/**
	 * 새로운 연락처 추가
	 */
	public void addOneContact() {
		Contact contact = new Contact();
		
		System.out.println("저장할 이름을 입력하세요.");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		contact.setName(name);
		// if -- 입력을 안하거나.. 한글이 아닌 걸 받았을때 처리 추가하기  
		for(int i = 0; i < this.contacts.size(); i++) {
			while (name.equals(contacts.get(i).getName())) {
				System.out.println("이름이 중복됩니다. 다시 입력하세요.");
				sc = new Scanner(System.in);
				name = sc.nextLine();
			}
			contact.setName(name);
		}
		
//		System.out.println("저장할 번호를 입력하세요.");
//		String phoneNumber = sc.nextLine();
//		contact.setPhoneNumber(phoneNumber);
////		for (int i = 0; i )
//		if(true) {
//			System.out.println("추가로 저장할 번호를 입력하세요.");
//			phoneNumber = sc.nextLine();
//			contact.setPhoneNumber(phoneNumber);
//			
//		}
		
		
		
		
		contacts.add(contact);
		
		
	}
	
	/**
	 * 생일 정보 보여주기
	 */
	public void printBirthDayContact(String name) {
	
	}
	
	/**
	 * 생일이 15일 이내인 사람의 연락처 정보 보여주기
	 * 몇일 남았는지와 함께 가까운순으로 보여주기
	 */
	public void printBirthDDayContact() {
		
	}
	
	public void printAnniversaryContact(String name) {
		
	}
	
	public void updateMemo(String name) {
		
	}
	
	public void deleteMemo(String name) {
		
	}
	
	public void printMemo(String name) {
		
	}
	
	public void groupSearch(String relationship) {
		
	}
	
	public void addBlockNumber(String name) {
		
	}
	
	
}
