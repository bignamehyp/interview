package crack150;

public class Problem11_8 <E extends Comparable<? super E>> {
	
	
	
	Problem11_8<E> left;
	Problem11_8<E> right;
	        E data = null;
	      int leftChild = 0;
	      
	      public Problem11_8( ){
 	      }
	      
	      public Problem11_8(E d){
	    	  this.data = d;
	      }
	      
	      public void inser(E d){
	    	  if(data == null){
	    		  data = d;
	    		  return;
	    	  }
	    	  
	    	  if(d.compareTo(data) <= 0){
	    		  if(left!=null){	    			 
	    			 left.inser(d); 
	    		  }else{
	    			  left = new Problem11_8<E>(d);
	    		  }
	    		  leftChild++;
	    	  }else{
	    		  if(right != null)
	    			  right.inser(d);
	    		  else
	    			  right = new Problem11_8<E>(d);
	    	  }
	      }
	      
	      public int track(E d){
	    	  if(data.compareTo(d) == 0){
	    		  return leftChild;
	    	  }else if(data.compareTo(d) > 0){
	    		  if(left != null)
	    			  return left.track(d);
	    		  else
	    			  return -1;
	    	  }else{
	    		  int tmp = -1;
	    		  
	    		  if(right != null){
	    			  tmp = right.track(d);
	    		  }else
	    			  tmp = -1;
	    		  
	    		  if(tmp < 0)
	    			  return -1;
	    		  else{
	    			  return leftChild + 1 + tmp;
	    		  }
	    	  }
	      }
	      
	       

	

	
	
	
	public static void main(String[] argins){
		Problem11_8<Integer> root = new Problem11_8<Integer>();
		
		int [] array = new int []{5,1,4,4,5,9,7,13,3};
		for(int i : array)
			root.inser(i);
		
 		System.out.println(root.track(1));
		System.out.println(root.track(3));
		System.out.println(root.track(4));

	}
}
