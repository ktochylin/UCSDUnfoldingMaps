package testing;

import module3.*;

public class TestInheritance {
	
	public static void main(String[] args) {
		
		Student s = new Student();
		Person p = new Person();
		Person q = new Person();
		Faculty f = new Faculty();
		Object o = new Faculty();
		
		String n = s.getName();
		p = s;
		int m = p.getID();
		f = q;
		o = s;
	}
	
}
