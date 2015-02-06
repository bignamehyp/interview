package crack150;

public class Problem1_2 {
	
	static char [] reverse(char [] str){
		
		
		char [] newStr = new char [str.length];
		for(int i = str.length - 1; i >=0; i--){
			newStr[str.length - i - 1] = str[i];
		}
		return newStr;
	}
	
	public static void main(String [] args){
		String str1 = "abcdef";
		String str2 = "aabbccddd";
		System.out.println(reverse(str1.toCharArray()));
		System.out.println(reverse(str2.toCharArray()));
		 
		
	}
}
