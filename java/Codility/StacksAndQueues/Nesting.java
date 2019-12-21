package Codility.StacksAndQueues;

import java.util.Stack;

public class Nesting {

    public int solution(String S) {
        // write your code in Java SE 8
        if(S.length() == 0) {
            return 1;
        }

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i <S.length(); i ++){
            if(S.charAt(i) == '('){
                stack.push(')'); // push the needed parenthesis for later comparison
            } else { // case we reach a right facing parenthesis
                if(stack.isEmpty()){
                    return 0;
                }
                Character last = stack.pop();
                if(last != S.charAt(i)){
                    return 0;
                }
            }
        }

        if(!stack.isEmpty()){ // Case they are all left facing upon input
            return 0;
        }
        return 1;
    }
}
