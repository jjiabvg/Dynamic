package com.bayviewglen.assignment;

import java.util.ArrayList;
import java.util.Scanner;

public class normalQuestionOne {

	public static int zigZag(int [] sequence){
		
		int sequenceLength = sequence.length; 
			int []positiveResult = new int[sequenceLength]; 
			int []negativeResult = new int[sequenceLength]; 
			int best = 1;
			positiveResult[0] = 1; 
			negativeResult[0] = 1; 


		for(int i = 1; i < sequenceLength; i++){
			for(int j = i-1; j>= 0; j--){
				if(sequence[j] < sequence[i]) //dynamic programming
					positiveResult[i] = Math.max(negativeResult[j]+1,positiveResult[i]);
				else if(sequence[j] > sequence[i]) 
					negativeResult[i] = Math.max(positiveResult[j]+1, negativeResult[i]);
			}
			best = Math.max(best, Math.max(positiveResult[i],negativeResult[i]));
		}
		return best;

	}	

	public static void main(String[] args){
	
		Scanner scanner = new Scanner(System.in);
		int [] sequence = null; 
		int length; 
		System.out.println("Enter the length of the sequence"); 
		length = scanner.nextInt(); 
		sequence = new int[length]; 
		System.out.println("Enter the sequence");
		System.out.println("Enter one number then hit enter.");
	    for (int i = 0; i < sequence.length; i++) { //load the numbers into an array 
	    	sequence[i] = scanner.nextInt();
	    }
	    
		System.out.println("ZigZag sequence length is");

		System.out.print(zigZag(sequence));
	}
	
}
