package orderedSet;

import java.util.Random;

public class MyInteger implements Comparable{
	private int value;
	
	public MyInteger(int x){
		value = x;
	}
	
	public void setValue(int x){
		value = x;
	}
	
	public int getValue(){
		return value;
	}
	
	public static MyInteger[] toObjectArray(int [] a){
		MyInteger [] b = new MyInteger[a.length];
		for(int i = 0; i < a.length; i++){
			b[i] = new MyInteger(a[i]);
		}
		return b;		
	}
	
	public final boolean equals(Comparable rhs){
		return rhs != null && value == ((MyInteger)rhs).value;
	}

	
	public final boolean less(Comparable rhs){
		return value < ((MyInteger)rhs).value;
	}

	public final int compareTo(Comparable rhs){
		return value < ((MyInteger)rhs).value ? - 1:  
			value == ((MyInteger)rhs).value? 0 : 1;
	}
	
	public static void printArray(MyInteger [] a){
		for(int i = 0; i < a.length; i++)
			System.out.printf("%d ", a[i].getValue());
		System.out.println();
	}
	
	public static void main(String[] args){
		int n = 20;
		
		if(args.length >= 1){
			n = Integer.valueOf(args[0]);
		}
        for(int iter = 0; iter < 100; iter++){			
        	MyInteger [] a = new MyInteger[n];  
        	Random generator = new Random();

        	for(int i = 0; i < n; i++)
        		a[i] = new MyInteger(generator.nextInt());
 
        	//long start = System.currentTimeMillis();
        	QuickSort.sort(a);
        	//System.out.printf("It takes %d ms to sort %d elements using quick Sort\n",System.currentTimeMillis() - start, n);
//        	if(!Test.test(a)){
//        		System.out.println("Error");
//        		for(int i = 0; i < a.length; i++)
//        			System.out.print(" " + a[i].getValue());
//        		System.out.println();
//        	}
        }
		return;		
		
	}
	
}
