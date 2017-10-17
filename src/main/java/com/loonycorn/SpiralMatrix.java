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
public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] multi = new int[][]{
        { 1, 2, 3},
        { 8, 9, 4},
        { 7, 6, 5}
      };
        int[][] multi1 = spiralOrder(multi);
     }
    
        public static int[][] spiralOrder(final int[][] A) {
            
            int top=0;
            int botom=A[0].length;
            int left=0;
            int right=A.length;
            int i=0;
            int dir=0;
        
        while(left<=right && top<=botom)
        {
            if(dir==0)
            {
                for(i=0;i<right;i++)
                {
                    System.out.print(A[top][i]);                    
                }
                top++;
                    System.out.print("\n");                    
            }
            if(dir==1)
            {
            for(i=0;i<botom;i++)
                {
                    System.out.print(A[i][botom]);                    
                }
                botom++;
                    System.out.print("\n");                    
            }
            if(dir==3)
            {
            for(i=right;i>0;i--)
                {
                    System.out.print(A[right][i]);                    
                }
                right--;
                System.out.print("\n");                    
            }
            if(dir==4)
            {
            for(i=botom;i>0;i--)
                {
                    System.out.print(A[i][botom]);                    
                }
                botom--;
                System.out.print("\n");                    
            }
            dir=4%(dir+1);
        } 
            return null;
    }
    
}
