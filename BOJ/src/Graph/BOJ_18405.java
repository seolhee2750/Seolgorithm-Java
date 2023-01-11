package Graph;

/*
 * BOJ #18405 경쟁적 전염
 * https://www.acmicpc.net/problem/18405
 * BFS
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_18405 {

	static int n, k, s, x, y;
	static Info[][] map;
	static Deque<Info> que = new ArrayDeque<>();
	static int[] da = {-1, 1, 0, 0};
	static int[] db = {0, 0, -1, 1};
	
	static class Info {
		int a;
		int b;
		int num;
		int sec;

		public Info(int a, int b, int num, int sec) {
			this.a = a;
			this.b = b;
			this.num = num;
			this.sec = sec;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new Info[n][n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < n; j++) {
				Info now = new Info(i, j, Integer.parseInt(st.nextToken()), 0);
				if(now.num > 0) {
					map[i][j] = now;
					que.add(now);
				}
			}
		}
		
		st = new StringTokenizer(in.readLine());
		s = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken()) - 1;
		y = Integer.parseInt(st.nextToken()) - 1;
		
		virus();
		
		if(map[x][y] == null) {
			System.out.println(0);
		} else {
			System.out.println(map[x][y].num);
		}
	}
	
	public static void virus() {
		while(!que.isEmpty()) {
			Info now = que.poll();
			int a = now.a;
			int b = now.b;
			int now_num = now.num;
			int now_sec = now.sec;
			
			if(now_sec == s) return;
			
			for(int i = 0; i < 4; i++) {
				int na = a + da[i];
				int nb = b + db[i];
				
				if(na < 0 || nb < 0 || na >= n || nb >= n) continue;
				
				if((map[na][nb] != null && (map[na][nb].sec == now_sec+1 && map[na][nb].num > now_num)) || map[na][nb] == null) {
					map[na][nb] = new Info(na, nb, now_num, now_sec+1);
					que.add(new Info(na, nb, now_num, now_sec+1));
				}
			}
		}
	}

}
