package com.loonycorn;

public class Complexity {

    		    public static void main(String[] args) {
		    	
		     //System.out.print(gcd( 5, 4));	
		     /*
		     System.out.println(Math.log(5));
		     System.out.println(5);
		     System.out.println(Math.log(Math.log(5)));
		     System.out.println(Math.sqrt(5));
		     */
                     /*
		     System.out.println(Math.pow(2,5));
		     System.out.println(Math.pow(5,3/2));
		     System.out.println(5*(Math.log(5)));
		     System.out.println(Math.pow(5,(Math.log(5))));
		     */
                     int[] arr = new int[] {10,1,8,3,5};
                     int n=2;  
                     int j = 0;
                       for(int i = 0; i < n; ++i) {
                           System.out.println("paso for");
                           while(j < n && arr[i] < arr[j]) {
                               j++;
                               System.out.println("paso while");
                           }
                       }
		    }
    /*
        static int gcd(int n, int m) {
        	int number=0;
            if (n%m ==0) return m;
            if (n < m) swap(n, m);
            while (m > 0) {
                n = n%m;
                swap(n, m);
                number++;
            }
            System.out.println("Paso "+number+" veces ");
            return n;
    }
    */

    private static void swap(int n, int m) {
        int AuxM=m;
        m=n;
        n=AuxM;
    }
            
    
}
