package DP;

/**
 * BOJ #12865 평범한 배낭
 * https://www.acmicpc.net/problem/12865
 * 냅색
 * 
 * 물건마다 가능한 최대 가치를 구해주는 것을 반복하는 방식으로 구현
 * memory[i-1][j]와 memory[i-1][j-w]+v 중 더 큰 값을 골랐음 (현재 물건을 넣는 것이 유리한지, 안넣는 것이 유리한지 판단)
 * 
 * 입력
 * 4 7
 * 6 13
 * 4 8
 * 3 6
 * 5 12
 * 
 * memory
 * [0, 0, 0, 0, 0, 0, 0, 0]
 * [0, 0, 0, 0, 0, 0, 13, 13]
 * [0, 0, 0, 0, 8, 8, 13, 13]
 * [0, 0, 0, 6, 8, 8, 13, 14]
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_12865 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] memory = new int[n+1][k+1];
		
		for(int i = 1; i < n+1; i++) {
			st = new StringTokenizer(in.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			for(int j = 1; j < k+1; j++) {
				if(j >= w) memory[i][j] = Math.max(memory[i-1][j], memory[i-1][j-w] + v);
				else memory[i][j] = memory[i-1][j];
			}
		}
		
		for(int i = 0; i < n; i++) { 
			System.out.println(Arrays.toString(memory[i]));
		}
		System.out.println(memory[n][k]);
	}

}
