package DP;

/**
 * BOJ #9095 1, 2, 3 더하기
 * https://www.acmicpc.net/problem/9095
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_9095 {

	static StringBuilder out = new StringBuilder();
	static int n;
	
	public static int sum(int n) {
		if(n == 1) return 1;
		else if(n == 2) return 2;
		else if(n == 3) return 4;
		else return sum(n-3) + sum(n-2) + sum(n-1);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(in.readLine());
		for(int t = 0; t < tc; t++) {
			n = Integer.parseInt(in.readLine());
			out.append(sum(n) + "\n");
		}
		System.out.print(out);
	}

}
