package com.orthofx;

import java.util.Scanner;

public class MatrixAddition {
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int mat1[][]=new int[10][10];
		int mat2[][]=new int[10][10];
		int sum[][]=new int[10][10];
		
		System.out.println("Enter row and column count: ");
		int row=sc.nextInt();
		int col=sc.nextInt();
		
		System.out.println("Enter elements of first matrix ");
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				mat1[i][j]=sc.nextInt();
			}
		}
		
		System.out.println("Enter elements of second matrix ");
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				mat2[i][j]=sc.nextInt();
			}
		}
		
		System.out.println("Sum of matrices ");
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				sum[i][j]=mat1[i][j]+mat2[i][j];
				System.out.print(sum[i][j]+"  ");
			}
			System.out.println();
		}
		
	}
}
