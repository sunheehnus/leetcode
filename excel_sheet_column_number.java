public class Solution {
    public int titleToNumber(String s) {
        int cnt = 0;
        int level = 1;
        for (int i = 1; i < s.length(); i++) {
            level *= 26;
            cnt += level;
        }
        for (int i = 0; i < s.length(); i++) {
            cnt += (s.charAt(i) - 'A') * level;
            level /= 26;
        }
        return ++cnt;
    }
}
