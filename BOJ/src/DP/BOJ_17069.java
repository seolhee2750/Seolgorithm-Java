package DP;

/*
 * BOJ #17069 파이프 옮기기 2
 * https://www.acmicpc.net/problem/17069
 * DP
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17069 {

	static int n;
	static int[][] map;
	static long[][][] memo; // 가장 하위 인덱스 0, 1, 2 == 가로, 세로, 대각선
	
	public static long dp() {
		for(int i = 1; i < n+1; i++) {
			for(int j = 3; j < n+1; j++) {
				if(map[i][j] == 1) continue; // 벽이면 어떤 파이프도 불가하므로 continue
				memo[i][j][0] = memo[i][j-1][0] + memo[i][j-1][2]; // 가로
				if(i == 1) continue; // 첫 번째 줄일 경우, 세로가 절대 불가능하기 때문에 continue
				memo[i][j][1] = memo[i-1][j][1] + memo[i-1][j][2]; // 세로
				if(map[i-1][j] == 1 || map[i][j-1] == 1) continue; // 대각선으로 오려면 위, 아래도 모두 빈 칸이어야 하므로 continue
				memo[i][j][2] = memo[i-1][j-1][0] + memo[i-1][j-1][1] + memo[i-1][j-1][2]; // 대각선
			}
		}
		
		return memo[n][n][0] + memo[n][n][1] + memo[n][n][2];
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(in.readLine());
		map = new int[n+1][n+1];
		for(int i = 1; i < n+1; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 1; j < n+1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		memo = new long[n+1][n+1][3];
		memo[1][2][0] = 1;
		if(map[n][n] == 1) {
			System.out.println(0);
		} else {
			System.out.println(dp());
		}
	}
}