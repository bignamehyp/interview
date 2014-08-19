package crack150;

public class Problem1_4 {

	static char [] replaceWithAscii(char [] input){
		int numSpaces = 0;
		
		for(char c : input){
			if(c == ' ')
				numSpaces++;
		}
		
		char [] output = new char [input.length + numSpaces * 2];
		int iter_out = 0;
		
		for(char c : input){
			if(c == ' '){
				output[iter_out++] = '%';
				output[iter_out++] = '2';
				output[iter_out++] = '0';
			}else {
				output[iter_out++] = c;
				}
				
		}
		return output;
		
	}
	
	public static void main(String [] args){
		String str1 = "a bcd ef";
		String str2 = "aa bb cc d  dd";
		System.out.println(String.valueOf(replaceWithAscii(str1.toCharArray())));
		System.out.println(String.valueOf(replaceWithAscii(str2.toCharArray())));
		 
		
	}
	
}
