public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0)
            return "0";
        boolean same = (numerator > 0) ? (denominator > 0) : (denominator < 0);
        long num = numerator;
        long den = denominator;
        num = Math.abs(num);
        den = Math.abs(den);
        String integer = (same ? "" : "-") + num / den;
        long left = num % den;
        if (left == 0)
            return integer;
        String decimal = "";
        Set<Long> set = new HashSet<Long>();
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        int pos = 0;
        while(true) {
            if (left == 0)
                return integer + "." + decimal;
            else if (set.contains(left))
                return integer + "." + decimal.substring(0, map.get(left)) + "(" + decimal.substring(map.get(left)) + ")";
            set.add(left);
            map.put(left, pos);
            pos ++;
            left *= 10;
            decimal += left / den;
            left %= den;
        }
    }
}
