package com.orthofx;

import java.util.Scanner;

public class StarFor {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of layers: ");
		int layers=sc.nextInt();
		
		for(int i=1;i<=layers;i++) {
			for(int gap=i;gap<layers;gap++) {
				System.out.print(" ");
			}
			for(int j=0;j < 2*i-1;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
