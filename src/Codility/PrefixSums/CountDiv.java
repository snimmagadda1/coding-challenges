package Codility.PrefixSums;

public class CountDiv {

    // This is pure math again... codility sucks as a coding platform
    int solution(int A, int B, int K) {
        int b = B/K;
        int a = (A > 0 ? (A - 1)/K: 0);
        if(A == 0){
            b++;
        }
        return b - a;
    }
}
