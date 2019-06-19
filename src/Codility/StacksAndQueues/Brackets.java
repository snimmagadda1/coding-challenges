package Codility.StacksAndQueues;

import java.util.Stack;

/*
A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:

S is empty;
S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
S has the form "VW" where V and W are properly nested strings.
For example, the string "{[()()]}" is properly nested but "([)()]" is not.

Write a function:

class Solution { public int solution(String S); }

that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.

For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..200,000];
string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".
 */
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
