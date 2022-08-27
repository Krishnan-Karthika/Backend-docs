package com.orthofx;

import java.util.Scanner;

public class StarWhile {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of layers ");
		int layers=sc.nextInt();
		
		int i=1;
		while(i<=layers) {
			int gap=i;
			while(gap<layers) {
				System.out.print(" ");
				gap++;
			}
			int k=0;
			while(k<i*2-1) {
				System.out.print("*");
				k++;
			}
			System.out.println();
			i++;
		}
	}

}
