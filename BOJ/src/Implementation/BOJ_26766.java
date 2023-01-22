package Implementation;

/*
 * BOJ #26766 Serca
 * https://www.acmicpc.net/problem/26766
 * 구현
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_26766 {
	
	static int n;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		
		n = Integer.parseInt(in.readLine());
		
		for(int i = 0; i < n; i++) {
			out.append(" @@@   @@@ \n"
					+ "@   @ @   @\n"
					+ "@    @    @\n"
					+ "@         @\n"
					+ " @       @ \n"
					+ "  @     @  \n"
					+ "   @   @   \n"
					+ "    @ @    \n"
					+ "     @     \n");
		}
		
		System.out.print(out);
	}
}
