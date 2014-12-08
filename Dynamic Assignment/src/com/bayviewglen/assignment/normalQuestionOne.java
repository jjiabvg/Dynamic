package com.bayviewglen.assignment;

import java.util.ArrayList;
import java.util.Scanner;

public class normalQuestionOne {

	public static int zigZag(int [] sequence){
		
		int sequenceLength = sequence.length; 
			int []positiveResult = new int[sequenceLength];  //one array for the case when Ax+1 > Ax
			int []negativeResult = new int[sequenceLength];  //one array for the case when Ax+1 > Ax
			int best = 1;
			positiveResult[0] = 1; // if there is only one number, it can only be 1
			negativeResult[0] = 1; 


		for(int i = 1; i < sequenceLength; i++){
			for(int j = i-1; j>= 0; j--){
				if(sequence[j] < sequence[i]) //dynamic programming
					positiveResult[i] = Math.max(negativeResult[j]+1,positiveResult[i]); // check the number by going across the two array
				// because it has to go positive then negative
				else if(sequence[j] > sequence[i]) 
					negativeResult[i] = Math.max(positiveResult[j]+1, negativeResult[i]);
			}
			best = Math.max(best, Math.max(positiveResult[i],negativeResult[i]));
		}
		return best;

	}	

	public static void main(String[] args){
	
		int [] sequence = {374, 40, 854, 203, 203, 156, 362, 279, 812, 955, 
				600, 947, 978, 46, 100, 953, 670, 862, 568, 188, 
				67, 669, 810, 704, 52, 861, 49, 640, 370, 908, 
				477, 245, 413, 109, 659, 401, 483, 308, 609, 120, 
				249, 22, 176, 279, 23, 22, 617, 462, 459, 244}; 
	
		System.out.print(zigZag(sequence));
	}
	
}
