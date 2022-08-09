package DP;

/**
 * BOJ #11659 구간 합 구하기 4
 * https://www.acmicpc.net/problem/11659
 * 누적합
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 미리 누적합 구한 뒤 구간 찾기
 */

public class BOJ_11659 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] sums = new int[n];
		st = new StringTokenizer(in.readLine());
		sums[0] = Integer.parseInt(st.nextToken());
		for(int i = 1; i < n; i++) {
			sums[i] = sums[i-1] + Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			
			if(x == 0) System.out.println(sums[y]);
			else System.out.println(sums[y] - sums[x-1]);
		}

	}

}
