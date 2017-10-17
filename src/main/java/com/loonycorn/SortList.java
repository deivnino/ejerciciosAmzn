package com.loonycorn;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SortList {

	public static void main(String[] args) {
		/*
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        String[] unsorted = new String[n];        
        for(int unsorted_i=0; unsorted_i < n; unsorted_i++){
            unsorted[unsorted_i] = in.next();
        }
        // your code goes here
		 */
		int n = 5;
		String[] unsorted = new String[] {"10","1", "8", "3", "5"};
		quickSort(unsorted, 0, unsorted.length - 1);
		for(int unsorted_i=0; unsorted_i < n; unsorted_i++){
			System.out.println(unsorted[unsorted_i]);
		}

	}
	public static void quickSort(String list[], int low, int high) {

		int pivot=Integer.parseInt(list[low]); // take firstelement pivot
		int i=low; // i izq
		int j=high; // j der
		int aux;

		while(i<j){            // while i<j
			while(Integer.parseInt(list[i])<=pivot && i<j)
                            i++; // element greater than pivot
			while(Integer.parseInt(list[j])>pivot)
                            j--;         // element lower
			if (i<j) {                      // if the elements dont cross                      
				aux= Integer.parseInt(list[i]);                  // swap it
				list[i]=list[j];
				list[j]=String.valueOf(aux);
			}
		}
		list[low]=list[j]; // pivot in the place
		list[j]=String.valueOf(pivot); // lower left y greater rigth
		if(low<j-1)
			quickSort(list,low,j-1); // ordenamos subarray low
		if(j+1 <high)
			quickSort(list,j+1,high); // ordenamos subarray high
	}
}
