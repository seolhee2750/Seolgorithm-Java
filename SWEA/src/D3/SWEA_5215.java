package D3;

/**
 * SWEA #5215 햄버거 다이어트
 * https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AYHg4cRqHpADFAV6&contestProbId=AWT-lPB6dHUDFAVT&probBoxId=AYJ7e5KK4AIDFAVG&type=PROBLEM&problemBoxTitle=8%EC%9B%94+2%EC%A3%BC&problemBoxCnt=6
 * 냅색 알고리즘 활용
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5215 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer out = new StringBuffer();
		
		int tc = Integer.parseInt(in.readLine());
		for(int t = 0; t < tc; t++) {
			st = new StringTokenizer(in.readLine());
			int n = Integer.parseInt(st.nextToken()); // 재료 개수
			int l = Integer.parseInt(st.nextToken()); // 제한 칼로리
			int[][] memory = new int[n+1][l+1];
			
			for(int i = 1; i < n+1; i++) {
				st = new StringTokenizer(in.readLine());
				int score = Integer.parseInt(st.nextToken()); // 재료 점수
				int cal = Integer.parseInt(st.nextToken()); // 재료 칼로리
				for(int j = 1; j < l+1; j++) {
					if(cal <= j) memory[i][j] = Math.max(memory[i-1][j], memory[i-1][j-cal]+score);
					else memory[i][j] = memory[i-1][j];
				}			
			}
			out.append("#" + (t+1) + " " + memory[n][l] + "\n");
		}
		System.out.print(out);
	}

}
