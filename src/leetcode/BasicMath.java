package leetcode;

public class BasicMath {

	/**
	 * Newton's method
	 * @param x
	 * @return
	 */
	public int sqrt(int x) {
		if(x < 2 ){
			return x;
		}

		double a = 1, b = 1;

		while(true){
			b = (double)x / 2 / a + a / 2;
			if( (int) b   == (int)a   )
				break;
			a  = b;
		}


		return (int)a;
	}
	
	double pow(double x, int n) {
        if(n==0) return 1;
        if(n==1) return x;
        if(x==0) return x;
        if(n<0){
            x = 1/x;
            n = -n;
        }
        if(n%2==1) return x*pow(x*x, n/2);
        else return pow(x*x, n/2);
    }
	

	public int divide(int dividend, int divisor) {
		if(dividend == 0)
			return 0;
		int sign = 1;
		double divd = 1.0 * dividend;
		double divs = 1.0 * divisor;
		if((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)){
			sign = -1;
			divd = Math.abs(divd);
			divs = Math.abs(divs);
		}
		if(dividend < 0 && divisor < 0){
			divd = Math.abs(divd);
			divs = Math.abs(divs);
		}

        int ans  = (int) Math.round(Math.exp(Math.log(divd) - Math.log(divs)));
		return ans * sign;
	}
	
	
	public String addBinary(String a, String b) {
		StringBuilder sb = new StringBuilder();
		int pos1 = a.length() - 1, pos2 = b.length() -1;
		int carry = 0;
		while(pos1 >= 0 || pos2 >=0){
			int d1 = 0;
			if(pos1 >= 0)
				d1 = a.charAt(pos1) - '0';
			
			int d2 = 0;
			if(pos2 >= 0)
				d2 = b.charAt(pos2) - '0';
			
			int ans = d1 + d2 + carry;
			if(ans  > 1){
				ans -= 2;
				carry = 1;
			}else{
				carry = 0;
			}
			sb.append(ans);
			pos1--;
			pos2--;
 		}
		if(carry == 1)
			sb.append(carry);
		return sb.reverse().toString();
		
    }


	public static void main(String [] args){
		BasicMath bm = new BasicMath();
		System.out.println(bm.divide(-2147483648, 1));
	}

}
