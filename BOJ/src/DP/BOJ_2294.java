package DP;

/**
 * BOJ #2294 동전2
 * https://www.acmicpc.net/problem/2294
 * DP
 * 
 * memory[i] = Math.min(memory[i], memory[i - c] + 1); 점화식 이용하여 구현
 * 
 * 입력
 * 3 15
 * 1
 * 5
 * 12
 * 
 * memory
 * [0, 1, 2, 3, 4, 1, 2, 3, 4, 5, 2, 3, 1, 2, 3, 3]
 * 
 * 도움 받은 반례
 * 2 100
 * 7
 * 8
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2294 {

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
		Arrays.fill(memory, 100001);
		memory[0] = 0;
		for(int c: coin) {
			for(int i = c; i < k+1; i++) {
				memory[i] = Math.min(memory[i], memory[i - c] + 1);
			}
		}

		System.out.println(memory[k] == 100001 ? -1 : memory[k]);
	}
}
