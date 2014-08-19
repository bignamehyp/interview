package leetcode;

import java.util.ArrayList;
 /**
  *  
  * @author huangyp
  * Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
  */
public class RestoreIpAddresses {
	public ArrayList<String> restoreIpAddresses(String s) {
		ArrayList<String> ans = new ArrayList<String>();
		if(s.length() < 4 || s.length() > 12)
			return ans;
		
		dfs(s, "", ans, 0);
		
		return ans;
		 
    }
	
	public void dfs(String s, String tmp, ArrayList<String> ans, int count){
		if(count == 3 && isValid(s)){ //the ending part of ip address
			ans.add(tmp + s);
			return;
		}
		
		for(int i = 1; i < 4 && i < s.length(); i++){
			String sub = s.substring(0,i);
			if(isValid(sub)){
				dfs(s.substring(i), tmp + sub + '.', ans, count + 1);
			}
		}
	}
	
	public boolean isValid(String s){  
        if (s.charAt(0)=='0') return s.equals("0");  
        int num = Integer.parseInt(s);  
        return num<=255 && num>0;  
    }  
	
}
