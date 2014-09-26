public class Solution {
	int min(int a, int b) {
		return a > b ? b : a;
	}
	public int jump(int[] A) {
		boolean[] visited = new boolean[A.length];
		int[] steps = new int[A.length];
		Queue<Integer> queue = new LinkedList<Integer>();

		visited[0] = true;
		steps[0] = 0;
		queue.add(0);
		while (!queue.isEmpty()) {
			int cur = queue.remove();
			for (int i = min(A[cur] + cur, A.length - 1); i >= cur && visited[i] == false; i--) {
				visited[i] = true;
				steps[i] = steps[cur] + 1;
				queue.add(i);
			}
		}
		return steps[A.length - 1];
	}
}
