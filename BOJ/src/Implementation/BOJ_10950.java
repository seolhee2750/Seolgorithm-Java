package Implementation;

/*
 * BOJ #10950 A+B - 3
 * https://www.acmicpc.net/problem/10950
 * 구현
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10950 {

	static int t;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder out = new StringBuilder();
		
		t = Integer.parseInt(in.readLine());
		for(int i = 0; i < t; i++) {
			st = new StringTokenizer(in.readLine());
			out.append(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()) + "\n");
		}
		
		System.out.print(out);
	}
}
