package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3109 {

	static int r, c;
	static char[][] map;
	static int[] dx = {-1, 0, 1};
	static int cnt = 0;
	
	public static boolean dfs(int x, int y) {
		if(y == c-1) {
			cnt++;
			return true;
		}
		
		for(int i = 0; i < 3; i++) {
			int nx = x + dx[i];
			int ny = y + 1;
			
			if(nx < 0 || nx >= r || map[nx][ny] == 'x') continue;
			map[nx][ny] = 'x';
			if(dfs(nx, ny)) return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		
		for(int i = 0; i < r; i++) {
			String str = in.readLine();
			for(int j = 0; j < c; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		for(int i = 0; i < r; i++) dfs(i, 0);

		System.out.println(cnt);
	}

}