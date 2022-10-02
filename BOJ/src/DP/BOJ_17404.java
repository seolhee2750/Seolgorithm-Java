package DP;

/*
 * BOJ #17404 RGB 거리 2
 * https://www.acmicpc.net/problem/17404
 * DP
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17404 {
	
	static int n;
	static int[][] r, g, b;
	static int answer = Integer.MAX_VALUE;
	
	public static void first(int red, int green, int blue) {
		for(int i = 0; i < 3; i++) {
			r[0][i] = Integer.MAX_VALUE - 1000;
			g[0][i] = Integer.MAX_VALUE - 1000;
			b[0][i] = Integer.MAX_VALUE - 1000;
		}
		
		r[0][0] = red;
		g[0][1] = green;
		b[0][2] = blue;
	}
	
	public static void middle(int i, int red, int green, int blue) {
		r[i][0] = red + Math.min(r[i-1][1], r[i-1][2]);
		r[i][1] = green + Math.min(r[i-1][0], r[i-1][2]);
		r[i][2] = blue + Math.min(r[i-1][0], r[i-1][1]);
		
		g[i][0] = red + Math.min(g[i-1][1], g[i-1][2]);
		g[i][1] = green + Math.min(g[i-1][0], g[i-1][2]);
		g[i][2] = blue + Math.min(g[i-1][0], g[i-1][1]);
		
		b[i][0] = red + Math.min(b[i-1][1], b[i-1][2]);
		b[i][1] = green + Math.min(b[i-1][0], b[i-1][2]);
		b[i][2] = blue + Math.min(b[i-1][0], b[i-1][1]);
		
		if(i == n-1) findAnswer();
	}
	
	public static void findAnswer() {		
		answer = Math.min(answer, Math.min(r[n-1][1], r[n-1][2]));
		answer = Math.min(answer, Math.min(g[n-1][0], g[n-1][2]));
		answer = Math.min(answer, Math.min(b[n-1][0], b[n-1][1]));
		
		System.out.println(answer);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(in.readLine());
		r = new int[n][3];
		g = new int[n][3];
		b = new int[n][3];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			int red = Integer.parseInt(st.nextToken());
			int green = Integer.parseInt(st.nextToken());
			int blue = Integer.parseInt(st.nextToken());
			
			if(i == 0) { // 첫 번째 집을 각각 빨강, 초록, 파랑으로 픽스해서 생각해주기
				first(red, green, blue);
			} else { // 두 번째 ~ 마지막 집
				middle(i, red, green, blue);
			}
		}
	}
}