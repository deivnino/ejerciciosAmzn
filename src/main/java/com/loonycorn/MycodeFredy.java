package com.loonycorn;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class MyCodeFredy {

    public static int countUniqueCharacters(String input) {
        boolean[] presentChars = new boolean[Character.MAX_VALUE];
        for (int i = 0; i < input.length(); i++) {
            presentChars[input.charAt(i)] = true;
        }
        int count = 0;
        for (int i = 0; i < presentChars.length; i++) {
            if (presentChars[i] == true) {
                count++;
            }
        }
        return count;
    }

    private static String wordReplacer(String input) {
        if (input == null) {
            return "";
        }
        int length = input.length();
        if (input.length() < 3) {
            return input;
        }
        return input.charAt(0) + "" + countUniqueCharacters(input.substring(1, length - 1)) + "" + input.charAt(length - 1);
    }

    private static String wordParser(String input) {
        // IMPLEMENT YOUR SOLUTION HERE
        StringBuilder sb = new StringBuilder();
        String patternString = "([a-zA-Z]+)([\\s!@&.?$+-]*)";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(input);
        int count = 0;
        while (matcher.find()) {
            count++;
            sb.append(wordReplacer(matcher.group(1)));
            sb.append(wordReplacer(matcher.group(2)));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String output = wordParser("Creativity is thinking-up new things. Innovation is doing new things!");
        System.out.println(output);
        // expected: C6y is t4g-up n1w t4s. I6n is d3g n1w t4s!
        //Sorry gotta move a couple of minutes}
    }
}