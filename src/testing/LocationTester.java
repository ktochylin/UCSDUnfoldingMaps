package testing;

import demos.SimpleLocation;

public class LocationTester {

	public static void main(String[] args) {
		
		double d = -77;
		SimpleLocation lima = new SimpleLocation(-12.0, d);
		SimpleLocation washDC = new SimpleLocation(38.9, lima.longitude);
		
		//lima.longitude = -31;
	    
		//d = -31;
		
		lima = washDC;
		
		//lima.latitude = -33;
		
		lima.echoMembers();
		washDC.echoMembers();
		
	}
}
