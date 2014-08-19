package orderedSet;

public class RadixSort {
	public static void sort(Object [] a, int base, int pass){
		int n = a.length;
		int [] c = new int[base];
		int [] d = new int[n];
		Object [] b = new Object[n];
		for(int p = 0; p < pass; p++){	
			for(int k = 0; k < base; k++)
					c[k] = 0;
			for(int i = 0; i < n; i++){
					d[i] = getDigit(a[i],p,base);
					c[d[i]]++;
			}
			for(int k = 1; k < base; k++)
				c[k]+=c[k-1];
			for(int i = n - 1; i >= 0; i--){
				b[c[d[i]] - 1] = a[i];
				c[d[i]]--;
			}
			for(int i = 0; i< n; i++)
				a[i] = b[i];
		}
	}
	
	final static int getDigit(Object a, int pass, int base){
		int num = (Integer)a;
		for(int i = 0; i < pass; i++)
			num = num / base;
		return num%base;
	}
	
}
