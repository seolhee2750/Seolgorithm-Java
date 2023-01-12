package Graph;

/*
 * BOJ #2598 보물섬
 * https://www.acmicpc.net/problem/2589
 * BFS
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_2598 {

	static int n, m;
	static int[][] map;
	static int ans = 0;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static class Info {
		int x;
		int y;
		int sec;
		
		public Info(int x, int y, int sec) {
			this.x = x;
			this.y = y;
			this.sec = sec;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			String str = in.readLine();
			for(int j = 0; j < m; j++) {
				if(str.charAt(j) == 'W') { // 바다 
					map[i][j] = 0;
				} else { // 육지 
					map[i][j] = 1;
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == 1) {
					bfs(new Info(i, j, 0));
				}
			}
		}
		
		System.out.println(ans);
	}
	
	public static void bfs(Info info) {
		Deque<Info> que = new ArrayDeque<>();
		boolean[][] visited = new boolean[n][m];
		
		que.add(info);
		visited[info.x][info.y] = true;
		
		while(!que.isEmpty()) {
			Info now_info = que.poll();
			int now_x = now_info.x;
			int now_y = now_info.y;
			int next_sec = now_info.sec + 1;
			
			for(int i = 0; i < 4; i++) {
				int nx = now_x + dx[i];
				int ny = now_y + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny] || map[nx][ny] == 0) continue;
				
				visited[nx][ny] = true;
				que.add(new Info(nx, ny, next_sec));
				if(ans < next_sec) ans = next_sec;
			}
		}
	}
}