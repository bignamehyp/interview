package leetcode;

import java.util.ArrayList;

public class Rome {
	/**
	 * Given a roman numeral, convert it to an integer.
	 * @param s
	 * @return
	 */
	public ArrayList<Integer> grayCode(int n) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		 
	
		for(int i = 0; i < (1 << n) ; i++){
			int ret = (i >> 1)^i;
 			 ans.add(ret);
		}
		
		return ans;
    }
	
	
	
	public int romanToInt(String s) {
        
		if(s == null || s.length() == 0)
			return 0;
		int val = 0;
		for(int i = 0; i < s.length() - 1; i++){
			int x = getDigit(s.charAt(i));			
			if(x  < getDigit(s.charAt(i+1))){
				val -= x;
			}else{
				val+= x;
			}
		}
		val += getDigit(s.charAt(s.length() - 1));
		return val;
    }
	
	public int getDigit(char c){
		if(c == 'I')return 1;
		if(c == 'V')return 5;
		if(c == 'X')return 10;
		if(c == 'L')return 50;
		if(c == 'C')return 100;
		if(c == 'D')return 500;
		if(c == 'M')return 1000;
		
		return 0;
	}
	
	public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        
         int thousands = num /1000;
         num = num - thousands * 1000;
         int hundreds = num / 100;
         num = num - hundreds * 100;
         int tens = num / 10;
         int ones = num - tens * 10;
         
         sb.append(getThousday(thousands));
         sb.append(getHundreds(hundreds));
         sb.append(getTens(tens));
         sb.append(getOnes(ones));
         return sb.toString();
    }
	
	public String getThousday(int digits){
		String s = "";
		while(digits > 0){
			s = s + "M";
			digits--;
		}	
		return s;
	}
	
	public String getHundreds(int digits){
		String s = "";
		
		if(digits == 9)
			return "CM";
		
		if(digits == 4)
			return "CD";
		
		if(digits >= 5){
			s = s + "D";
			while(digits > 5){
				s =  s + "C";
				digits--;
			}
 		}else{
  			while(digits > 0){
 				s = s + "C";
 				digits--;
 			}	
		}
		return s;
	}
	
	public String getTens(int digits){
		String s = "";
		
		if(digits == 9)
			return "XC";
		
		if(digits == 4)
			return "XL";
		
		if(digits >= 5){
			s = s + "L";
			while(digits > 5){
				s =  s + "X";
				digits--;
			}
 		}else{
  			while(digits > 0){
 				s = s + "X";
 				digits--;
 			}	
		}
		return s;
		 
	}
	public String getOnes(int digits){
String s = "";
		
		if(digits == 9)
			return "IX";
		
		if(digits == 4)
			return "IV";
		
		if(digits >= 5){
			s = s + "V";
			while(digits > 5){
				s =  s + "I";
				digits--;
			}
 		}else{
  			while(digits > 0){
 				s = s + "I";
 				digits--;
 			}	
		}
		return s;
	}
	
	
}
