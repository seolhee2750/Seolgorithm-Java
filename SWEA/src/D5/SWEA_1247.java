package D5;

/**
 * SWEA #1247 최적 경로
 * https://swexpertacademy.com/main/talk/solvingClub/problemView.do?contestProbId=AV15OZ4qAPICFAYD&solveclubId=AYHg4cRqHpADFAV6&problemBoxTitle=8%EC%9B%94+3%EC%A3%BC&problemBoxCnt=2&probBoxId=AYKpBZvac3IDFAVG
 * 순열
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1247 {
	
	static int[] start, end, customers[];
	static int n, min;
	
	public static void permu(int nth, int[][] choosed, boolean[] visited) { 
		if(nth == choosed.length) {
			findMin(choosed);
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				
				choosed[nth] = customers[i];
				permu(nth+1, choosed, visited);
				visited[i] = false;
			}
		}
	}
	
	public static void findMin(int[][] choosed) {
		int tmp = 0;
		int[] s = {start[0], start[1]};
		for(int i = 0; i < choosed.length; i++) {
			tmp += Math.abs(s[0] - choosed[i][0]) + Math.abs(s[1] - choosed[i][1]);
			s[0] = choosed[i][0];
			s[1] = choosed[i][1];
		}
		tmp += Math.abs(end[0] - choosed[n-1][0]) + Math.abs(end[1] - choosed[n-1][1]);
		min = Math.min(min, tmp);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder out = new StringBuilder();
		
		int tc = Integer.parseInt(in.readLine());
		for(int t = 1; t <= tc; t++) {
			n = Integer.parseInt(in.readLine());
			start = new int[2];
			end = new int[2];
			customers = new int[n][2];
			st = new StringTokenizer(in.readLine());
			for(int i = 0; i < 2; i++) start[i] = Integer.parseInt(st.nextToken());
			for(int i = 0; i < 2; i++) end[i] = Integer.parseInt(st.nextToken());
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < 2; j++) {
					customers[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			min = Integer.MAX_VALUE;
			permu(0, new int[n][2], new boolean[n]);
			
			out.append("#" + t + " " + min + "\n");
		}
		System.out.print(out);
	}

}
