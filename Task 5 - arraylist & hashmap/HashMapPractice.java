package com.orthofx;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapPractice {
	public static void main(String[] args) {
	    HashMap<String, Integer> studentMark = new HashMap<String, Integer>();
	    Scanner sc =new Scanner(System.in);
	    int count=0;
	    char choice;
	    
	    do {
		    System.out.println("Press \n 1.To enter marks\n 2.To view particular student record");
		    int input= sc.nextInt();
		    
		    switch(input){
		    case 1:
		    	System.out.println("Enter number of records to enter");
		    	count=sc.nextInt();
		    	System.out.println("enter student name and mark");
		    	for(int i=0;i<count;i++) {
		    		String name=sc.next();
			 	    int mark=sc.nextInt();
			 	    studentMark.put(name, mark);
		    	}
		 	    System.out.println(studentMark);
		 	    break;
		    
		    case 2:
		    	System.out.println("Enter student name ");
			    String key=sc.next();
			    System.out.println(studentMark.get(key));
			   // System.out.println(studentMark);
			    break;
		    
		    default:
		    	System.out.println("wrong choice ");
		    	break;
		    }	
		    
		    System.out.println("Press y to continue");
		    choice=sc.next().charAt(0);
			}		
	    
	    while(choice == 'y' || choice =='Y');
	    
	    
	    
	}
}
