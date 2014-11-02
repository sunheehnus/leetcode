public class Solution {
    public int findMin(int[] num) {
        int min = Integer.MAX_VALUE;
        for (int i : num) {
            if (i < min)
                min = i;
        }
        return min;
    }
}
