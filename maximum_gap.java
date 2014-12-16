public class Solution {
    class Bucket {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        boolean visited = false;
    }
    public int maximumGap(int[] num) {
        if (num.length < 2)
            return 0;
        /*
         * initialize min max & step
         */
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Bucket[] buckets = new Bucket[num.length];
        for (int i = 0; i < num.length; i++) {
            buckets[i] = new Bucket();
            if (num[i] > max)
                max = num[i];
            if (num[i] < min)
                min = num[i];
        }
        double step = 1.0 * (max - min) / (num.length - 1);

        /*
         * fill in buckets
         */
        for (int i : num) {
            int pos = (int)Math.floor((i - min) / step);
            if (pos == buckets.length)
                pos--;
            buckets[pos].visited = true;
            if (buckets[pos].min > i)
                buckets[pos].min = i;
            if (buckets[pos].max < i)
                buckets[pos].max = i;
        }

        int maxGap = -1;;
        for (int pre = 0, cur = 1; cur < buckets.length; cur++) {
            if (buckets[cur].visited) {
                if (buckets[cur].min - buckets[pre].max > maxGap)
                    maxGap = buckets[cur].min - buckets[pre].max;
                pre = cur;
            }
        }
        return maxGap;
    }
}
