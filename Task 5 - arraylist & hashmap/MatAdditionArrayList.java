package com.orthofx;

import java.util.ArrayList;
import java.util.Scanner;

public class MatAdditionArrayList {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		ArrayList<ArrayList<Integer>> mat1 = new ArrayList<ArrayList<Integer>>();
	    ArrayList<ArrayList<Integer>> mat2 = new ArrayList<ArrayList<Integer>>();
	    ArrayList<ArrayList<Integer>> sum = new ArrayList<ArrayList<Integer>>();
		
		System.out.println("Enter row and column count: ");
		int row=sc.nextInt();
		int col=sc.nextInt();
		
		System.out.println("Enter elements of first matrix ");
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				 if(mat1.size() < i + 1) {
	                    mat1.add(i, new ArrayList<>());
	                }
	                mat1.get(i).add(j, sc.nextInt());
			}
		}
		
		System.out.println("Enter elements of second matrix ");
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if(mat2.size() < i + 1) {
                    mat2.add(i, new ArrayList<>());
                }
                mat2.get(i).add(j, sc.nextInt());
			}
		}
		
		System.out.println("Sum of matrices ");
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {				
				 if(sum.size() < i + 1) {
	                    sum.add(i, new ArrayList<>());
	                }
	                sum.get(i).add(j, mat1.get(i).get(j) + mat2.get(i).get(j));
	                System.out.print(sum.get(i).get(j) + "    ");
			}
			System.out.println();
		}
		}

}
