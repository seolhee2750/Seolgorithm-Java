package Math;

/*
 * BOJ #9295 주사위
 * https://www.acmicpc.net/problem/9295
 * 수학, 구현
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9295 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder out = new StringBuilder();
		
		int tc = Integer.parseInt(in.readLine());
		for(int t = 1; t <= tc; t++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			out.append("Case " + t + ": " + (a + b) + "\n");
		}
		System.out.print(out);
	}
}
