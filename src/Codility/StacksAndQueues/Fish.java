package Codility.StacksAndQueues;

import java.util.Stack;

public class Fish {


    public int solution(int[] A, int[] B){

        // Stack to store downstream fish
        // When we get to a fish moving upstream, check if eaten for each downstream fish in stack (will have stored sizes of fish moving downstream)
        // if it is, kill it and move on (break)
        // else it eats the current thing on the stack, pop the upstream moving fish and test it against the downstream moving one

        // edge case
        if(A.length == 0){
            return 0;
        }
        Stack<Integer> downStreamFish = new Stack<>();
        int numAlive = A.length;

        for(int i = 0 ; i < A.length; i++){
            if(B[i] == 1){
                downStreamFish.push(A[i]); // store size
            } else {
                while(!downStreamFish.isEmpty()){
                    if(A[i] < downStreamFish.peek()){ // case downstream fish moving up is smaller
                        numAlive--;
                        break; // we don't keep going b/c this fish is dead
                    } if(A[i] > downStreamFish.peek()){ // case downstream fish moving up is larger
                        numAlive--;
                        downStreamFish.pop();
                    }
                }
            }
        }

        return numAlive;

    }
}
