package orderedSet;

public interface Comparable {
	int compareTo(Comparable rhs); //compareTo returns -1 if value < rhs, 0 if value == rhs, and if value > rhs	
	boolean less(Comparable rhs);
	boolean equals(Comparable rhs);
}

 