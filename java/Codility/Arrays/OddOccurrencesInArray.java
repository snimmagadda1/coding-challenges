package Codility.Arrays;

import java.util.Arrays;
import java.util.HashMap;

public class OddOccurrencesInArray {

    public int solution(int[] A) {
        HashMap<Integer,Integer> occurs = new HashMap<>();
        for(int i=0;i<A.length;i++){
            if(occurs.containsKey(A[i])){
                occurs.remove(A[i]);
            }else{
                occurs.put(A[i],1);
            }
        }
        for(int key : occurs.keySet()){
            return key;
        }


        return 0;
    }


    public static int binarySearch(int[] a, int lower, int upper, int toFind) {
        int guess = (lower + upper) /2;

        if(lower > upper ) {
            return -1;
        }

        if(a[guess] == toFind){
            return guess;
        } else if (a[guess] < toFind) {
            lower = guess + 1;
            return binarySearch(a, lower, upper, toFind);
        } else {
            upper = upper - 1;
            return binarySearch(a, lower, upper, toFind);
        }
    }

}
