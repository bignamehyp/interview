package leetcode;

public class Wildcard {
	/**
	 * Very Tricky the use of s_star, p_star
	 * 	 * '?' Matches any single character.
	 * '*' Matches any sequence of characters (including the empty sequence).
	 * @param s abcded aa
	 * @param p a*d     a
	 * @return
	 */
	public boolean isMatch2(String s, String p) {
		char [] s_char = s.toCharArray();
		char [] p_char = p.toCharArray();
		int s_iter = 0, p_iter = 0;
		int p_star = -1, s_star = -1;

		while(s_iter < s.length()){
			if(p_iter < p.length() && (s_char[s_iter] == p_char[p_iter] || p_char[p_iter] == '?')){
				s_iter++;
				p_iter++;
				continue;
			}
			if(p_iter < p.length() && p_char[p_iter] == '*'){
				p_star = p_iter;
				s_star = s_iter;
				p_iter++;
				continue;
			}
			if(p_star >= 0){ // there was a star
				s_star++;
				s_iter = s_star;
				p_iter = p_star + 1;
				continue;
			}
			return false;
		}
		for(; p_iter < p.length(); p_iter++){
			if(p_char[p_iter]!='*')
				return false;
		}
		return true;
	}

	/**
	 * Maybe DP is a good approach
	 * '.' Matches any single character.
	'*' Matches zero or more of the preceding element.
	 * @param s
	 * @param p
	 * @return
	 */
	public boolean isMatch(String s, String p) {

		if(p==null || p.length()==0){
			if(s==null||s.length()==0)
				return true;
			return false;
		}

		boolean [][] dp = new boolean[s.length() + 1][p.length() + 1]; 

		dp[0][0] = true;



		for(int p_iter = 0; p_iter < p.length(); p_iter++){
			dp[0][p_iter + 1] = false;
			if(p_iter > 0 && p.charAt(p_iter ) == '*'){
				dp[0][p_iter + 1] = dp[0][p_iter -1];
			}

			for(int s_iter = 0; s_iter < s.length(); s_iter++){
				if(p.charAt(p_iter) == '*'){
					//0 matches
					dp[s_iter+1][p_iter + 1] = dp[s_iter + 1][p_iter - 1];
					//1 matches or more
					if(dp[s_iter][p_iter + 1] && (s.charAt(s_iter) == p.charAt(p_iter - 1) ||p.charAt(p_iter - 1) == '.') ){
						dp[s_iter+1][p_iter + 1] = true;
					}
					continue;
				}

				if(p.charAt(p_iter) == s.charAt(s_iter)  || p.charAt(p_iter) == '.'){
					dp[s_iter+1][p_iter+1] = dp[s_iter][p_iter];
					continue;
				}
				dp[s_iter+1][p_iter + 1] = false;

			}
		}

		return dp[s.length()][p.length()];

	}


	public static void main(String [] args){
		Wildcard w = new Wildcard();
		System.out.println(w.isMatch2("", "."));

	}
}
