package DP;

/**
 * BOJ #1010 다리 놓기
 * https://www.acmicpc.net/problem/1010
 * DP
 * 다리의 개수에 따른 규칙을 구하여 풀이했음
 * 1. n이 1일 때는 m의 개수만큼의 경우의 수 가짐
 * 2. n과 m이 같을 때 경우의 수는 딱 하나
 * 3. 그 외의 경우는 (n-1, m-1)일 때와 (n, m-1)일 때의 경우의 수를 합한 것과 같음
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1010 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder out = new StringBuilder();
		
		int[][] dp = new int[31][31];
		for(int i = 1; i < 31; i++) {
			for(int j = 1; j < 31; j++) {
				if(i == 1) dp[i][j] = j;
				else if(i == j) dp[i][j] = 1;
				else if(i < j) dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
			}
		}
		
		int tc = Integer.parseInt(in.readLine());
		for(int t = 0; t < tc; t++) {
			st = new StringTokenizer(in.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			out.append(dp[n][m]);
			if(t < tc-1) out.append("\n");
		}
		
		System.out.println(out);
	}

}
