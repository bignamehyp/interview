package crack150;

import java.util.BitSet;

public class Problem1_1 {
	
	/**
	 * Determine if an input string has unique characters
	 * @param str
	 * @return true if all characters in str are unique
	 * return false if str is null or length 0
	 */
	public static boolean hasUniqChar(String str){
		final int CharSize = 256;
		BitSet checker = new BitSet(CharSize);
		if(str == null || str.length() == 0){
			return false;
		}
		for(int idx = 0;  idx < str.length(); idx++){
			int currentChar = str.charAt(idx);
			if(checker.get(currentChar)){
				return false;
			}
			else{
				checker.set(currentChar);
 			}				
		}
		return true;
	}
	
	
	public static void main(String [] args){
		String str1 = "abcdef";
		String str2 = "aabbccddd";
		
		System.out.println(hasUniqChar(str1));
		System.out.println(hasUniqChar(str2));
		
	}
}
