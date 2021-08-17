package com.loonycorn;
// package whatever; // don't place package name!

import java.io.*;

/*
Write a program that parses a sentence and replaces each word with the following:
1) The first letter of the word
2) The number of distinct characters between first and last character
3) The last letter of the word.
For example, Smooth would become S3h.
Words are separated by spaces or non-alphabetic characters and these separators should be maintained in their original form and location in the answer.
A few of the things we will be looking at is accuracy, efficiency, solution completeness.
*/
class MyCodeCopy {
    public static String wordParser(String input) {
        // IMPLEMENT YOUR SOLUTION HERE
        String result="";
        String[] splited= input.split("[\\s!@&.?$+-]+");
        String[] splitedSeparator= input.split("[^a-zA-Z0-9]");

        //String[] splited= input.split("(?=[\\!s@&.?$+-]+)|(?<=[\\!s@&.?$+-]+)");

        for(int j=0;j<splited.length;j++)
        {
            char[] ch = splited[j].toCharArray();
            char first=' ';

            if(splited[j].length()>0)
            {

                //char first=splited[j].charAt(0);
                first=splited[j].charAt(0);
                char last=' ';
                int counter =0;

                if (ch.length>1)
                {
                    last=splited[j].charAt(splited[j].length()-1);

                    String tmp=splited[j].substring(1, splited[j].length() - 1);
                    counter= (int) tmp.chars().distinct().count();

                }
                String strCount="";
                if(counter>0)
                    strCount=counter+"";

                String separator="";

                //if(j<splited.length)
                //separator=(input.split("^([\\s!@&.?$+-]+)"))[j];
                //result=result+first+""+strCount+""+last+separator;
                result=result+first+""+strCount+""+last+input.charAt(input.indexOf(splited[j])+splited[j].length())+"";
                //result=result+first+""+strCount+""+last+" ";
            }

        }

        return result;
    }

    public static void main (String[] args) {
        String output = wordParser("Creativity is thinking-up new things. Innovation is doing new things!");
        System.out.println(output);
        // expected: C6y is t4g-up n1w t4s. I6n is d3g n1w t4s!
    }
}