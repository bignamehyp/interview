package leetcode;

public class DecodeWays {
	public int numDecodings(String s) {
		int len = s.length();

		if(len == 0)
			return 0;
		char [] s_char = s.toCharArray();
		int part1 = 0;
		int part2 = 0;
		int sum = 0;

		if(s_char[0] != '0')
			part1 = 1;

		if(len == 1){
			return part1;
		}

		int tmp = Integer.valueOf(s.substring(0,2));

		if(s_char[1] != '0')
			part2 += part1;

		if(tmp <= 26 && tmp >= 10){
			part2++;
		} 

		if(len == 2){
			return part2;
		}


		for(int pos = 2; pos < len; pos++){
			tmp = Integer.valueOf(s.substring(pos-1, pos+1));
			sum = 0;
			if (tmp <= 26 && tmp >= 10){
				sum += part1;
			}
			if(s_char[pos]!='0')
				sum+=part2;

			part1 = part2;
			part2 = sum;
		}
		return sum;
	}
}
