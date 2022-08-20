package Greedy;

/**
 * BOJ #18310 안테나
 * https://www.acmicpc.net/problem/18310
 * 수학, 그리디
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_18310 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(in.readLine());
		int[] houses = new int[n];
		
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < n; i++) {
			houses[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(houses);
		System.out.println(houses[(n-1)/2]);
	}

}