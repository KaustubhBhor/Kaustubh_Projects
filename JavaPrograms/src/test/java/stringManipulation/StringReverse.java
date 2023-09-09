package stringManipulation;

import java.util.ArrayList;

public class StringReverse {

	public static void main(String[] args) {
		
		String s = "This is an LKQ test";
		
		System.out.println("Given  : " + s);
		reverseFunction(s);
		System.out.println("---------------");
		reverseSting(s);
		System.out.println("---------------");
		reverseWithoutMovingSpaces(s);
	}
	
	private static void reverseFunction(String s) {
		
		StringBuilder sb = new StringBuilder(s);
		sb = sb.reverse();
		String rev = sb.toString();

		System.out.println("Reverse: " + rev);
	}

	private static void reverseSting(String s) {
		
		char[] ch = s.toCharArray();
		String rev = "";
		
		for (int i = ch.length-1; i > 0; i--) {
			
			rev = rev+ch[i];
		}
		
		System.out.println("Reverse: " + rev);
	}
	
	private static void reverseWithoutMovingSpaces(String s) {
		
		String rev = "";

		ArrayList<Integer> spaceIndexes = new ArrayList<Integer>();
		
		for (int i = 0; i < s.length(); i++) {
			
			char c = s.charAt(i);
			if(c == ' ') {
				spaceIndexes.add(i);
			}else {
				rev = c + rev;
			}
		}
		
		StringBuilder sb = new StringBuilder(rev);
		
		for (int j = 0; j < spaceIndexes.size(); j++) {
			sb.insert(spaceIndexes.get(j), " ");
		}
		
		rev = sb.toString();
		System.out.println("Reverse without moving spaces");
		System.out.println(rev);
	}

}
