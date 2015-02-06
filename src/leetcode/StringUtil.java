package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class StringUtil {


	/**
	 * Tricky use dp
	 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
	 * @param s1 "aabcc",
	 * @param s2 "dbbca",
	 * @param s3 s3 = "aadbbcbcac", return true. When s3 = "aadbbbaccc", return false
	 * @return
	 */
	public boolean isInterleave(String s1, String s2, String s3) {


		if(s1 == null || s1.length() == 0)
			return s2.equals(s3);

		if(s2 == null || s2.length() == 0)
			return s1.equals(s3);

		if(s1.length() + s2.length() != s3.length())return false;

		boolean [][] dp = new boolean[ s1.length() + 1 ][ s2.length() + 1 ];

		for(int cur1 = 1; cur1 <= s1.length(); cur1++){
			dp[cur1][0] = s1.charAt(cur1 - 1) == s3.charAt(cur1 - 1);
		}

		for(int cur2 = 1; cur2 <= s2.length(); cur2++){
			dp[0][cur2] = s2.charAt(cur2 - 1) == s3.charAt(cur2 - 1);
		}

		for(int cur1 = 1; cur1 <= s1.length(); cur1++){
			for(int cur2 = 1; cur2 <= s2.length(); cur2++){
				dp[cur1][cur2] = (dp[cur1 - 1][cur2] && s1.charAt(cur1 - 1) == s3.charAt(cur1 + cur2 - 1))
						|| ( dp[cur1][cur2 -1] && s2.charAt(cur2 - 1) == s3.charAt(cur1 + cur2 - 1) );
			}
		}
		return dp[s1.length()][s2.length()];

	}



	public String strStr(String haystack, String needle) {
		if(needle == null || needle.length() == 0)
			return haystack;

		if(haystack == null || haystack.length() == 0)return null; 

		int needleLen = needle.length();

		for(int pos = 0; pos < haystack.length() - needleLen + 1; pos++ ){
			if(haystack.substring(pos, pos + needleLen).equals(needle) ){
				return haystack.substring(pos);
			}
		}
		return null;
	}

	/**
	 * Given two numbers represented as strings, return multiplication of the numbers as a string.
	 * The numbers can be arbitrarily large and are non-negative
	 * 
	 */
	String multiply(String num1, String num2) {

		if(num1.length() == 1 && num1.charAt(0) == '0')
			return "0";

		if( num2.length() == 1){
			StringBuilder sb = new StringBuilder();

			int n2 = num2.charAt(0) - '0';
			if(n2 == 0)
				return "0";				   
			int pos1 = num1.length() - 1;
			int carry = 0;
			while( pos1 >= 0){
				int n1 = num1.charAt(pos1) - '0';
				int temp = n1 * n2 + carry;
				sb.append( temp % 10);
				carry = temp / 10;				  
				pos1--;
			}
			if(carry > 0)
				sb.append(carry);
			return sb.reverse().toString(); 
		}

		String ans = "0";		 

		for(int pos2 = num2.length() - 1; pos2 >= 0; pos2--){
			String mul = multiply(num1, num2.substring(pos2, pos2+1));
			char [] padZeros = new char[ num2.length() - 1 - pos2 ];
			Arrays.fill(padZeros, '0');
			mul = mul + new String(padZeros);
			ans = addStr(mul, ans);
		}

		return ans;
	}

	String addStr(String num1, String num2){
		StringBuilder sb = new StringBuilder();
		int pos1 = num1.length() - 1;
		int pos2 = num2.length() - 1;
		int carry = 0;

		while(pos1 >=0 || pos2 >= 0){
			int n1 = 0;
			if(pos1>=0)
				n1 = num1.charAt(pos1) - '0';

			int n2 = 0;
			if(pos2 >= 0)
				n2 = num2.charAt(pos2) - '0';

			if( n1 + n2 + carry >= 10){
				sb.append(n1 + n2 + carry - 10);
				carry = 1;
			}else{
				sb.append(n1 + n2 + carry);
				carry = 0;
			}
			pos1--;
			pos2--;
		}

		if(carry > 0){
			sb.append(carry);
		}
		return sb.reverse().toString();
	}


	/**
	 * DP solution
	 * Given a string S and a string T, count the number of distinct subsequences of S that equal T.
	 */
	public int numDistinct(String S, String T) {
		int [][] bp = new int[T.length() + 1][S.length() + 1];

		bp[0][0] = 1;
		for(int s = 0; s < S.length(); s++){
			bp[0][s+1] = 1;
		}
		for(int t = 0; t < T.length(); t++){
			bp[t+1][0] = 0;
		}

		for(int t = 0; t < T.length(); t++){
			for(int s = 0; s < S.length(); s++){
				if(S.charAt(s) == T.charAt(t)){
					bp[t+1][s+1] = bp[t+1][s] + bp[t][s];
				}else{	    			  
					bp[t+1][s+1] = bp[t+1][s]; 
				}
			}
		}
		return bp[T.length()][S.length()];

	}

	/**
	 * 
	 * @param strs
	 * @return
	 */
	public ArrayList<String> anagrams(String[] strs) {
		HashMap<String, ArrayList<String>> groups = new   HashMap<String, ArrayList<String>>();
		for(String str : strs){

			char [] c = str.toCharArray();
			Arrays.sort(c);	    	 
			String key = new String(c);

			if(!groups.containsKey(key)){
				ArrayList<String> group = new ArrayList<String>();
				group.add(str);
				groups.put(key, group);
			}else{
				ArrayList<String> group = groups.get(key);
				group.add(str);
			}
		}
		ArrayList<String> ans = new ArrayList<String>();

		for(ArrayList<String> group : groups.values()){
			if(group.size() > 1)	  
				ans.addAll(group);
		}
		return ans;


	}


	public String countAndSay(int n) {
		String num = "1";
		for(int i = 1; i < n; i++){
			num = growCount(num);
		}
		return num;
	}

	String growCount(String num){

		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < num.length(); i++){
			int count = 1;
			while(i +1 < num.length() && num.charAt(i) == num.charAt(i+1)){
				i++;
				count++;
			}
			sb.append(count);
			sb.append(num.charAt(i));			 
		}
		return sb.toString();

	}



	public boolean isScramble(String s1, String s2) {
		if(s1.length() == 0 && s1.length() == 0)
			return true;
		int n = s1.length();

		boolean [][][] dp = new boolean[n][n][n];
		for(int len = 0; len <n; len++){
			for(int i = 0; i < n - len; i++){
				for(int j = 0; j < n - len; j++){
					if(len == 0){
						dp[i][j][len] = s1.charAt(i) == s2.charAt(j);
					}else{
						for(int b = 1; b <= len; b++){
							if( (dp[i][j+len-b+1][b - 1] && dp[i + b][j][len - b])  || 
									(dp[i][j][b-1] && dp[i+b][j+b][len-b]) 	) 
								dp[i][j][len] = true;							
						}

					}
				}
			}
		}
		return dp[0][0][n-1];
	}

	public String longestCommonPrefix(String[] strs) {
		if(strs == null || strs.length == 0)
			return "";
		Arrays.sort(strs); 	  
		return  commonPrefix(strs[0], strs[strs.length - 1]);
	}	 

	String commonPrefix(String a, String b){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < Math.min(a.length(), b.length());i++){
			if(a.charAt(i) == b.charAt(i)){
				sb.append(a.charAt(i));
			}else
				break;			  
		}
		return sb.toString();
	}

	/** ZigZag Conversion
	 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
	 * @param s
	 * @param nRows
	 * @return
	 */
	public String convert(String s, int nRows) {
		if(s == null || s.length() == 0)
			return new String();
		if(nRows == 1 || nRows >= s.length())
			return s;

		char [] ans = new char[s.length()];
		int perGroup = nRows * 2  - 2;
		int numGroups = (s.length() - 1 )/ perGroup + 1;
		int offSet = s.length() - (numGroups - 1) * perGroup;

		int [] offSets = new int [nRows];
		offSets[0] = 0;

		for(int row = 1; row < nRows; row++){
			if(row == 1)
				offSets[row] = offSets[row - 1] + numGroups;
			else{
				offSets[row] = offSets[row - 1] + 2 * (numGroups - 1);
				if(offSet >= row){
					offSets[row]++;
				}
				if(offSet > nRows && offSet + row >=  nRows * 2 )
					offSets[row]++;
			}
			System.out.println(row + " " + offSets[row]);
			 
		}

		for(int i = 0; i < s.length(); i++){
			int group = i / perGroup;
			int row = i % perGroup;
			int i2;
			if(row ==0 || row == nRows - 1){
				i2 = group + offSets[row]; 
			}else  if(row < nRows){
				i2 = group * 2 + offSets[row];
			}else{
				i2 = group * 2 + 1 + offSets[perGroup - row];
			}
			System.out.println(i + " " + i2);
			ans[i2] = s.charAt(i);

		}
		return new String(ans);

	}



	public static void main(String [] args){
		StringUtil su = new StringUtil();
		su.convert("ABCDEF", 4);
	}

}

