package Other;

/*
 * SWEA #4014 활주로 건설
 * 그래프
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4014 {

	static int n, x;
	static int[][] map;
	static int ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder out = new StringBuilder();
		
		int tc = Integer.parseInt(in.readLine());
		for(int t = 1; t <= tc; t++) {
			st = new StringTokenizer(in.readLine());
			n = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			map = new int[n][n];
			ans = 0;
			
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(in.readLine());
				for(int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < n; i++) {
				if(makeBridge1(i)) ans++; // 첫 번째 행 탐색
				if(makeBridge2(i)) ans++; // 첫 번째 열 탐색
			}
			
			out.append("#" + t + " " + ans + "\n");
		}
		System.out.println(out);
	}
	
	public static boolean makeBridge1(int c) {
		int lastSize = map[0][c];
		int cnt = 1;
		boolean ing = false; // 경사로 짓는 중인지 판단
		
		for(int r = 1; r < n; r++) {
			int nowSize = map[r][c];
			if(nowSize != lastSize) { // 높이가 달라졌을 때
				if(nowSize > lastSize) { // 더 높아짐 (경사로를 이미 지었어야 함)
					if(nowSize-lastSize > 1 || ing || cnt < x) {
						return false;
					} else {
						cnt = 1;
					}
				} else { // 더 낮아짐 (이제 경사로를 지어야 함)
					if(lastSize-nowSize > 1 || ing) {
						return false;
					} else {
						cnt = 1;
						ing = true;
					}
				}
			} else { // 높이 그대로일 때
				cnt++;
				if(ing && cnt == x) {
					ing = false;
					cnt = 0;
				}
			}
			lastSize = nowSize;
		}
		
		if(ing) return false;
		else return true;
	}
	
	public static boolean makeBridge2(int r) {
		int lastSize = map[r][0];
		int cnt = 1;
		boolean ing = false; // 경사로 짓는 중인지 판단
		
		for(int c = 1; c < n; c++) {
			int nowSize = map[r][c];
			if(nowSize != lastSize) { // 높이가 달라졌을 때
				if(nowSize > lastSize) { // 더 높아짐 (경사로를 이미 지었어야 함)
					if(nowSize-lastSize > 1 || ing || cnt < x) {
						return false;
					} else {
						cnt = 1;
					}
				} else { // 더 낮아짐 (이제 경사로를 지어야 함)
					if(lastSize-nowSize > 1 || ing) {
						return false;
					} else {
						cnt = 1;
						ing = true;
					}
				}
			} else { // 높이 그대로일 때
				cnt++;
				if(ing && cnt == x) {
					ing = false;
					cnt = 0;
				}
			}
			lastSize = nowSize;
		}
		
		if(ing) return false;
		else return true;
	}
}
