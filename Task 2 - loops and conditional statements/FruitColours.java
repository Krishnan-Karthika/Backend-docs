package com.orthofx;

import java.util.Scanner;

public class FruitColours {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter fruit name: ");
		String fruit=sc.next();
		
		switch(fruit){
		case("apple"):
			System.out.println("Red");
			break;
		case("banana"):
			System.out.println("Yellow");
			break;
		default:
			System.out.println("Green");			
		}
	}

}
