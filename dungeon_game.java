public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int M = dungeon.length;
        int N = dungeon[0].length;
        int[][] map = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++)
                map[i][j] = dungeon[i][j];
        }
        for (int i = M - 1; i >= 0; i--) {
            for (int j = N - 1; j >= 0; j--) {
                if (i < M - 1 && map[i + 1][j] >= 0)
                    continue;
                if (j < N - 1 && map[i][j + 1] >= 0)
                    continue;
                if (i < M - 1 && j < N - 1) {
                    int min1 = map[i][j] + map[i + 1][j];
                    int min2 = map[i][j] + map[i][j + 1];
                    map[i][j] = min1 > min2 ? min1 : min2;
                }
                else if (i < M - 1)
                    map[i][j] = map[i][j] + map[i + 1][j];
                else if (j < N - 1)
                    map[i][j] = map[i][j] + map[i][j + 1];
            }
        }
        return map[0][0] < 0 ? (1 - map[0][0]) : 1;
    }
}
