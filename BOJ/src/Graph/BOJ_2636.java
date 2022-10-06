package Graph;

/*
 * BOJ #2636 치즈
 * https://www.acmicpc.net/problem/2636
 * BFS 문제
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_2636 {

	static int n, m;
	static int[][] map;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static int total, now, before, time; // 총 치즈량, 모두 녹기 한 시간 전 치즈량, 모두 녹는데 걸린 시간
	static Deque<int[]> que;
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		total = 0;
		que = new ArrayDeque<>();
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) total++; // 총 치즈의 양 체크
			}
		}
		
		time = 0;
		while(true) {
			before = total;
			now = 0;
			time++;
			visited = new boolean[n][m];
			que.add(new int[]{0, 0});
			bfs();
			
			total -= now;
			if(total <= 0) {
				System.out.println(time + "\n" + before);
				return;
			}
			initMap();
		}
	}
	
	public static void bfs() {
		while(!que.isEmpty()) {
			int[] q = que.removeFirst();
			int x = q[0];
			int y = q[1];
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny]) continue;
				
				if(map[nx][ny] == 1) {
					map[nx][ny] = -1;
					now++;
				} else if(map[nx][ny] == 0) {
					visited[nx][ny] = true;
					que.add(new int[]{nx, ny});
				}
			}
		}
	}
	
	public static void initMap() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == -1) map[i][j] = 0;
			}
		}
	}
}
