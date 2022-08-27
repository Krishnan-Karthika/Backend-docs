package com.orthofx;

import java.util.ArrayList;
import java.util.Scanner;

public class MatMulArrayList {
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
				
		System.out.println("Enter row and column count of first matrix: ");
		int r1=sc.nextInt();
		int c1=sc.nextInt();
		
		System.out.println("Enter row and column count of second matrix: ");
		int r2=sc.nextInt();
		int c2=sc.nextInt();
		
		if(r2!=c1) {
			System.out.println("Cannot perform multiplication");
			//exit;
		}
		else {
			ArrayList<ArrayList<Integer>> mat1 = new ArrayList<ArrayList<Integer>>();
		    ArrayList<ArrayList<Integer>> mat2 = new ArrayList<ArrayList<Integer>>();
		    ArrayList<ArrayList<Integer>> p = new ArrayList<ArrayList<Integer>>();
			
			System.out.println("Enter elements of first matrix ");
			for(int i=0;i<r1;i++) {
				for(int j=0;j<c1;j++) {
					 if(mat1.size() < i + 1) {
		                    mat1.add(i, new ArrayList<>());
		                }
		                mat1.get(i).add(j, sc.nextInt());
				}
			}
			
			System.out.println("Enter elements of second matrix ");
			for(int i=0;i<r2;i++) {
				for(int j=0;j<c2;j++) {
					if(mat2.size() < i + 1) {
	                    mat2.add(i, new ArrayList<>());
	                }
	                mat2.get(i).add(j, sc.nextInt());
				}
			}
			
			System.out.println("Product: ");
			for(int i = 0; i < r1; i++) {
				for(int j = 0; j < c2; j++) {
	            	int temp=0;
	            	for(int k = 0; k < c1; k++){
		            	if(p.size() < i + 1) {
		                    p.add(i, new ArrayList<>());
		                }
		            	temp+=mat1.get(i).get(k)*mat2.get(k).get(j);
		            	p.get(i).add(j,temp);
	            	}
	            	System.out.print(p.get(i).get(j) + "    ");
	             }
	            System.out.println();
			}
			
	                
	       }
	            
 }    			
			
			
}
