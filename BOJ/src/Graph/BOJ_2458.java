package Graph;

/*
 * BOJ #2458 키 순서
 * https://www.acmicpc.net/problem/2458
 * 플로이드 워샬
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2458 {
	
	static int n, m;
	static int[][] lines;
	static int INF = 501;
	static int ans;
	
	public static void floyd() { // 플로이드 와샬
		for (int k = 0; k < n; k++) { // 경유
			for (int i = 0; i < n; i++) { // 출발
				for (int j = 0; j < n; j++) { // 도착
					lines[i][j] = Math.min(lines[i][j], lines[i][k] + lines[k][j]);
				}
			}
		}
	}
	
	public static void findAns() { // 답 찾기
		for (int i = 0; i < n; i++) {
			boolean check = true;
			for (int j = 0; j < n; j++) {
				if (i == j || lines[i][j] != INF || lines[j][i] != INF) continue;
				check = false;
				break;
			}
			if(check) ans++;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		ans = 0;
		lines = new int[n][n];
		for (int i = 0; i < n; i++) Arrays.fill(lines[i], INF);
			
		for (int i = 0; i < m; i++) { // a학생보다 큰 학생들(b)의 자리에 1을 저장
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			lines[a][b] = 1;
		}
		
		floyd();
		findAns();
		System.out.println(ans);
	}
}
