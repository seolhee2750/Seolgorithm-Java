package D6;

/*
 * SWEA #1263 사람 네트워크2
 * 플로이드 워셜로 풀이
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1263 {
	
	static int n;
	static int[][] lines; // 인접하는 노드들 담기
	
	public static void floyd() { // 플로이드 워셜
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < n; k++) {
					lines[j][k] = Math.min(lines[j][k], lines[j][i] + lines[i][k]);
				}
			}
		}
	}
	
	public static int findMin() {
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < n; i++) {
			int tmp = 0;
			for(int j = 0; j < n; j++) {
				tmp += lines[i][j];
			}
			min = Math.min(min, tmp);
		}
		return min;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder out = new StringBuilder();
		
		int tc = Integer.parseInt(in.readLine());
		for(int t = 1; t <= tc; t++) {
			st = new StringTokenizer(in.readLine());
			n = Integer.parseInt(st.nextToken());
			lines = new int[n][n];
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					lines[i][j] = Integer.parseInt(st.nextToken());
					if(i != j && lines[i][j] == 0) lines[i][j] = 9999999;
				}
			}
			
			floyd();
			out.append("#" + t + " " + findMin() + "\n");
		}
		System.out.print(out);
	}
}
