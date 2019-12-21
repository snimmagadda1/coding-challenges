package Codility.StacksAndQueues;

import java.util.Stack;

public class StoneWall {

    public int solution(int[] H) {
        // write your code in Java SE 8
        Stack<Integer> stack = new Stack<>();
        int blockCount = 0;
        for (int i = 0; i < H.length; i++) {
            int height = H[i];
            while (!stack.isEmpty() && height < stack.peek()) {
                stack.pop();
                blockCount++;
            }
            if (stack.isEmpty() || height > stack.peek()) {
                stack.push(height);
            }

            // if equal size do nothing (same block will already be on the stack)
        }
        blockCount = blockCount + stack.size();
        return blockCount;
    }

}
