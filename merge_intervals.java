/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
	class cmp implements Comparator {
		public final int compare(Object o1, Object o2) {
			if (((Interval)o1).start > ((Interval)o2).start)
				return 1;
			else if (((Interval)o1).start == ((Interval)o2).start)
				return 0;
			else
				return -1;
		}
	}
	int max(int a, int b) {
		return a > b ? a : b;
	}
	public List<Interval> merge(List<Interval> intervals) {
		Interval[] intervals_arr = new Interval[intervals.size()];
		int pos = 0;
		for (Interval interval : intervals)
			intervals_arr[pos++] = interval;

		Arrays.sort(intervals_arr, new cmp());
		List<Interval> result = new LinkedList<Interval>();
		for (int i = 0, j = 0; i < intervals_arr.length; i = j) {
			Interval interval = intervals_arr[i];
			for (j = i + 1; j < intervals_arr.length && intervals_arr[j].start <= interval.end; j++)
				interval.end = max(interval.end, intervals_arr[j].end);
			result.add(interval);
		}
		return result;
	}
}
