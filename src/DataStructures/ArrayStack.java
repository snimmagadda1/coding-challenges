package DataStructures;

public class ArrayStack {

    private int topOfStack = 0; // default to first element

    private String[] theStack;

    private int stackSize;

    public ArrayStack(int stackSize) {
        this.stackSize = stackSize;
        this.theStack = new String[stackSize];
    }

    public void push(String toAdd){
        if(topOfStack + 1 < stackSize){
            topOfStack++;
            theStack[topOfStack] = toAdd;
        } else {
            System.out.println("Error stack full");
        }
    }

    public String pop(){
        if(topOfStack >= 0){
            String toReturn = theStack[topOfStack];
            theStack[topOfStack] = null;
            topOfStack--;
            return toReturn;
        } else {
            return "-1"; // Signifies full
        }
    }

    public String peek(){
        return theStack[topOfStack];
    }


    public static void main(String[] args){
        ArrayStack stack1 = new ArrayStack(4);
        stack1.push("h");
        stack1.push("e");
        stack1.push("l");
        System.out.println(stack1.peek()); // Should print l
        System.out.println(stack1.pop()); // Should print l
        System.out.println(stack1.pop()); // Should print e
        stack1.push("Y");
        System.out.println(stack1.pop()); // Should print Y
    }
}
