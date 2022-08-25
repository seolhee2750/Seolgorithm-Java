package Graph;

/**
 * BOJ #7576 토마토
 * https://www.acmicpc.net/problem/7576
 * BFS
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_7576 {

	static int n, m, cnt, ans;
	static int[][] map, visited;
	static Deque<int[]> que = new ArrayDeque<>();
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	
	public static void bfs() {
		while(!que.isEmpty()) {			
			int[] now = que.removeFirst();
			int x = now[0];
			int y = now[1];
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= n || ny >= m || map[nx][ny] != 0) continue;
				
				map[nx][ny] = map[x][y] + 1; // 익히면서, 여기까지 온 시간 누적
				cnt--; // 안익은 토마토 개수 감소
				if(cnt == 0) return;
				que.add(new int[]{nx, ny});
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) cnt++; // 안익은 토마토 개수 세기
				if(map[i][j] == 1) {
					que.add(new int[]{i, j}); // 익은 토마토 추가
				}
			}
		}
		
		if(cnt == 0) { // 이미 다 익어있으면
			System.out.println(0);
		} else {
			bfs();
			if(cnt > 0) {
				System.out.println(-1);
			} else {
				for(int i = 0; i < n; i++) {
					for(int j = 0; j < m; j++) {
						ans = Math.max(ans, map[i][j]);
					}
				}
				System.out.println(ans-1);
			}
		}
	}
}
