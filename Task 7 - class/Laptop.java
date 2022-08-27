package com.orthofx;

public class Laptop extends ComputingDevices{
	String battery;
	boolean portable=true;
	
	void readLaptop() {
		System.out.print("Battery : ");
		battery=sc.next();
		devices.get(deviceID).add(battery);	
	}
	
	void displayLaptop() { 
		System.out.println("Battery : "+devices.get(deviceID).get(3));
	}
	
	void updateLaptop(String deviceID) {
		System.out.println("Enter new value :");
		battery=sc.next();
		devices.get(deviceID).set(3,battery);
	}
	
	
	
}

