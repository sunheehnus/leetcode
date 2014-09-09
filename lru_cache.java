import java.util.Iterator;
import java.util.TreeMap;
import java.util.HashMap;
public class LRUCache {

	class Content {
		int value;
		int rank;
		public Content(int value, int rank) {
			this.value = value;
			this.rank = rank;
		}
	}

	int capacity;

	int cur = 0;

	TreeMap<Integer, Integer> rank_key = new TreeMap<Integer, Integer>();
	HashMap<Integer, Content> key_content = new HashMap<Integer, Content>();


	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {
		Content content = key_content.get(key);
		if (content == null)
			return -1;
		else {
			cur++;
			int prerank = content.rank;
			content.rank = cur;
			rank_key.remove(prerank);
			rank_key.put(cur, key);
			return content.value;
		}
	}

	public void set(int key, int value) {
		cur++;
		if (key_content.get(key) != null) {
			int rank = key_content.get(key).rank;
			key_content.remove(key);
			rank_key.remove(rank);
			capacity++;
		}
		if (capacity <= 0)
		{
			int frank = rank_key.firstKey();
			int fkey = rank_key.get(frank);
			rank_key.remove(frank);
			key_content.remove(fkey);
			capacity++;
		}
		capacity--;
		rank_key.put(cur, key);
		key_content.put(key, new Content(value, cur));
	}
}
