package mislenious;

import java.util.ArrayList;
import java.util.stream.Stream;

class NamePhoneEmail{
	
	String name;
	String phonenum;
	String email;
	
	public NamePhoneEmail(String name, String phonenum, String email) {
		super();
		this.name = name;
		this.phonenum = phonenum;
		this.email = email;
	}
	
}

class NamePhone {
	
	String name;
	String phonenum;
	public NamePhone(String name, String phonenum) {
		super();
		this.name = name;
		this.phonenum = phonenum;
	}
	
}

public class StreamDemoMap {

	public static void main(String[] args) {
		
		ArrayList<NamePhoneEmail> myList = new ArrayList<>();
		
		myList.add(new NamePhoneEmail("Larry", "555-5555","larry@HerbSchidt.com"));
		
		myList.add(new NamePhoneEmail("James", "555-4444","james@HerbSchidt.com"));
		
		myList.add(new NamePhoneEmail("Mary", "555-3333","mary@HerbSchidt.com"));
		
		myList.add(new NamePhoneEmail("Mark", "555-2222","mark@HerbSchidt.com"));
		
		myList.stream().forEach(
				
				a -> System.out.println(a.name + "  " + a.phonenum + " " + a.email)
				
				);
		
		Stream<NamePhone> namePhone = myList.stream().map((a) -> new NamePhone(a.name, a.phonenum));
		
		System.out.println("\n List of the Name and Phone Number");
		
		namePhone.forEach( a -> System.out.println(a.name + "  " + a.phonenum));
		
		Stream<NamePhone> nameAndPhone = myList.stream().filter(a -> a.name.equals("James"))
				.map((a) -> new NamePhone(a.name, a.phonenum));
		
		nameAndPhone.forEach(a -> System.out.println(a.name + " " + a.phonenum));
		
		
		

	}

}
