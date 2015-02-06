package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class MaxPointsInALine {
	
	  public class Point {
	      int x;
	      int y;
	      Point() { x = 0; y = 0; }
	      Point(int a, int b) { x = a; y = b; }
	  }
	
	    public static int maxPoints(Point[] points) {
	        if(points.length == 1) return 1;
	        
	        HashMap<String,HashSet<Integer>> slopes = new HashMap<String, HashSet<Integer>>();
	        
	        for(int i = 0 ; i < points.length; i++){
	            Point p1 = points[i];
	            for(int j = 0; j < i; j++){
	                Point p2 = points[j];
	                int deltaY = p2.y - p1.y;
	                int deltaX = p2.x - p1.x;
	                int intecep = p1.y * p2.x - p2.y * p1.x;
	                int gcd1 = computeGCD(deltaY, deltaX);
	                int gcd2 = computeGCD(intecep, deltaX);
	                
	                StringBuilder sb = new StringBuilder();
	                if(gcd1 != 0){
	                    sb.append(deltaY/gcd1);
	                    sb.append(" ");
	                    sb.append(deltaX/gcd1);
	                    sb.append(" ");
	                }else{
	                    sb.append(deltaY);
	                    sb.append(" ");
	                    sb.append(deltaX);
	                    sb.append(" ");
	                }
	                if(gcd2 != 0){
	                    sb.append(intecep/gcd2);
	                    sb.append(" ");
	                    sb.append(deltaX/gcd2);
	                }else{
	                    sb.append(intecep);
	                    sb.append(" ");
	                    sb.append(deltaX);
	                }
	                String slope = sb.toString();
	                if(deltaX == 0 && deltaY == 0){
	                    slope = p1.x + "_" + p2.x;
	                }
	                
	                if(deltaX == 0){
	                	slope = p1.x + "_";
	                }
	                
	                if(slopes.containsKey(slope)){
	                	HashSet<Integer> pts = slopes.get(slope);
	                    pts.add(i);
	                    pts.add(j);
	                    slopes.put(slope, pts);
	                }else{
	                    HashSet<Integer> pts = new HashSet<Integer>();
	                    pts.add(i);
	                    pts.add(j);
	                    slopes.put(slope, pts);
	                }
	            }
	        }
	        
	        int maxP = 0;
	        for(String slope : slopes.keySet()){
	            int num = slopes.get(slope).size();
	            if(num > maxP){
	            	System.out.println(slope + " " + num);
	            	maxP = num;
	            }
	        }
	        return maxP;
	    }
	    
	    public static int computeGCD(int n1, int n2){
	        if(n2==0)
	        return n1;
	        return computeGCD(n2, n1 % n2);        
	    }
	    
	    public static void main(String[] args){
	    	String input = "40,-23),(9,138),(429,115),(50,-17),(-3,80),(-10,33),(5,-21),(-3,80),(-6,-65),(-18,26),(-6,-65),(5,72),(0,77),(-9,86),(10,-2),(-8,85),(21,130),(18,-6),(-18,26),(-1,-15),(10,-2),(8,69),(-4,63),(0,3),(-4,40),(-7,84),(-8,7),(30,154),(16,-5),(6,90),(18,-6),(5,77),(-4,77),(7,-13),(-1,-45),(16,-5),(-9,86),(-16,11),(-7,84),(1,76),(3,77),(10,67),(1,-37),(-10,-81),(4,-11),(-20,13),(-10,77),(6,-17),(-27,2),(-10,-81),(10,-1),(-9,1),(-8,43),(2,2),(2,-21),(3,82),(8,-1),(10,-1),(-9,1),(-12,42),(16,-5),(-5,-61),(20,-7),(9,-35),(10,6),(12,106),(5,-21),(-5,82),(6,71),(-15,34),(-10,87),(-14,-12),(12,106),(-5,82),(-46,-45),(-4,63),(16,-5),(4,1),(-3,-53),(0,-17),(9,98),(-18,26),(-9,86),(2,77),(-2,-49),(1,76),(-3,-38),(-8,7),(-17,-37),(5,72),(10,-37),(-4,-57),(-3,-53),(3,74),(-3,-11),(-8,7),(1,88),(-12,42),(1,-37),(2,77),(-6,77),(5,72),(-4,-57),(-18,-33),(-12,42),(-9,86),(2,77),(-8,77),(-3,77),(9,-42),(16,41),(-29,-37),(0,-41),(-21,18),(-27,-34),(0,77),(3,74),(-7,-69),(-21,18),(27,146),(-20,13),(21,130),(-6,-65),(14,-4),(0,3),(9,-5),(6,-29),(-2,73),(-1,-15),(1,76),(-4,77),(6,-29";
	    	String [] pairs = input.split("\\),\\(");
	    	MaxPointsInALine mp = new MaxPointsInALine();
	    	ArrayList<Point> points = new ArrayList<Point>();
	    	for(int i = 0; i < pairs.length; i++){
	    		String [] num = pairs[i].split(",");
	    		
	    		points.add(mp.new Point(Integer.valueOf(num[0]), Integer.valueOf(num[1])));
	    	}
	    	System.out.println(maxPoints(points.toArray(new Point[points.size()])));
	    	return;

	    }
 }
