package leetcode;

import java.util.LinkedList;

public class UnixPath {
	/**
	 * Given an absolute path for a file (Unix-style), simplify it.
	 * @param path
	 * @return
	 */
	
	public String simplifyPath(String path) {
		
        StringBuilder sb = new StringBuilder();
		
        String [] dirs = path.split("/");
		LinkedList<String> stack = new LinkedList<String>();
		
		
		for(String dir : dirs){
			if(dir.length() > 0 && !dir.equals(".")){
 				if(dir.equals("..")){
					if(stack.size() > 0)stack.pollLast();
				}else{
					stack.add(dir);
				}
			}
 		}
		
		for(String dir : stack){
			sb.append("/");
			sb.append(dir);
		}
		
		if(stack.size() == 0){
			return "/";
		}
		
		return sb.toString();
     }

	public static void main(String [] args){
		UnixPath u = new UnixPath();
 		System.out.println(u.simplifyPath("/../"));
	}
	
}
