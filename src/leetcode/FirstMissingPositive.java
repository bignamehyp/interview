package leetcode;

public class FirstMissingPositive {
	/**
	 * Given an unsorted integer array, find the first missing positive integer.
	 * @param A
	 * @return
	 * very tricky. To make sure A[i] = i + 1. Handle dublications
	 */
	public int firstMissingPositive(int[] A) {
        if(A == null || A.length == 0 )
        	return 1;
        for(int i = 0; i < A.length; i++ ){
        	while(A[i] > 0 && A[i] <= A.length && A[i] != A[A[i]-1] ){
        		int tmp = A[i];
        		A[i] = A[tmp - 1];
        		A[tmp - 1] = tmp;
        	}
        }
        for(int i = 0; i < A.length; i++){
        	if(A[i] != i + 1){
        		return i + 1;
        	}
        }
        return A.length + 1;
    }
}
