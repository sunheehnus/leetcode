public class Solution {
    public int findPeakElement(int[] num) {
        int start = 0;
        int end = num.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if ((mid == 0 || num[mid] > num[mid - 1]) && (mid == num.length - 1 || num[mid] > num[mid + 1]))
                return mid;
            else if ((mid == 0 || num[mid] > num[mid - 1]) && (num[mid] < num[mid + 1]))
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }
}
