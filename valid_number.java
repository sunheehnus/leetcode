import java.util.regex.*;
public class Solution {
	public boolean isNumber(String s) {
		String numRegex = "^\\s*[+-]?(\\d+|\\d*\\.\\d+|\\d+\\.\\d*)([eE][+-]?\\d+)?\\s*$";
		Pattern pattern = Pattern.compile("^" + numRegex + "" + "$");
		Matcher matcher = pattern.matcher(s);
		return matcher.matches();
	}
}
