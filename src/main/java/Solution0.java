/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dnino
 */
public class Solution0 {

   static int[] counts(int[] nums, int[] maxes) {
       
        int i=0;
        int j=0;
        
        int[] count=new int[maxes.length];
        
        for(i=0;i<maxes.length;i++)
        {
            count[i]=0; 
            for(j=0;j<nums.length;j++)
            {                
                if(nums[j]<=maxes[i])
                {
                   count[i]=count[i]+1; 
                }
            }   
        }    
         return count;
    }
   
   /*Work in progress .. not finished for time*/
   static int[] countsAlternative(int[] nums, int[] maxes) {
       
        int i=0;
        int j=0;
        
        int[] count=new int[maxes.length];
        
        
        java.util.Arrays.sort(nums);
        
        for(i=0;i<maxes.length;i++)
        {
            count[i]=0; 
            j=nums.length-1;
            
            while(nums[j]>maxes[i])
            {
                count[i]=count[i]++;
                j--;
            }            
        }    
         return count;
    }
   
     public static void main(String[] args){
         
         /*
         int[] nums = new int[] {2,10,5,4,8};
         int[] maxes = new int[] {3,1,7,8};
         */
         int[] nums = new int[] {1,4,2,4};
         int[] maxes = new int[] {3,5};
         
         
         int[] count = counts(nums,maxes);
         
         for(int cte : count)
         {
             System.out.println(cte);
         } 
         
         count = countsAlternative(nums,maxes);
         
         for(int cte : count)
         {
             System.out.println(cte);
         } 
         
     }
}