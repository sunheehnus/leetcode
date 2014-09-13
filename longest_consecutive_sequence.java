public class Solution {
	public int longestConsecutive(int[] num) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < num.length; i++) {
			if (!set.contains(num[i]))
				set.add(num[i]);
		}
		int maxlength = 0;
		for (int i = 0; i < num.length; i++)
		{
			if (set.contains(num[i]))
			{
				int floor = num[i];
				int ceil = num[i];
				set.remove(num[i]);
				while(set.contains(--floor))
					set.remove(floor);
				while(set.contains(++ceil))
					set.remove(ceil);
				if (ceil - floor - 1 > maxlength)
					maxlength = ceil - floor - 1;
			}
		}
		return maxlength;
	}
}
