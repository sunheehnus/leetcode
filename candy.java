import java.util.Arrays;
public class Solution {
	class Rating_Pos implements Comparable<Rating_Pos> {
		public int rating;
		public int pos;
		public Rating_Pos(int rating, int pos) {
			this.rating = rating;
			this.pos = pos;
		}
		public int compareTo(Rating_Pos rp) {
			if (this.rating > rp.rating || (this.rating == rp.rating) && (this.pos > rp.pos))
				return 1;
			else if (this.rating < rp.rating || (this.rating == rp.rating) && (this.pos < rp.pos))
				return -1;
			return 0;
		}
	}
	public int candy(int[] ratings) {
		if (ratings == null || ratings.length == 0)
			return 0;
		Rating_Pos [] rps = new Rating_Pos[ratings.length];
		for (int i = 0; i < ratings.length; i++) {
			rps[i] = new Rating_Pos(ratings[i], i);
		}
		Arrays.sort(rps);
		int res = 0;
		int [] candys = new int[ratings.length];
		for (int i=0, cur, pos; i < rps.length; i++) {
			cur = 1;
			pos = rps[i].pos;
			if (pos != 0 && ratings[pos] > ratings[pos - 1]) {
				if (candys[pos - 1] + 1 > cur)
					cur = candys[pos - 1] + 1;
			}
			if (pos != candys.length - 1 && ratings[pos] > ratings[pos + 1]) {
				if (candys[pos + 1] + 1 > cur)
					cur = candys[pos + 1] + 1;
			}
			candys[pos] = cur;
			res += cur;
			System.out.println(rps[i].rating + " " + rps[i].pos + " " + cur);
		}
		return res;
	}
}
