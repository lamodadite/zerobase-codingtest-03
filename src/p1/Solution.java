package p1;

public class Solution {
    public static int solution(int N, int[][] trust) {
        int answer = 0;

        int[][] arr = new int[N][N];

        for (int[] item : trust) {
            arr[item[0]-1][item[1]-1] = 1;
        }

        int possible = -1;

        for (int i = 0; i < N; i++) {
            boolean flag = false;
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 0) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                possible = i;
            }
        }

        if (possible == -1) {
            return -1;
        }

        boolean flag = false;

        for (int i = 0; i < N; i++) {
            if (i == possible && arr[i][possible] == 0) {
                flag = true;
                continue;
            }
            if (arr[i][possible] == 1) {
                flag = true;
            } else {
                flag = false;
                break;
            }
        }

        return flag ? possible+1 : -1;
    }
}
