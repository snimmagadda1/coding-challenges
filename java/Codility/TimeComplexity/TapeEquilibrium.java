package Codility.TimeComplexity;

public class TapeEquilibrium {

    public int solution( int[] A) {
        // longs b/c adding max 32 bit integers
        long sumLeft = 0;
        long sumRight = 0;
        long minDifference;

        for(int i =1 ; i < A.length; i++){
            sumRight += A[i];
        }

        sumLeft = A[0];
        minDifference  = Math.abs(sumLeft - sumRight);

        for(int P = 1; P < A.length; P++) {
            if(Math.abs(sumLeft - sumRight) < minDifference) {
                minDifference = Math.abs(sumLeft - sumRight);
            }
            sumLeft += A[P];
            sumRight -=A[P];
        }

        return (int) minDifference;
    }



}
