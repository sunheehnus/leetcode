public class Solution {
    public int findMin(int[] num) {
        int start = 0;
        int end = num.length - 1;
        if (num[end] >= num[start])
            return num[start];
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (num[mid] >= num[0])
                start = mid + 1;
            else
                end = mid - 1;
        }
        return num[start];
    }
}
