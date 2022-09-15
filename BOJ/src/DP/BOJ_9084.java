package DP;

/**
 * BOJ #9084 동전
 * DP
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9084 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder out = new StringBuilder();
		
		int tc = Integer.parseInt(in.readLine());
		for(int t = 0; t < tc; t++) {
			int n = Integer.parseInt(in.readLine());
			int[] coins = new int[n];
			st = new StringTokenizer(in.readLine());
			for(int i = 0; i < n; i++) {
				coins[i] = Integer.parseInt(st.nextToken());
			}
			int m = Integer.parseInt(in.readLine());
			
			int[] memory = new int[m+1];
			memory[0] = 1;
			
			for(int i = 0; i < n; i++) {
				for(int j = coins[i]; j < m+1; j++) {
					memory[j] += memory[j - coins[i]];
				}
			}
			
			out.append(memory[m] + "\n");
		}
		
		System.out.print(out);
	}
}
