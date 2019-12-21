package Codility.Leader;
import java.util.*;
public class EquiLeader {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int equiLeaderCount = 0;

        if(A.length == 0 ){ // edge case
            return equiLeaderCount;
        }
        for(int i =1; i <A.length; i++){
            int[] part1 = Arrays.copyOfRange(A, 0, i);
            int[] part2 = Arrays.copyOfRange(A, i, A.length);
            int dom1 = getLeader(part1);
            int dom2 = getLeader(part2);
            if(dom1 <1000000001 && dom2 <1000000001){
                if(dom1 == dom2){
                    equiLeaderCount++;
                }
            }
        }


        return equiLeaderCount;
    }


    // get the dominator value in an array
    public int getLeader(int[] A){
        int length = A.length;
        int[] sorted = Arrays.copyOf(A, A.length);
        Arrays.sort(sorted);
        int candidate = sorted[length/2];
        int count = 0;
        for(int i =0; i <sorted.length; i++){
            if(sorted[i] == candidate){
                count ++;
            }
        }

        if(count > length/2){
            return candidate;
        } else {
            return 1000000001; // 1 greater than the max element ( used to check if a leader exists)
        }
    }

}
