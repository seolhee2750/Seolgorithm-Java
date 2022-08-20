package DP;

/**
 * BOJ #1463 1로 만들기
 * https://www.acmicpc.net/problem/1463
 * DP
 * 재귀를 호춣 할 때, 꼭 3으로 나누는 경우 -> 2로 나누는 경우 -> 1을 빼는 경우 순으로 호출해야 한다!! (시간 초과 방지)
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1463 {
	
	static int n, ans;
	
	public static void makeOne(int n, int cnt) {
		if(cnt >= ans) return;
		if(n == 1) {
			ans = cnt;
			return;
		}
		
		if(n % 3 == 0) makeOne(n/3, cnt+1);
		if(n % 2 == 0) makeOne(n/2, cnt+1);
		makeOne(n-1, cnt+1);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n =  Integer.parseInt(in.readLine());
		ans = Integer.MAX_VALUE;
		makeOne(n, 0);
		System.out.println(ans);
	}
}