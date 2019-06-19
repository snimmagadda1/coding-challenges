package Codility.StacksAndQueues;

import java.util.Stack;

public class Brackets {

        public int solution(String S) {

            if(S.length() == 0){
                return 1;
            }

            Stack<Character> stack = new Stack<>();
            for(int i=0; i< S.length(); i++){
                // note: push "its pair"
                if( S.charAt(i) == '(' ){
                    stack.push(')');
                }
                else if( S.charAt(i) == '[' ){
                    stack.push(']');
                }
                else if( S.charAt(i) == '{' ){
                    stack.push('}');
                }
                // pop and check
                else if( S.charAt(i) == ')' || S.charAt(i) == ']' || S.charAt(i) == '}'){
                    // important: check if the stack is empty or not (be careful)
                    if(stack.isEmpty() == true){
                        return 0;
                    }
                    else{
                        char temp = stack.pop(); // check if the stack is empty before pop!!!
                        if(temp != S.charAt(i)){ // not a pair
                            return 0;
                        }
                    }
                }
            }
            // note: check if the stack is empty or not (be careful)
            if( !stack.isEmpty() ){
                return 0;
            }
            else{
                return 1;
            }
        }
}
