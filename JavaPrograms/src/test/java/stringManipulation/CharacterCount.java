package stringManipulation;

import java.util.HashMap;
import java.util.Map;

public class CharacterCount {

	public static void main(String[] args) {
		String s = "abcdabcaba";
		int count;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		
		for (int i = 0; i < s.length(); i++) {
			if (!map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), 1);
			}else {
				count = map.get(s.charAt(i));
				map.put(s.charAt(i), count+1);
			}
		}
		System.out.println(map.toString());
		
		Map.Entry<Character, Integer> mapEntry = null;
		
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			
			if ((mapEntry == null) || entry.getValue().compareTo(mapEntry.getValue()) > 0) {
				mapEntry = entry;
			}
		}
		System.out.println(mapEntry);
	}

}
