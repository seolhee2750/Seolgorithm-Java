package DP;

/*
 * BOJ #12015 가장 긴 증가하는 부분 수열 2
 * https://www.acmicpc.net/problem/12015
 * BS로 풀이
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_12015 {
	
	static List<Integer> lis;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(in.readLine());
		int[] nums = new int[n];
		lis = new ArrayList<>();
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < n; i++) {
			if(lis.isEmpty() || lis.get(lis.size()-1) < nums[i]) lis.add(nums[i]);
			else lis.set(BS(0, lis.size()-1, nums[i]),  nums[i]);
		}
		
		System.out.println(lis.size());
	}
	
	public static int BS(int start, int end, int value) { // 이분 탐색으로 적절한 위치 찾아주기
		int s = start;
		int e = end;
		int m = 0; // 계속 업데이트할 중간 값
		
		while(s < e) {
			m = (s + e) / 2;
			if(value <= lis.get(m)) e = m;
			else s = m + 1;
		}
		
		return s;
	}
}
