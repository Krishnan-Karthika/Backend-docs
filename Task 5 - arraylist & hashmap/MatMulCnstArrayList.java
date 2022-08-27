package com.orthofx;

import java.util.ArrayList;
import java.util.Scanner;

public class MatMulCnstArrayList {
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		ArrayList<ArrayList<Integer>> mat = new ArrayList<ArrayList<Integer>>();
	    ArrayList<ArrayList<Integer>> p = new ArrayList<ArrayList<Integer>>();
		
		System.out.println("Enter row and column count: ");
		int row=sc.nextInt();
		int col=sc.nextInt();
		
		System.out.println("Enter elements of matrix: ");
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if(mat.size() < i + 1) {
                    mat.add(i, new ArrayList<>());
                }
                mat.get(i).add(j, sc.nextInt());
			}
		}
		
		System.out.println("Enter an integer: ");
		int num=sc.nextInt();
		
		System.out.println("Product: ");
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if(p.size() < i + 1) {
                    p.add(i, new ArrayList<>());
                }
                p.get(i).add(j, mat.get(i).get(j)  * num);
                System.out.print(p.get(i).get(j) + "    ");
				
				
			}
			System.out.println();
		}
		
		

}
}

