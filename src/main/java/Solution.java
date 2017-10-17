/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dnino
 */
public class Solution {

    static int[] getMinimumDifference(String[] a, String[] b) {
        int i = 0;
        
        int[] count=new int[Integer.max(a.length,b.length)];
        
        for(i=0;i<Integer.min(a.length,b.length);i++)
        {
            if(a[i].length()!=b[i].length())
            {
                count[i]=-1;
            }
            else
            {
                char[] charsA = a[i].toCharArray();
                java.util.Arrays.sort(charsA);
                String sortedA = new String(charsA);
                
                char[] charsB = b[i].toCharArray();
                java.util.Arrays.sort(charsB);
                String sortedB = new String(charsB);
                
                if(sortedA.equals(sortedB))
                {
                    count[i]=0;
                }
                else
                {
                    for(int j = 0; j < sortedA.length(); j++){
                        if(sortedB.contains(String.valueOf(sortedA.charAt(j))))
                        {
                            count[i]=count[i]+1;
                        }    
                    }
                }
            }
        }
       return count;
    }

    
     public static void main(String[] args){
         
        String[] a = new String[] {"tea","tea", "act"};         
        String[] b = new String[] {"ate","toe", "acts"};         
         
         int[] difence = getMinimumDifference(a,b);
         
         for(int cte : difence)
         {
             System.out.println(cte);
         }        
         
     }
}
