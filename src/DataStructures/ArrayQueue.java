package DataStructures;

public class ArrayQueue {

    private int queueSize; // total size

    private int front, rear, numItems = 0;


    private String[] theQueue;

    public ArrayQueue(int queueSize) {
        this.queueSize = queueSize;
        theQueue = new String[queueSize];
    }

    public void insert(String toAdd){
        if(numItems + 1 < queueSize){
            theQueue[rear] = toAdd;
            rear++;
            numItems++;
        } else {
            System.out.println("Error queue is full");
        }
    }

    public String remove(){
        if(numItems > 0){
            String toReturn = theQueue[front];
            theQueue[front] = null; // Simulate deletion
            front++;
            numItems--;
            return toReturn;
        } else {
            return "-1"; // Error case
        }
    }

    public String peek(){
        return theQueue[front];
    }


    public static void main(String[] args){
        ArrayQueue queue = new ArrayQueue(10);
        queue.insert("H");
        queue.insert("E");
        queue.insert("L");
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());

    }


}
