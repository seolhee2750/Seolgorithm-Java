package DP;

/**
 * BOJ #2293 동전1
 * https://www.acmicpc.net/problem/2293
 * DP
 * 
 * memory[i] = memory[i-c] 점화식 이용하여 구현
 * 
 * 입력
 * 3 10
 * 1
 * 2
 * 5
 * 
 * memory
 * [1, 1, 2, 2, 3, 4, 5, 6, 7, 8, 10]
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2293 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] coin = new int[n];
		for(int i = 0; i < n; i++) {
			coin[i] = Integer.parseInt(in.readLine());
		}
		
		int[] memory = new int[k+1];
		memory[0] = 1;
		for(int c: coin) {
			for(int i = c; i < k+1; i++) {
				memory[i] += memory[i - c];
			}
		}

		System.out.println(memory[k]);
	}
}
