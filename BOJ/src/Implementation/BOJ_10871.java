package Implementation;

/*
 * BOJ #10871 X보다 작은 수
 * https://www.acmicpc.net/problem/10871
 * 구현
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10871 {
	
	static int n, x;
	static StringBuilder out = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < n; i++) {
			int a = Integer.parseInt(st.nextToken());
			if(a < x) out.append(a + " ");
		}
		
		System.out.print(out.substring(0, out.length()-1));
	}
}
