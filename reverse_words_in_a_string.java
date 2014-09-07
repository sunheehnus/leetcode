class Solution {
	public String reverseWords(String s) {
		s = s.trim();
		if (s.equals(""))
			return "";
		String [] str_array = s.split(" ");
		String ret = str_array[str_array.length - 1];
		for (int i = str_array.length - 2; i >= 0; i--) {
			if (!str_array[i].equals(""))
				ret += " " + str_array[i];
		}
		return ret;
	}
}
