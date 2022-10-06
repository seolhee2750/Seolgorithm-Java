package DP;

/*
 * BOJ #14002 가장 긴 증가하는 부분 수열 4
 * https://www.acmicpc.net/problem/14002
 * DP
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_14002 {
	
	static int n, max;
	static int[] nums, lis;
	static Stack<Integer> stack;
	static StringBuilder out = new StringBuilder();
	
	public static void makePermu() { // 완성된 LIS 출력
		stack = new Stack<>();
		for(int i = n-1; i >= 0; i--) {
			if(lis[i] == max) {
				stack.push(nums[i]);
				max--;
			}
		}
		while(!stack.isEmpty()) {
			out.append(stack.pop());
			if(stack.size() > 0) out.append(" ");
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(in.readLine());
		nums = new int[n];
		lis = new int[n];
		max = 1;
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			lis[i] = 1;
			for(int j = 0; j < i; j++) {
				if(nums[j] < nums[i] && lis[j]+1 > lis[i]) {
					lis[i] = lis[j] + 1;
				}
			}
			max = Math.max(max, lis[i]);
		}
		
		out.append(max + "\n");
		makePermu();
		System.out.println(out.toString());
	}
}