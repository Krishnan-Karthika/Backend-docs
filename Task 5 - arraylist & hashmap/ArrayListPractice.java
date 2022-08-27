package com.orthofx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ArrayListPractice {
	public static void main(String args[]) {
		ArrayList<String> names=new ArrayList<String>();
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter 10 names: ");
		for(int i=0; i<10; i++) {
			String inp=sc.next();
			names.add(inp);
		}	
				
		System.out.println("Entered names are: ");
		System.out.println(names);	
		
		System.out.println("Names in sorted order: ");
		Collections.sort(names);
		System.out.println(names);
		
//		for (int i = 0; i < names.size(); i++) 
//            System.out.print(names.get(i) + " ");
	}
}
