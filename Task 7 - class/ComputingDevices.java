package com.orthofx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ComputingDevices {
	static HashMap<String, ArrayList<String>> devices = new HashMap<String, ArrayList<String>>();
	//ComputingDevices cd=new ComputingDevices();
	static Desktop d=new Desktop();
	static Laptop l=new Laptop();
	static Scanner sc=new Scanner(System.in);
	String processor,os,ram;
	String deviceID;	
	int check=10;
		
	public static void main(String args[]) {
		int dev_ch=0,ch=0,op;
		do {
			System.out.println("Choose a device \n1.Desktop \n2.Laptop\n");
			dev_ch=sc.nextInt();
			switch(dev_ch){
				case 1:
					do {
						System.out.println("Select \n1.Enter new record \n2.Display records \n3.Update existing record \n4.Delete record");
						op=sc.nextInt();
						switch(op) {
						case 1:
							d.read();
							break;
							
						case 2:
							d.display();
							break;
							
						case 3:
							d.update();
							break;
						
						case 4:
							d.delete();
							break;
							
						default:
							System.out.println("Invalid option..!");
							break;
						}
						System.out.println("Press 1 to continue operations on desktop records");
						ch=sc.nextInt();
					}while(ch==1);		
					break;
				
				case 2:
					do {
					System.out.println("Select \n1.Enter new record \n2.Display records \n3.Update existing record \n4.Delete record");
					op=sc.nextInt();
					switch(op) {
					case 1:
						l.read();
						break;
						
					case 2:
						l.display();
						break;
						
					case 3:
						l.update();
						break;
						
					case 4:
						d.delete();
						break;

					default:
						System.out.println("Invalid option..!");
						break;
					}
					System.out.println("Press 1 to continue operations on laptop records");
					ch=sc.nextInt();
				}while(ch==1);		
					break;
				
				default:
					System.out.println("Invalid choice of device..!");
			}
			System.out.println("Press 1 to select device");
			ch=sc.nextInt();
		}while(ch==1);		
	}
	
	
	public void read() {
		System.out.println("Enter details");
		System.out.print("Device ID : ");
		deviceID=sc.next();
		if (devices.containsKey(deviceID)) {
			System.out.println("Corresponding records already exist");
		} else {
			devices.put(deviceID, new ArrayList<String>());
			System.out.print("Processor : ");
			processor=sc.next();
			devices.get(deviceID).add(processor);
			System.out.print("OS : ");
			os=sc.next();
			devices.get(deviceID).add(os);
			System.out.print("RAM : ");
			ram=sc.next();
			devices.get(deviceID).add(ram);
			
			if(deviceID.indexOf("lid")!=-1) {
				l.readLaptop();
				//System.out.println("Battery : "+devices.get(deviceID).get(3));
			}
			else {
				d.readDesktop();
				//System.out.println("PCI Config : "+devices.get(deviceID).get(3));
			}
		}	
	}
	
	public void display() {
		System.out.println("Device ID :");
		deviceID=sc.next();
		if (devices.containsKey(deviceID)) {
		System.out.println("Processor : "+devices.get(deviceID).get(0));
		System.out.println("OS : "+devices.get(deviceID).get(1));
		System.out.println("RAM : "+devices.get(deviceID).get(2));
		
		if(deviceID.indexOf("lid")!=-1) {
			l.displayLaptop();
			//System.out.println("Battery : "+devices.get(deviceID).get(3));
		}
		else {
			d.displayDesktop();
			//System.out.println("PCI Config : "+devices.get(deviceID).get(3));
		}
		}
		else
			System.out.println("No corresponding records");		
	}
	
	public void update() {
		System.out.println("Device ID :");
		deviceID=sc.next();
		if (devices.containsKey(deviceID)) {
			System.out.println("Enter key to update: ");
			String key=sc.next();
			
			 if (key.equalsIgnoreCase("processor")) {
				 System.out.println("Enter new value :");
				 processor=sc.next();
				devices.get(deviceID).set(0,processor);				 
			 }
			 else if (key.equalsIgnoreCase("OS")) {
				 System.out.println("Enter new value :");
				 os=sc.next();
				devices.get(deviceID).set(1,os);				 
			 }
			 else if (key.equalsIgnoreCase("RAM")) {
				 System.out.println("Enter new value :");
				 ram=sc.next();
				devices.get(deviceID).set(2,ram);				 
			 }
			 else if (key.equalsIgnoreCase("battery")) {
				l.updateLaptop(deviceID);
			 }
			 else if (key.equalsIgnoreCase("pci")) {
				d.updateDesktop(deviceID);
			 }
		}
		else
			System.out.println("No corresponding records");
	}
	
	public void delete() {
		System.out.println("Device ID :");
		deviceID=sc.next();
		if (devices.containsKey(deviceID)) {
			devices.remove(deviceID);
		}else
			System.out.println("No corresponding records");
	}
}



