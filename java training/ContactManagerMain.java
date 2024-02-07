package contact_manager;

public class ContactManagerMain {
	public static void main(String[] args) {
		
		ContactManager test = new ContactManager();
		
		test.addOneContact();
		test.addOneContact();
		test.addOneContact();
//		contact1.setName("수퍼맨");
//		System.out.println(test);
//		System.out.println(test);
//		test.getContact();
		test.printAllContact();
		test.printSearchContact("asdf");
		test.deleteOneContact("asdf");
		test.printAllContact();
	}
}
