package BruteForce;

/*
 * BOJ #2961 도영이가 만든 맛있는 음식
 * https://www.acmicpc.net/problem/2961
 * 조합으로 풀이 !
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2961 {

	static int n;
	static int[][] taste;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;
	
	public static void select(int cnt) {
		int a = 1; // 신맛 연산을 위함
		int b = 0; // 쓴맛 연산을 위함
		if(cnt == n) {
			for(int i = 0; i < n; i++) {
				if(visited[i]) {
					a *= taste[i][0];
					b += taste[i][1];
				}
			}
			if(a > 1 && b > 0) min = Math.min(min, Math.abs(a-b));
			return;
		}
		
		visited[cnt] = true; // 현재 재료 선택
		select(cnt+1);
		visited[cnt] = false; // 현재 재료 선택안함
		select(cnt+1);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(in.readLine());
		taste = new int[n][2];
		visited = new boolean[n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			taste[i][0] = Integer.parseInt(st.nextToken());
			taste[i][1] = Integer.parseInt(st.nextToken());
		}
		
		select(0);
		System.out.println(min);
	}

}
