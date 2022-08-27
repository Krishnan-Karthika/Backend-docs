package com.orthofx;

import java.util.Scanner;

public class MatrixMultiplication {	
	
	public static int[][] readElements(int r,int c,int mat[][]) {
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				mat[i][j]=sc.nextInt();
			}
		}
		return mat;			
	}
	
	
	public static void product(int mat1[][],int mat2[][],int p[][],int r1,int c1,int c2) {
		for(int i = 0; i < r1; i++) {    
            for(int j = 0; j < c2; j++){
            	p[i][j]=0;      
            	for(int k = 0; k < c1; k++){      
            		p[i][j] += mat1[i][k] * mat2[k][j];      
            	}
            	System.out.print(p[i][j] + "   ");  
            }
            System.out.println();
        }   
	}
		
	
	public static void main(String[] args) {		
		Scanner sc=new Scanner(System.in);
		int i=0,j=0,k=0;
						
		System.out.println("Enter row and column count of first matrix: ");
		int r1=sc.nextInt();
		int c1=sc.nextInt();
		
		System.out.println("Enter row and column count of second matrix: ");
		int r2=sc.nextInt();
		int c2=sc.nextInt();
		
		if(c1!=r2) {
			System.out.println("Cannot perform multiplication");
		}
		
		else {
			int mat1[][]=new int[r1][c1];
			int mat2[][]=new int[r2][c2];
			int p[][]=new int[30][30];
			
			System.out.println("Enter elements of first matrix ");
			mat1=readElements(r1,c1,mat1);
			
			System.out.println("Enter elements of second matrix ");
			mat2=readElements(r2,c2,mat2);
			
			System.out.println("Product: ");
			product(mat1,mat2,p,r1,c1,c2);

		}
	}
}
