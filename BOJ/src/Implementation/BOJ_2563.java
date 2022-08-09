package Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2563 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] paper = new int[100][100];
		int answer = 0;
		int n = Integer.parseInt(in.readLine());
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			for(int x = (100-(10+b)); x < (100-(b)); x++) {
				for(int y = a; y < (a+10); y++) {
					if(paper[x][y] == 0) {
						paper[x][y] = 1;
						answer++;
					}
				}
			}
		}
		
		System.out.println(answer);
	}

}
