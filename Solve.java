import java.util.Arrays;

public class Solve {

    static int goalTest(State current) {
        int[][] currMat;
        currMat = current.a;
        int goal[][] = new int[][]{{0, 0, 0, 0}, {1, 1, 1, 1}, {2, 2, 2, 2}, {3, 3, 3, 3}, {4, 4, 4, 4}, {5, 5, 5, 5},};
        int ok = 0;

        for (int i = 0; i < 6; i++) {
            if (Arrays.equals(goal[i], currMat[i]))
                ok++;
        }
        if (ok == 6)
            return 1;
        else
            return 0;
    }


    public static State applyAction(State current, int i, int j) {

        State result = new State();
        int[] action ;


        if (j == 0) //0 is positive direction
        {
            if (i == 0) { //F1

                action = new int[]{2, 0, 3, 1, 8, 9, 6, 7, 12, 13, 10, 11, 23, 22, 14, 15, 16, 17, 18, 19, 20, 21, 5, 4};
                for (int n = 0 ; n < 24 ; n++){
                    result.a[n/4][n%4] = current.a[action[n]/4][action[n]%4];
                }
               return result;
            }
            if (i == 1) { //F2
                action = new int[]{20, 1, 22, 3, 6, 4, 7, 5, 0, 9, 2, 11, 12, 13, 14, 15, 8, 17, 10, 19, 16, 21, 18, 23};
                for (int n = 0 ; n < 24 ; n++){
                    result.a[n/4][n%4] = current.a[action[n]/4][action[n]%4];
                }
                return result;
            }
            if (i == 2) { //F3
                action = new int[]{0, 1, 7, 5, 4, 16, 6, 17, 10, 8, 11, 9, 2, 13, 3, 15, 14, 12, 18, 19, 20, 21, 22, 23};
                for (int n = 0 ; n < 24 ; n++){
                    result.a[n/4][n%4] = current.a[action[n]/4][action[n]%4];
                }
                return result;
            }
            if (i == 3) { //F4
                action = new int[]{0, 9, 2, 11, 4, 5, 6, 7, 8, 17, 10, 19, 14, 12, 15, 13, 16, 21, 18, 23, 20, 1, 22, 3};
                for (int n = 0 ; n < 24 ; n++){
                    result.a[n/4][n%4] = current.a[action[n]/4][action[n]%4];
                }
                return result;
            }
            if (i == 4) { //F5
                action = new int[]{0, 1, 2, 3, 4, 5, 21, 20, 8, 9, 6, 7, 12, 13, 10, 11, 18, 16, 19, 17, 15, 14, 22, 23};
                for (int n = 0 ; n < 24 ; n++){
                    result.a[n/4][n%4] = current.a[action[n]/4][action[n]%4];
                }
                return result;
            }
            if (i == 5) { //F6
                action = new int[]{13, 15, 2, 3, 1, 5, 0, 7, 8, 9, 10, 11, 12, 19, 14, 18, 16, 17, 4, 6, 22, 20, 23, 21};
                for (int n = 0 ; n < 24 ; n++){
                    result.a[n/4][n%4] = current.a[action[n]/4][action[n]%4];
                }
                return result;
            }
        } else //1 is negative direction
        {
            if (i == 0) { //F1
                action = new int[]{0, 1, 2, 3, 4, 5, 21, 20, 8, 9, 6, 7, 12, 13, 10, 11, 18, 16, 19, 17, 15, 14, 22, 23};
                for (int n = 0 ; n < 24 ; n++){
                    result.a[n/4][n%4] = current.a[action[n]/4][action[n]%4];
                }
                return result;

            }
            if (i == 1) { //F2
                action = new int[]{0, 9, 2, 11, 4, 5, 6, 7, 8, 17, 10, 19, 14, 12, 15, 13, 16, 21, 18, 23, 20, 1, 22, 3};
                for (int n = 0 ; n < 24 ; n++){
                    result.a[n/4][n%4] = current.a[action[n]/4][action[n]%4];
                }
                return result;
            }
            if (i == 2) { //F3
                action = new int[]{13, 15, 2, 3, 1, 5, 0, 7, 8, 9, 10, 11, 12, 19, 14, 18, 16, 17, 4, 6, 22, 20, 23, 21};
                for (int n = 0 ; n < 24 ; n++){
                    result.a[n/4][n%4] = current.a[action[n]/4][action[n]%4];
                }
                return result;
            }
            if (i == 3) { //F4
                action = new int[]{20, 1, 22, 3, 6, 4, 7, 5, 0, 9, 2, 11, 12, 13, 14, 15, 8, 17, 10, 19, 16, 21, 18, 23};
                for (int n = 0 ; n < 24 ; n++){
                    result.a[n/4][n%4] = current.a[action[n]/4][action[n]%4];
                }
                return result;
            }
            if (i == 4) { //F5
                action = new int[]{2, 0, 3, 1, 8, 9, 6, 7, 12, 13, 10, 11, 23, 22, 14, 15, 16, 17, 18, 19, 20, 21, 5, 4};
                for (int n = 0 ; n < 24 ; n++){
                    result.a[n/4][n%4] = current.a[action[n]/4][action[n]%4];
                }
                return result;
            }
            if (i == 5) { //F5
                action = new int[]{0, 1, 7, 5, 4, 16, 6, 17, 10, 8, 11, 9, 2, 13, 3, 15, 14, 12, 18, 19, 20, 21, 22, 23};
                for (int n = 0 ; n < 24 ; n++){
                    result.a[n/4][n%4] = current.a[action[n]/4][action[n]%4];
                }
                return result;
            }
        }
        return null;

    }

}
