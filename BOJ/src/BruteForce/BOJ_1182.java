package BruteForce;

/**
 * BOJ #1182 부분수열의 합
 * https://www.acmicpc.net/problem/1182
 * 부분 집합
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1182 {
	
	static int n, s, cnt;
	static int[] nums;
	
	public static void subSet(int nth, boolean[] check) {
		if(nth == check.length) {
			findSum(check);
			return;
		}
		
		check[nth] = true;
		subSet(nth+1, check);
		check[nth] = false;
		subSet(nth+1, check);
	}

	private static void findSum(boolean[] check) {
		int sum = 0;
		boolean isTrue = false; // 공집합일 경우 제외를 위함
		for(int i = 0; i < check.length; i++) {
			if(check[i]) {
				isTrue = true;
				sum += nums[i];
			}
		}
		
		if(isTrue && sum == s) cnt++;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder out = new StringBuilder();
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		
		nums = new int[n];
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		subSet(0, new boolean[n]);
		System.out.println(cnt);
	}

}
