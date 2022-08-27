package com.orthofx;

import java.util.Scanner;

public class StringReverse {
	public static void main(String[] args) {
		int i;
		char s;
		String str,revStr="";
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a string ");
		str=sc.next();
		
		/*		for(i=str.length()-1;i>=0;i--) {
			s=str.charAt(i);
			revStr=revStr+s;	
			System.out.println(revStr);
		} */
		
		    for(i=0;i<str.length();i++) {
			s=str.charAt(i);
			revStr=s+revStr;
			System.out.println(revStr);
		}    
		
		System.out.println(revStr);
	}

}
