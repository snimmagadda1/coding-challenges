package Codility.Arrays;

public class CyclicRotation {

    public int[] solution(int[] A, int K) {
        int[] rotated = new int[A.length];

        for (int i = 0; i < A.length; i ++) {
            int newIndex = i + K%A.length - A.length;

            // Case less than 0 must add length
            if(newIndex < 0) {
                newIndex = newIndex + A.length;
            }
            rotated[newIndex] = A[i];
        }

        return rotated;
    }


}
