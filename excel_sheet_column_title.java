public class Solution {
    public String convertToTitle(int n) {
        String res = "";
        while (n > 0) {
            res = (char)('A' + (--n) % 26) + res;
            n /= 26;
        }
        return res;
    }
}
