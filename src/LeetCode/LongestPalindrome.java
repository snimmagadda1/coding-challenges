package LeetCode;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class LongestPalindrome {

    // Modify longest substring code to find all substrings of s1
    public static String longestPalindrome(String s) {
        String s1 = s;
        String s2 = new StringBuilder(s).reverse().toString();
        int[][] matches = new int[s1.length()][s2.length()];
        ArrayList<String> matchingSubstrings = new ArrayList<>();
        int maxPalindrome = Integer.MIN_VALUE;
        String ans = "";
        for(int i=0; i <s1.length(); i++){
            for(int j=0; j<s2.length(); j++){
                if(s1.charAt(i) == s2.charAt(j)){
                    if(i==0 || j==0){
                        matches[i][j] = 1;
                    } else {
                        matches[i][j] = matches[i-1][j-1] + 1; // add diagonals
                    }
                    matchingSubstrings.add(s1.substring(i - matches[i][j] +1, i+1));

                } else {
                    matches[i][j] = 0;
                }
            }
        }
        for(String common : matchingSubstrings){
            String commonPrime = new StringBuilder(common).reverse().toString();
            int i =0;
            for(i = 0; i<common.length(); i++){
                if(!(common.charAt(i) == commonPrime.charAt(i))){
                    break;
                }
            }
            if(i == common.length() && common.length() > maxPalindrome){
                maxPalindrome = common.length();
                ans = common;
            }
        }
        return ans;
    }

    // Will find all longest substrings
    public static ArrayList<String> longestCommonSubstring(String s1, String s2){
        int[][] matches = new int[s1.length()][s2.length()];
        ArrayList<String> ans = new ArrayList<>();
        int maxLength = Integer.MIN_VALUE;
        for(int i=0; i <s1.length(); i++){
            for(int j=0; j<s2.length(); j++){
                if(s1.charAt(i) == s2.charAt(j)){
                    if(i==0 || j==0){
                        matches[i][j] = 1;
                    } else {
                        matches[i][j] = matches[i-1][j-1] + 1; // add diagonals
                    }
                    if(matches[i][j] > maxLength){
                        ans = new ArrayList<>(); // throw out old list of max length common strings
                        maxLength = matches[i][j];
                        ans.add(s1.substring(i-maxLength + 1, i +1)); // maxLength is length of substring, we go back that much and then start from the next letter (inclusive)
                    } else if (matches[i][j] == maxLength){
                        ans.add(s1.substring(i-maxLength + 1, i +1));
                    }
                } else {
                    matches[i][j] = 0;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // The below causes a "MemoryLimit Exceeded"... I think that's dumb... Should work ;)
        String test = "abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa";
        System.out.println(longestPalindrome(test));
    }

}
