package com.loonycorn;
// package whatever; // don't place package name!

import java.io.*;

//Imports required for the second approach
import java.util.regex.Pattern;
import java.util.regex.Matcher;


/*
Write a program that parses a sentence and replaces each word with the following:
1) The first letter of the word
2) The number of distinct characters between first and last character
3) The last letter of the word.
For example, Smooth would become S3h.
Words are separated by spaces or non-alphabetic characters and these separators should be maintained in their original form and location in the answer.
A few of the things we will be looking at is accuracy, efficiency, solution completeness.
*/
class MyCode {

    //Second approach: using patternMatcher groups and StringBuilder instead String
    public static String wordParser(String input) {
        // IMPLEMENT YOUR SOLUTION HERE
        StringBuilder sb = new StringBuilder();
        String patternString ="([a-zA-Z]+)([\\s!@&.?$+-]*)";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(input);
        while(matcher.find())
        {
            //sb.append(matcher.group(1));
            sb.append(replaceWordsAndCount(matcher.group(1)));
            sb.append(matcher.group(2));
        }
        return sb.toString();
    }

    public static String replaceWordsAndCount(String input)
    {
        int length = input.length();
        int number=0;

        if(length<3)
            return input;

        int counter=0;

        counter= (int) input.substring(1,length-1).chars().distinct().count();

        return input.charAt(0) + "" + counter + "" + input.charAt(length-1);

    }

    //First approach
    //Output  C6y is t4g-up n1w t4s!I6n is d3g n1w t4s!
    //Output  C6y is t4g-up n1w t4s.  .I6n is d3g n1w t4s!
    public static String wordParser1(String input) {
        // IMPLEMENT YOUR SOLUTION HERE
        String inputTmp=input;
        String result="";
        //String[] splited= input.split("[\\s!@&.?$+-]+");
        String[] splited= input.split("[\\s!@&.?$+-]");
        //String[] splited= input.split("(?=[\\!s@&.?$+-]+)|(?<=[\\!s@&.?$+-]+)");
        for(int j=0;j<splited.length;j++)
        {
            char[] ch = splited[j].toCharArray();
            char first=' ';
            String strCount="";
            char last=' ';

            if(splited[j].length()>0)
            {

                first=splited[j].charAt(0);
                //char last=' ';
                int counter =0;

                if (ch.length>1)
                {
                    last=splited[j].charAt(splited[j].length()-1);

                    String tmp=splited[j].substring(1, splited[j].length() - 1);
                    counter= (int) tmp.chars().distinct().count();

                }

                if(counter>0)
                    strCount=counter+"";

                String separator="";

            }
            result=result+first+""+strCount+""+last+inputTmp.charAt(inputTmp.indexOf(splited[j])+splited[j].length())+"";
            inputTmp=inputTmp.substring(inputTmp.indexOf(splited[j])+splited[j].length());
        }
        return result;
    }

    public static void main (String[] args) {
        //String output = wordParser("Creativity is thinking-up new things. Innovation is doing new things!");
        //String output = wordParser("this is the fuckin-up test. the only failing one is the dot with the space!");
        String output = wordParser("el veloz murcielago hindu tomaba chicha-morada. creo que esto falla si hay dos caracteres especiales seguidos!!");
        System.out.println(output);
        // expected: C6y is t4g-up n1w t4s. I6n is d3g n1w t4s!
    }
}