package com.orthofx;


public class Desktop extends ComputingDevices{
	/*PCIe slots come in different physical configurations: x1, x4, x8, x16, x32. 
	 * The number after the x tells you how many lanes 
	 * (how data travels to and from the PCIe card) that PCIe slot has.*/
	String pci;
	
	void readDesktop() {
		System.out.print("PCI config : ");
		pci=sc.next();
		devices.get(deviceID).add(pci);	
	}
	
	void displayDesktop() {
			System.out.println("PCI Config : "+devices.get(deviceID).get(3));
	}
	
	void updateDesktop(String deviceID) {
		System.out.println("Enter new value :");
		String input=sc.next();
		devices.get(deviceID).set(3,input);
	}
}

