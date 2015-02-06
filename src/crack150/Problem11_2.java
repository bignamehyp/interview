package crack150;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class Problem11_2 {
	
	public void sortByAnagram(String[] array){
		HashMap<String, LinkedList<String>> map = new HashMap<String, LinkedList<String>>();
		for(String str : array){
			
			char[] key = str.toCharArray();
			Arrays.sort(key);
			String keyStr = new String(key);
			if(!map.containsKey(keyStr)){
				map.put(keyStr, new LinkedList<String>());
			}
				 
			LinkedList<String> anagrams = map.get(keyStr);
			anagrams.add(str);
		}
		int index = 0;
		
		for(String key : map.keySet()){
			LinkedList<String> anagrams = map.get(key);
			for(String str: anagrams){
				array[index++]= str;
			}
		}
		
		
	}
}
