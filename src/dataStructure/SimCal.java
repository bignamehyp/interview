package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SimCal {
	private static boolean operatorGE(char a, char b){
		return (a=='*' || a=='/') || !( b == '*' || b == '/');
	}

	public static void main(String[] args){
		String a = new String();
		System.out.println("Enter your simCal expression in one line below");
		InputStreamReader istream = new InputStreamReader(System.in) ;
		BufferedReader bufRead = new BufferedReader(istream) ;
		try {
			a = bufRead.readLine();
			a = a + " ";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StringBuffer b = new StringBuffer();
		SList<Character> s = new SList<Character>();
		for(int i = 0; i <  a.length(); i++){
			while( (a.charAt(i) >= '0') && (a.charAt(i) <= '9')){
					b.append(a.charAt(i++));
			}
			b.append(' ');/*each number ends with a space to separate from each other*/
			
			
			if( (a.charAt(i)== '+') || (a.charAt(i)== '-') || (a.charAt(i) == '/') || (a.charAt(i)== '*')){
				while( (!s.isEmpty()) && (s.at(0) != '(' ) ) {
					if( operatorGE(s.at(0), a.charAt(i))){
						b.append(s.remove(0));
					}
					else
						break;
				}
				s.push(a.charAt(i));
			}

			if( a.charAt(i) == '('){
				s.push(a.charAt(i));
			}

			if( a.charAt(i) == ')'){
				while( (!s.isEmpty()) && (s.at(0) != '(' ) ) {
					b.append(s.remove(0));							
				}
				if(!s.isEmpty())/*when a '(' is encountered*/
					s.remove(0);
			}
		}
		while(!s.isEmpty()){
			b.append(s.remove(0));							
		}

		SList<Integer> s2 = new SList<Integer>();

		System.out.println("Postfix Expression:");
		System.out.println(b.toString());

		for(int i = 0; i < b.length(); i++){
			if(b.charAt(i) == '+' || b.charAt(i) == '-' || b.charAt(i)== '*' || b.charAt(i)== '/'){
				int l, r;
				if(!s2.isEmpty())
					r = s2.remove(0);
				else{
					System.out.println("Invalid input expression, exit now\n");
					return;
				}
				if(!s2.isEmpty())
					l = s2.remove(0);
				else{
					System.out.println("Invalid input expression, exit now\n");
					return;
				}
				switch(b.charAt(i)){
				case '+': 
					s2.push(l+r);
					break;
				case '-': 
					s2.push(l-r);
					break;
				case '*': 
					s2.push(l*r);
					break;
				case '/':
					s2.push(l/r);
					break;
				}
			}
			else{
				if( (b.charAt(i)>= '0') && (b.charAt(i) <= '9'))
					s2.push(0);
				while( (b.charAt(i) >= '0') && (b.charAt(i) <= '9'))
					s2.push(10 * s2.remove(0) + b.charAt(i++) - '0');
			}
		}
		if(!s2.isEmpty())
			System.out.println("The result is " + s2.remove(0));
		else
			System.out.println("Invalid input expression\n");
	
		return;
	}

}

