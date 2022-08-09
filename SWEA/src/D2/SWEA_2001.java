package D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2001 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int tc = Integer.parseInt(in.readLine());
		for(int t = 0; t < tc; t++) {
			st = new StringTokenizer(in.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int[][] place = new int[n][n];
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(in.readLine());
				for(int j = 0; j < n; j++) place[i][j] = Integer.parseInt(st.nextToken());
			}
			
			int answer = 0;
			
			for(int i = 0; i < n-m+1; i++) {
				for(int j = 0; j < n-m+1; j++) {
					int tmp = 0;
					for(int k = 0; k < m; k++) {
						for(int g = 0; g < m; g++) tmp += place[i+k][j+g];
					}
					answer = Math.max(answer, tmp);
				}
			}
			
			System.out.printf("#%d %d\n", (t + 1), answer);
		}
	}

}
