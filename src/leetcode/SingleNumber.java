package leetcode;

public class SingleNumber {
/*	Given an array of integers, every element appears twice except for one. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/

	 public int singleNumber2(int[] A) {
	        int result = 0;
	        for(int number : A){
	        	result = result ^ number;
	        }
	        return result;
	    }
	 
	 //Given an array of integers, every element appears three times except for one. Find that single one.

	 public int singleNumber3(int[] A) {
		 int ones = 0, twos = 0, threes = 0;
	        for(int i  : A){
	        	//which bits appear twice already
	            twos |= ones & i;
	            //xor the stream
	            ones ^= i;
	            //which bits appear exactly three times
	            threes = ones & twos;
	            //masked out bits appeared three times
	            ones &= ~threes;
	            twos &= ~threes;
	        }
	        return ones;
	    }
	 
}
