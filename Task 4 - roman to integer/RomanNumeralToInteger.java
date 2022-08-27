package com.orthofx;

import java.util.Scanner;

public class RomanNumeralToInteger {
	
	//method to return value of each roman numeral
	static int romValue(char s) {
		int val=0;
		if(s=='M') val=1000;
		else if(s=='D') val=500;
		else if(s=='C') val=100;
		else if(s=='L') val=50;
		else if(s=='X') val=10;
		else if(s=='V') val=5;
		else if(s=='I') val=1;
		else 
			System.out.println("Wrong value entered");	
		return val;
		}
	
	//method to convert roman string into integer
	static int converter(String s) {
		int sum=0,v=0,v1=0;
		
		//get value of char at i
		for(int i=0;i<s.length();i++) {
			v=romValue(s.charAt(i));
			
			//get value of char at (i+1)th position and calculate sum
			if((i+1)<s.length()) {
				v1=romValue(s.charAt(i+1));		
				
				if(v>=(v1)) 
					sum=sum+v;					
				else {
					sum=sum+(v1-v);
					i++;					
				}
			}
			else
				sum=sum+v;				
		}		
		return sum;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a roman numeral: ");
		String rnum=sc.next();
		System.out.println("Integer value of "+rnum+" is: "+converter(rnum));			
}
}
