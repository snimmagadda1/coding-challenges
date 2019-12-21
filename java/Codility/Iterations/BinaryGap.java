package Codility.Iterations;

public class BinaryGap {

    public static int solution(int N) {
        // write your code in Java SE 8
        String binaryRep = Integer.toBinaryString(N);
        if(N <= 4) {
            return 0;
        }
        if(!binaryRep.contains("0")){
            return 0;
        }
        int maxGap = 0;
        int currGap = 0;
        boolean startedCount = false;
        for(int i = 0; i <binaryRep.length(); i++){
            if(binaryRep.charAt(i) == '1' && startedCount == false) {
                startedCount = true;
                currGap = 0;
            }

            if(startedCount && binaryRep.charAt(i) == '0') {
                currGap +=1;
            }
            else if(startedCount && binaryRep.charAt(i) == '1' && currGap > 0){
                if(currGap > maxGap) {
                    maxGap = currGap;
                }
                currGap = 0;
                startedCount = false;
                if(i > 0) {
                    i = i-1;
                }
            }

        }
        return maxGap;
    }

    private static int getNthBit( int theNumber, int bitPosition){
        int mask = 1;
        final int theNumberShifted = theNumber >> bitPosition;
        String test = Integer.toBinaryString(theNumberShifted);
        return theNumberShifted & mask;
    }


    public static void main(String[] args){
        System.out.println(Integer.toBinaryString(108));
        System.out.println(getNthBit(108, 2));
    }
}
