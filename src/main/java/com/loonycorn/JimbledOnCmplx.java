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
public class JimbledOnCmplx {
    
    public static void main(String args[]) {
		method(4, 0);
	}

	public static void method(int n, int counter) {
        if(counter<Math.pow(10, n-1))
            method(n,(int)Math.pow(10, n-1));
        else
            if (counter >= Math.pow(10, n)) {
			return;
		} else {
			boolean flag = true;
			for (int i = 1; i <= n; i++) {
				int current, before, after;
				current = getNumber(counter, i);
				before = i == n ? current : getNumber(counter, i + 1);
				after =  i == 1 ? current : getNumber(counter, i - 1);
				if (!(Math.abs(current - before) <= 1 && Math.abs(current - after) <= 1))
					flag = false;
			}
			if (flag == true)
				System.out.println(counter);
			method(n, ++counter);
		}
	}

	public static int getNumber(int number, int position) {
		int n = (int) (number % Math.pow(10, position));
		n = (int) (n / Math.pow(10, position - 1));
		return n;
        }
    
}
