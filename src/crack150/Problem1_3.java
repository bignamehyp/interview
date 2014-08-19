package crack150;

import java.util.HashMap;

public class Problem1_3 {
	
	
	static boolean isPermu(String str1, String str2){
		HashMap<Character, Integer> map1 = new HashMap<Character, Integer>();
		HashMap<Character, Integer> map2 = new HashMap<Character, Integer>();
		
		for(char c : str1.toCharArray()){
			if(map1.containsKey(c)){
				map1.put(c, map1.get(c) + 1);
			}else{
				map1.put(c, 1);
			}
		}
		
		for(char c : str2.toCharArray()){
			if(map2.containsKey(c)){
				map2.put(c, map2.get(c) + 1);
			}else{
				map2.put(c, 1);
			}
		}
		
		if(map1.size() != map2.size())
			return false;
		
		for(char c: map1.keySet()){
			
			if(map2.containsKey(c) == false)
				return false;
			
			if(map1.get(c) != map2.get(c)){
				return false;
			}
			
		}
		return true;
		
	}
	
	public static void main(String [] args){
		String str1 = "abcdef";
		String str2 = "aabbccddd";
		String str3 = "ccdddaabb";
		System.out.println(isPermu(str1,str2));
		System.out.println(isPermu(str2,str3));
		
	}
	
}
