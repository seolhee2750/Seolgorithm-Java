package DP;

/*
 * BOJ #12015 가장 긴 증가하는 부분 수열 3
 * https://www.acmicpc.net/problem/12738
 * BS로 풀이 - Arrays.binarySearch 이용
 * 
 * List로 했을 때 시간초과 발생했음
 * binarySearch 부분에서 List 형태인 lis를 계속 array로 변환해주는데, 그 부분이 문제였던 것으로 보임
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_12738 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[] nums = new int[n];
		int[] lis = new int[n];

		StringTokenizer tokens = new StringTokenizer(in.readLine());
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(tokens.nextToken());
		}

		int size = 0;
		for (int i = 0; i < n; i++) {
			int pos = Arrays.binarySearch(lis, 0, size, nums[i]);
			if (pos >= 0) continue;
			
			lis[Math.abs(pos) - 1] = nums[i];
			if(Math.abs(pos) - 1 == size) size++;
		}
		System.out.println(size);
	}
}
