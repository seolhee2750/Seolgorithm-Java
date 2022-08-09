package DP;

/**
 * BOJ #11659 구간 합 구하기 4
 * https://www.acmicpc.net/problem/11659
 * 누적합, DP
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11660 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] sums_flat = new int[n][n];
		int[][] sums = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < n; j++) {
				int now = Integer.parseInt(st.nextToken());
				if(i == 0) {
					if(j == 0) {
						sums_flat[0][0] = now;
						sums[0][0] = now;
					}
					else {
						sums_flat[0][j] = sums[0][j-1] + now;
						sums[0][j] = sums_flat[0][j];
					}
				}
				else {
					if(j == 0) {
						sums_flat[i][0] = now;
						sums[i][0] = sums_flat[i][0] + sums[i-1][0];
					}
					else {
						sums_flat[i][j] = sums_flat[i][j-1] + now;
						sums[i][j] = sums_flat[i][j] + sums[i-1][j];
					}
				}
			}
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());
			int x1 = Integer.parseInt(st.nextToken()) - 1;
			int y1 = Integer.parseInt(st.nextToken()) - 1;
			int x2 = Integer.parseInt(st.nextToken()) - 1;
			int y2 = Integer.parseInt(st.nextToken()) - 1;
			
			int answer = 0;
			if(x1 == 0 && y1 == 0) answer = sums[x2][y2];
			else if(x1 == 0 && y1 != 0) answer = sums[x2][y2] - sums[x2][y1-1];
			else if(x1 != 0 && y1 == 0) answer = sums[x2][y2] - sums[x1-1][y2];
			else answer = sums[x2][y2] - (sums[x2][y1-1] + sums[x1-1][y2] - sums[x1-1][y1-1]);
			System.out.println(answer);
		}
	}

}
