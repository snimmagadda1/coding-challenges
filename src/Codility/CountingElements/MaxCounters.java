package Codility.CountingElements;

public class MaxCounters {

    public int[] solution(int N, int[] A) {
        // write your code in Java SE 8
        int[] counters = new int[N];
        int maxCounter = 0;
        for(int i=0; i < A.length; i++){
            if(A[i] == N + 1){
                setSame(maxCounter, counters);
            } else { // Case we must increment counter
                counters[A[i]-1]++;
                if(counters[A[i]-1] > maxCounter){
                    maxCounter = counters[A[i]-1];
                }
            }
        }
        return counters;
    }

    public void setSame(int toSet, int[] toChange) {
        for(int i=0; i <toChange.length; i++){
            toChange[i] = toSet;
        }
    }

}
