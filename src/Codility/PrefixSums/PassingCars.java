package Codility.PrefixSums;

public class PassingCars {

    // Instead we only increment when we see a car going west
    // We increment by the number of cars we've seen going east
    public int solution(int[] A){
        int eastBoundCars = 0; // keep track of east cars
        int totalPasses = 0; // keep track of total passes;

        if(A.length == 1) {
            return 0;
        }
        for(int i =0; i < A.length; i ++){
            if(totalPasses >= 1000000000) {
                return -1;
            }
            if(A[i] == 0) { // If current car is going west
                eastBoundCars++;
            } else {
                totalPasses+= eastBoundCars;
            }
        }

        return totalPasses;
    }


    public int poorSolution(int[] A) {

        if(A.length == 1) {
            return 0;
        }
        int totalPasses = 0;
        for(int i =0; i< A.length; i++){
            if(totalPasses >= 1000000000) {
                return -1;
            }
            if(A[i] == 1) {
                totalPasses = totalPasses + countZeros(i, A);
            } else {
                totalPasses = totalPasses + countOnes(i, A);
            }
        }
        return totalPasses / 2;
    }

    public int countOnes(int startIndex, int[] A){
        int count = 0;
        for(int i = startIndex; i < A.length; i++){
            if(A[i] == 1){
                count++;
            }
        }
        return count;
    }

    public int countZeros(int startIndex, int[] A){
        int count = 0;
        for(int i = startIndex; i >=0; i--){
            if(A[i] == 0){
                count++;
            }
        }
        return count;
    }


}
