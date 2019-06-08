package Codility.TimeComplexity;

import java.util.Arrays;

public class PermMissingElem {

    public int solution(int[] A) {

        if(A.length == 1){
            if(A[0] == 1) {
                return 2;
            } else {
                return 1;
            }
        }
        Arrays.sort(A);

        int i;
        for(i = 0 ; i < A.length; i++){
            if(A[i] != i+1){
                return i+1;
            }
        }

        return i + 1;
    }
}
