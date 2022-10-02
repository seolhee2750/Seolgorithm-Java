package DP;

/*
 * BOJ #12852 1로 만들기
 * https://www.acmicpc.net/problem/12852
 * DP
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ_12852 {
	
	static int n, ans;
	static Deque<Integer> nums;
	
	public static void makeOne(int n, int cnt, ArrayDeque<Integer> que) {
		if(cnt >= ans) return;
		if(n == 1) {
			ans = cnt;
			que.add(1);
			nums = que.clone();
			que.removeLast();
			return;
		}
		
		if(n % 3 == 0) {
			que.add(n);
			makeOne(n/3, cnt+1, que);
			que.removeLast();
		}
		if(n % 2 == 0) {
			que.add(n);
			makeOne(n/2, cnt+1, que);
			que.removeLast();
		}
		que.add(n);
		makeOne(n-1, cnt+1, que);
		que.removeLast();
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		
		n =  Integer.parseInt(in.readLine());
		ans = Integer.MAX_VALUE;
		nums = new ArrayDeque<>();
		makeOne(n, 0, new ArrayDeque<Integer>());
		
		out.append(ans + "\n");
		for(int i = 0; i < ans+1; i++) {
			out.append(nums.pollFirst());
			if(i < ans) out.append(" ");
		}
		System.out.println(out);
	}
}