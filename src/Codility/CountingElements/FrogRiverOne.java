package Codility.CountingElements;

import java.util.HashMap;

public class FrogRiverOne {

    public int solution(int X, int[] A) {
        // (Location, time)
        HashMap<Integer, Integer> leafLocations= new HashMap<>();
        int maxTime = 0;
        for(int i =0; i <A.length; i++) {
            if(!leafLocations.containsKey(A[i])){
                leafLocations.put(A[i], i);
            }
        }

        for(int j = 1; j <=X; j++){
            // Mot a leaf at any step <= X
            if(leafLocations.get(j) == null){
                return -1;
            }

            if(leafLocations.get(j) > maxTime){
                maxTime = leafLocations.get(j);
            }
        }
        return maxTime;
    }
}
