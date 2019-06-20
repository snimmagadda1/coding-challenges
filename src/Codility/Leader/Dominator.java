package Codility.Leader;

import java.util.Arrays;

public class Dominator {

    public static int solution(int[] A){
        int[] sorted = Arrays.copyOf(A, A.length); // dont set equal b/c arrays.sort will also sort
        Arrays.sort(sorted); // sort (Nlogn) (if a leader exists it will be at the middle element)
        if(A.length ==0){
            return -1;
        }
        int numElements = A.length;
        int candidate = sorted[numElements / 2];
        int count = 0;
        for(int i =0; i<sorted.length; i++){
            if(sorted[i]==candidate){
                count++;
            }
        }

        if(count > numElements /2){
            for(int i =0; i <A.length; i ++){
                if(A[i] == candidate){ // get first index of dominator
                    return i;
                }
            }
        }

        return -1;

    }

}
