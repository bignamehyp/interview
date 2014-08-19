package orderedSet;

public class InsertionSort {
	public static void sort(Comparable a[]) {
		for (int j = 1; j < a.length; j++) {
			Comparable tmp = a[j];
			int k;
			for (k = j; k > 0 && tmp.less(a[k - 1]); k--) {
				a[k] = a[k - 1];
			}
			a[k] = tmp;
		}
	}
	
	public static void sort(Comparable a[],int left, int right) {
		for (int j = left + 1; j <= right; j++) {
			Comparable tmp = a[j];
			int k;
			for (k = j; k > left && tmp.less(a[k - 1]); k--) {
				a[k] = a[k - 1];
			}
			a[k] = tmp;
		}
	}
	public static void sort(float a[]) {
		for (int j = 1; j < a.length; j++) {
			float tmp = a[j];
			int k;
			for (k = j; k > 0 && tmp < a[k - 1]; k--) {
				a[k] = a[k - 1];
			}
			a[k] = tmp;
		}
	}
	
	public static void sort(float a[],int left, int right) {
		for (int j = left + 1; j <= right; j++) {
			float tmp = a[j];
			int k;
			for (k = j; k > left && tmp < a[k - 1]; k--) {
				a[k] = a[k - 1];
			}
			a[k] = tmp;
		}
	}
	
	
}
