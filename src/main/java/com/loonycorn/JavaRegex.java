package com.loonycorn;

import java.util.regex.Pattern;

public class JavaRegex {

    public static void main(String[] args) {


        String input = "hindu. chicha-morada-peruana";
        StringBuffer result = new StringBuffer();


        String[] initialSplit = input.split(" ");
        Pattern pattern = Pattern.compile("[^a-z0-9]");

        String[] subSplit;
        String substring =  "";
        int offset = 0;
        for(int i = 0; i < initialSplit.length; i++) {

            if(initialSplit[i].length() > 2) {

                if(pattern.matcher(initialSplit[i]).find()) {
                    offset = 0;

                    subSplit = initialSplit[i].split("[^a-z0-9]");

                    for(int y = 0; y < subSplit.length; y ++) {
                        offset += subSplit[y].length();

                        substring = subSplit[y].substring(1, subSplit[y].length() - 1);

                        result.append("" + subSplit[y].charAt(0) + substring.chars().distinct().count() +
                                subSplit[y].charAt(subSplit[y].length() - 1)); // java 8

                        if (y != subSplit.length-1) {
                            result.append(initialSplit[i].charAt(offset));
                            offset++; // adding the special character space for next iteration

                        }

                    }

                } else {

                    substring = initialSplit[i].substring(1, initialSplit[i].length() - 1);
                    result.append("" + initialSplit[i].charAt(0) + substring.chars().distinct().count() +
                            initialSplit[i].charAt(initialSplit[i].length() - 1) + " "); // java 8
                }

            } else {
                result.append(initialSplit[i] + " ");
            }

        }

        System.out.println(result.toString());

    }
}
