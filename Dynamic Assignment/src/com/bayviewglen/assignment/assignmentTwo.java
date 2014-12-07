package com.bayviewglen.assignment;

import java.util.Arrays;

public class assignmentTwo {

	@SuppressWarnings("unused")
	public static int Americans(int[] donations){

		int neighborNum = donations.length; 
		//make 2 array, one contain the first to second last, the other contain second to last 
		//handles the ring they make 
		int [] d1 = Arrays.copyOfRange(donations, 0, neighborNum-1); //everything except last donation
		int [] d2 = Arrays.copyOfRange(donations, 1, neighborNum); //everything except first donation
		
		
		int [] dp = new int[neighborNum-1]; 
		int [] dp2 = new int[neighborNum-1]; 
		
		dp[0] = d1[0];
		dp[1] = Math.max(d1[0], d1[1]);
		dp[2] = Math.max(d1[0]+d1[2], d1[1]); 
		
		for(int i = 3; i<neighborNum-1;i++){
			dp[i] = Math.max( dp[i - 2] , dp[i - 3]) + d1[i];
		}
		
		dp2[0] = d2[0];
		dp2[1] = Math.max(d2[1], d2[0]);
		dp2[2] = Math.max(d2[0]+d2[2], d2[1]); 

		for(int i = 3; i<neighborNum-1;i++){
			dp2[i] = Math.max( dp2[i - 2] , dp2[i - 3]) + d2[i];
		}
		int solution; 
		solution = Math.max(dp[neighborNum-2], dp2[neighborNum-2]); 



		return solution;
	}
	public static void main(String[] args){
		int[] donations ={94, 40, 49, 65, 21, 21, 106, 80, 92, 81, 679, 4, 61,  
				  6, 237, 12, 72, 74, 29, 95, 265, 35, 47, 1, 61, 397,
				  52, 72, 37, 51, 1, 81, 45, 435, 7, 36, 57, 86, 81, 72};
		System.out.println(Americans(donations)); 
	}

}


