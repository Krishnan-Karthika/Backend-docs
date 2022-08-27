package com.orthofx;

import java.util.Scanner;

public class Marks{
	public static void main(String[] args) {
		char choice;
		
		do {
		System.out.println("Enter mark: ");
		Scanner sc=new Scanner(System.in);
		double mark=sc.nextDouble();
		
		if(mark>=90)
			System.out.println("Amazing");
		else if(mark<90 && mark>=80)
			System.out.println("Good");
		else if(mark<80 && mark>=70)
			System.out.println("All right");
		else if(mark<70)
			System.out.println("Okay");
		
		System.out.println("\nPress y to continue...");
		choice=sc.next().charAt(0);
	}
		while(choice == 'y' || choice =='Y');
	}

}
