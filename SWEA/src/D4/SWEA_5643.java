package D4;

/*
 * SWEA #5643 키 순서
 * 플로이드 워셜
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_5643 {
	
	static int n, m;
	static int[][] lines;
	static int INF = 501;
	static int ans;
	
	public static void floyd() { // 플로이드 워셜
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
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder out = new StringBuilder();
		
		int tc = Integer.parseInt(in.readLine());
		for(int t = 1; t <= tc; t++) {
			n = Integer.parseInt(in.readLine());
			m = Integer.parseInt(in.readLine());
			ans = 0;
			lines = new int[n][n];
			for (int i = 0; i < n; i++) Arrays.fill(lines[i], INF);
				
			for (int i = 0; i < m; i++) { // a학생보다 큰 학생들(b)의 자리에 1을 저장
				st = new StringTokenizer(in.readLine());
				int a = Integer.parseInt(st.nextToken()) - 1;
				int b = Integer.parseInt(st.nextToken()) - 1;
				lines[a][b] = 1;
			}
			
			floyd();
			findAns();
			out.append("#" + t + " " + ans + "\n");
		}
		System.out.print(out);
	}
}
