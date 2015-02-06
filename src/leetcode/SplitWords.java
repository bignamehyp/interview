package leetcode;

import java.util.ArrayList;
import java.util.HashSet;


public class SplitWords {

	public int findDuplicaties(int [] A){
		
		if(A == null || A.length <= 1){
			return -1;
		}
		
		int N = A.length  - 1;
		
		int l = 1;
		int r = N;
		while ( l  < r) {
			int m = l + ( r - l ) / 2;
			int numSmallers = 0;
 			for(int i : A){
				if ( i <= m ) 
					numSmallers++;
			}
			if ( m - l + 1 <= numSmallers )
				l = m + 1;
			else{
				r = m;
			
			}
		}
		return l;
		
	}
	
	public ArrayList<String> findWords(String input, HashSet<String> dict){
		ArrayList<String>  solns=  new ArrayList<String> ();
		dfs(solns, new StringBuilder(), 0, input, dict);
		return solns;
	}
	
	void dfs( ArrayList<String>  solns, StringBuilder sb, int pos, String input, HashSet<String> dict ){
		if(pos == input.length()){
 			solns.add(new String(sb).trim());
			return;
		}
		
		for (int wordEnd = pos + 1; wordEnd <= input.length(); wordEnd++){
			String sub = input.substring(pos, wordEnd);
			if(dict.contains(sub)){
				sb.append(sub);
				sb.append(" ");
				dfs(solns, sb, wordEnd, input,dict);
				sb.delete(sb.length() - sub.length() - 1, sb.length());
 			} 
		}
	}
	public static void main(String[] args){
		String input ="iatealotoffood";
		HashSet<String> dict = new HashSet<String>();
		dict.add("i");
		dict.add("a");
		dict.add("ate");
		dict.add("at");
		dict.add("tea");
		dict.add("teal");
		dict.add("lot");
		dict.add("of");
		dict.add("to");
		dict.add("off");
		dict.add("food");

		SplitWords soln = new SplitWords();
		ArrayList<String> lists = soln.findWords(input, dict);
		for (String s  : lists){
			System.out.println(s);
		}
	}
}
