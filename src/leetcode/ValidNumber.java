package leetcode;

public class ValidNumber {
	/**
	 * Validate if a given string is numeric.
	Some examples:
	"0" => true
	" 0.1 " => true
	"abc" => false
	"1 a" => false
	"2e10" => true
	Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
	 * @param s
	 * @return
	 */
	public boolean isNumber(String s) {
		 boolean ans = false;
	        s = s.trim();
			try{
			     Double.valueOf(s);
			     ans = true;
			     if(s.toCharArray()[s.length() - 1] > '9' || s.toCharArray()[s.length() - 1] < '0')
					ans = false;
				 if(s.toCharArray()[s.length() - 1] == '.')
			    	 ans = true;
			}catch(NumberFormatException ne){
				
			}
			return ans;
    }
	/**
	 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
	 * @param str
	 * @return
	 */
	public int atoi(String str) {
		if(str == null || str.length() == 0)
			return 0;
		
		int ans = 0;
		str = str.trim();
		char [] c_array = str.toCharArray();
		int sign = 1;
		int curIdx = 0;
		
		if(c_array[0] == '-'){
			sign = -1;
			curIdx++;
		}
		if(c_array[0] == '+'){
			curIdx++;
		}
		
		for(;curIdx < c_array.length;curIdx++){
			if(c_array[curIdx] >= '0' && c_array[curIdx] <= '9'){
				double temp = ans * 10.0 + c_array[curIdx] - '0';
				//handle overflow
				if(sign * temp > Integer.MAX_VALUE){
					return Integer.MAX_VALUE;
				}
				if(sign * temp < Integer.MIN_VALUE){
					return Integer.MIN_VALUE;
				}
				ans = ans * 10 + c_array[curIdx] - '0';
			}else{
				break;
			}
		}
		
        return sign * ans;
    }
}
