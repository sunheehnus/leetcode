public class Solution {
    public int majorityElement(int[] num) {
        int protentialMajorityElement = 0;
        int cnt = 0;
        for (int i : num) {
            if (cnt == 0) {
                protentialMajorityElement = i;
                cnt = 1;
            }
            else if (protentialMajorityElement == i)
                cnt++;
            else
                cnt--;
        }
        return protentialMajorityElement;
    }
}
