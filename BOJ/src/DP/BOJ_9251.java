package DP;

/**
 * BOJ #9251 LCS
 * https://www.acmicpc.net/problem/9251
 * DP
 * 
 * 입력
 * ACAYKP
 * CAPCAK
 * 
 * memory 배열
 * [0, 0, 0, 0, 0, 0, 0]
 * [0, 0, 1, 1, 1, 1, 1]
 * [0, 1, 1, 1, 2, 2, 2]
 * [0, 1, 2, 2, 2, 3, 3]
 * [0, 1, 2, 2, 2, 3, 3]
 * [0, 1, 2, 2, 2, 3, 4]
 * [0, 1, 2, 3, 3, 3, 4]
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_9251 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String a = in.readLine();
		String b = in.readLine();
		int memory[][] = new int[a.length()+1][b.length()+1];
		
		for(int i = 1; i < a.length()+1; i++) {
			for(int j = 1; j < b.length()+1; j++) {
				if(a.charAt(i-1) == b.charAt(j-1)) memory[i][j] = memory[i-1][j-1] + 1;
				else memory[i][j] = Math.max(memory[i-1][j], memory[i][j-1]);
			}
		}
		
		System.out.println(memory[a.length()][b.length()]);
	}
}