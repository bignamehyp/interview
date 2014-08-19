package orderedSet;

public class Test {
	public static boolean test(Comparable [] a){
		int i = 1;
		while(i < a.length){
			if(a[i].less(a[i-1]))
				return false;
			i++;
		}
		return true;
	}
}
