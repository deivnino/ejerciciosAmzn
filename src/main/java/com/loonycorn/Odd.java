/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.loonycorn;


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

    
/**
 *
 * @author dnino
 */
public class Odd {

    
    /*
 * Complete the function below.
 */

    static int[] oddNumbers(int l, int r) {
        int i=0;
        int cont=0;
        List list = new  ArrayList<>();
        int[] arr=new int[];

        
        for (i=l;i<=r;i++)
        {
            if ( i % 2 != 0 )
            {
                list.add(i);
                 cont++;
            }
        }
        //arr=list.toArray();
        return arr;
    }


  public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        int[] res;
        int _l;
        
        //_l = Integer.parseInt(in.nextLine().trim());
        _l = 2;
        
        int _r;
        //_r = Integer.parseInt(in.nextLine().trim());
        _r = 5;
        
        res = oddNumbers(_l, _r);
        for(int res_i=0; res_i < res.length; res_i++) {
            bw.write(String.valueOf(res[res_i]));
            bw.newLine();
        }
        
        bw.close();
    }
}

