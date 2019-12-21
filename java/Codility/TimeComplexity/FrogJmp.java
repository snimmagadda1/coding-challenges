package Codility.TimeComplexity;

public class FrogJmp {

    public int solution(int X, int Y, int D) {
        int remaingDistance = Y - X;
        double d = (double) D;
        double remDist = (double) remaingDistance;
        return (int) Math.ceil(remDist / d);
    }
}
