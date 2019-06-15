package LeetCode;

public class ReverseInteger {

    // Push Pop
    public int reverse(int x) {
        int reversed = 0;
        int remainder = 0;
        while (x != 0){
            remainder = x % 10;
            x /= 10;
            if (reversed < Integer.MIN_VALUE/10 || reversed > Integer.MAX_VALUE/10) {
                return 0;
            }
            reversed = 10* reversed + remainder;
        }
        return reversed;
    }
}
