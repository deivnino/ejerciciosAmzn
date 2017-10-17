/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.loonycorn;

/**
 *
 * @author dnino
 */
public class RepeatAndMissingInArray {
    
    
        static int[] arr = new int[] {3,1,2,5,3};
        
       		    public static void main(String[] args) {

                      quickSort(arr, 0, arr.length-1); 
                      for(int i=0; i < 5; i++){
                            //System.out.println(arr[i]);
                                if(arr[Math.abs(arr[i])-1] > 0)
                                {    
                                    arr[Math.abs(arr[i])-1] = -arr[Math.abs(arr[i])-1];
                                }
                                else
                                {    
                                    System.out.println(arr[i]);
                                }    
                            }
                      for(int i=0; i < 5; i++){
                          if(arr[i]>0)
                            System.out.println(i+1);
                      }
                         
                    }
    	public static void quickSort(int list[], int low, int high) {

		int pivot=list[low]; // take firstelement pivot
		int i=low; // i izq
		int j=high; // j der
		int aux;

		while(i<j){            // while i<j
			while(list[i]<=pivot && i<j)
                            i++; // element greater than pivot
			while(list[j]>pivot)
                            j--;         // element lower
			if (i<j) {                      // if the elements dont cross                      
				aux= list[i];                  // swap it
				list[i]=list[j];
				list[j]=aux;
			}
		}
		list[low]=list[j]; // pivot in the place
		list[j]=pivot; // lower left y greater rigth
		if(low<j-1)
			quickSort(list,low,j-1); // ordenamos subarray low
		if(j+1 <high)
			quickSort(list,j+1,high); // ordenamos subarray high
	}
}
