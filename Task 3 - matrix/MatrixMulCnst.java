package com.orthofx;

import java.util.Scanner;

public class MatrixMulCnst {
public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int mat[][]=new int[10][10];
		int p[][]=new int[10][10];
		
		System.out.println("Enter row and column count: ");
		int row=sc.nextInt();
		int col=sc.nextInt();
		
		System.out.println("Enter elements of matrix: ");
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				mat[i][j]=sc.nextInt();
			}
		}
		
		System.out.println("Enter an integer: ");
		int num=sc.nextInt();
		
		System.out.println("Product: ");
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				p[i][j]=mat[i][j]*num;
				System.out.print(p[i][j]+"   ");
			}
			System.out.println();
		}
		

}
}
