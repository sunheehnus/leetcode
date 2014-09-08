/**
 * Definition for a point.
 * class Point {
 *	int x;
 *	int y;
 *	Point() { x = 0; y = 0; }
 *	Point(int a, int b) { x = a; y = b; }
 * }
 */
class Solution {
	public int gcd(int a, int b) {
		a = a < 0 ? -a : a;
		b = b < 0 ? -b : b;
		return b == 0 ? a : gcd(b, a%b);
	}
	public int cmp(Point x, Point y) {
		if (x.x > y.x || (x.x == y.x)&&(x.y > y.y))
			return 1;
		if (x.x < y.x || (x.x == y.x)&&(x.y < y.y))
			return -1;
		return 0;
	}
	public void quicksort(Point [] points, int start, int end) {
		int i, j, mid;
		Point tmp;
		if (start >= end)
			return;
		i = start;
		j = end;
		mid = i + (j - i) / 2;
		tmp = points[mid];
		points[mid] = points[i];
		while (i < j) {
			while (i < j && cmp(points[j], tmp) >= 0)
				j--;
			points[i] = points[j];
			while (i < j && cmp(points[i], tmp) <= 0)
				i++;
			points[j] = points[i];
		}
		points[i] = tmp;
		quicksort(points, start, i - 1);
		quicksort(points, i + 1, end);
	}
	public int maxPoints(Point[] points) {
		Point [] array = new Point[points.length];
		for (int i = 0; i < points.length; i++) {
			array[i] = new Point();
		}
		int max = 0;
		for (int i = 0; i < points.length; i++) {
			int k = 0, hor = 0, ver = 0, same = 0;
			for (int j = 0; j < points.length; j++) {
				int x_delt = points[j].x - points[i].x;
				int y_delt = points[j].y - points[i].y;
				int div_elem = gcd(x_delt, y_delt);
				if (x_delt == 0 && y_delt == 0) {
					same++;
					continue;
				}
				if (x_delt == 0) {
					ver++;
					continue;
				}
				if (y_delt == 0) {
					hor++;
					continue;
				}
				x_delt /= div_elem;
				y_delt /= div_elem;
				if (x_delt < 0) {
					x_delt = -x_delt;
					y_delt = -y_delt;
				}
				array[k].x = x_delt;
				array[k].y = y_delt;
				k++;
			}
			if (hor + same > max)
				max = hor + same;
			if (ver + same > max)
				max = ver + same;
			quicksort(array, 0, k-1);
			for (int s = 0, e = 1; e < k; s = e, e++) {
				while (e < k && cmp(array[e], array[s]) == 0)
					e++;
				if (e - s + same > max)
					max = e - s + same;
			}
		}
		return max;
	}
}
