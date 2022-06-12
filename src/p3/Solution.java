package p3;

public class Solution {
    public static int solution(int delay, int N) {
        if (N == 1) {
            return 3;
        }

        if (N == 2) {
            return 5;
        }

        if (N > 2 && N <= delay) {
            return 2*(delay+1) + 1;
        }

        int middle = 2*(delay+1) + 1;

        for (int i = 1; i < N - delay; i++) {
            middle += 2 * i + 2;
        }

        return middle;
    }
}
