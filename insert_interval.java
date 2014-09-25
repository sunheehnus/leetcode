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
	int max(int a, int b) {
		return a > b ? a : b;
	}
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		int pos;
		for (pos = 0; pos < intervals.size() && intervals.get(pos).start <= newInterval.start; pos++);
		intervals.add(pos, newInterval);

		Interval[] intervals_arr = new Interval[intervals.size()];
		pos = 0;
		for (Interval interval : intervals)
			intervals_arr[pos++] = interval;

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
