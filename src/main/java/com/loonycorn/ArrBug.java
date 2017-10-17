/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.loonycorn;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author dnino
 */
public class ArrBug {
    
        		    public static void main(String[] args) {
                                
                                ArrayList<Integer> places = rotateArray(new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6)),7);
                                for(int i:places)
                                {
                                	System.out.println(i);
                                }
                            }
    
        			public static ArrayList<Integer> rotateArray(ArrayList<Integer> A, int B) {
        				ArrayList<Integer> ret = new ArrayList<Integer>();
        				if(B>=A.size())
        					B%=A.size();
        				for (int i = 0; i < A.size(); i++) {
        					if(!(i==(A.size()-1)))
        					{
        					ret.add(A.get(i + B));
        					}
        					else
        					{
        						ret.add(A.get(i + B-A.size()));
        					}
        					
        				}
        				return ret;
        			}
}
