package Graph;

/*
 *  BOJ #16234 인구 이동
 *  BFS
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_16234 {
	
	static int n, l, r;
	static int[][] map, visited;
	static int cnt, sum; // 현재 연합의 나라 개수, 현재 연합의 총 인구수
	static int teams, day; // 하루에 해당하는 연합의 개수, 날짜 카운트
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static Deque<int[]> que = new ArrayDeque<>();
	
	public static void bfs(int i, int j) { // 연합 찾기 (연합을 이루는 나라는 visited에 1로 표시)
		while(!que.isEmpty()) {
			int[] now = que.removeFirst();
			int x = now[0];
			int y = now[1];
			
			for(int a = 0; a < 4; a++) {
				int nx = x + dx[a];
				int ny = y + dy[a];
				
				if(nx < 0 || ny < 0 || nx >= n || ny >= n || visited[nx][ny] != 0) continue; // 범위를 벗어나거나 이미 방문한적 있는 곳일 떼
				if(Math.abs(map[x][y] - map[nx][ny]) < l || Math.abs(map[x][y] - map[nx][ny]) > r) continue; // 인구 차가 기준에 벗어날 때
				
				visited[nx][ny] = 1;
				sum += map[nx][ny];
				cnt++;
				que.add(new int[]{nx, ny});
			}
		}
		
		visited[i][j] = -1; // 시작점 방문 체크만 남겨놓기
		if(cnt > 1) { // 연합이 이루어졌을 떄
			teams++; // 연합 하나 발견했음을 표시
			map[i][j] = sum /cnt; // 시작점만 먼저 인구 이동 시켜주기
			que.add(new int[]{i, j});
			update(map[i][j]);
		}
	}
	
	public static void update(int popul) { // 인구 이동시켜주면서, 인구 이동을 마친 나라의 visited는 -1로 바꿔주기
		while(!que.isEmpty()) {
			int[] now = que.removeFirst();
			int x = now[0];
			int y = now[1];
			
			for(int a = 0; a < 4; a++) {
				int nx = x + dx[a];
				int ny = y + dy[a];
				
				if(nx < 0 || ny < 0 || nx >= n || ny >= n || visited[nx][ny] != 1) continue; // 범위를 벗어나거나 현재 찾는 연합이 아닐 때
				
				map[nx][ny] = popul; // 인구이동
				visited[nx][ny] = -1; // 인구이동을 마친 연합임을 표시
				que.add(new int[]{nx, ny});
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		visited = new int[n][n];
		day = 0;
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(true) { // 한 번의 while 반복 == 하루
			teams = 0;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(visited[i][j] == 0) {
						que.add(new int[]{i, j});
						cnt = 1;
						sum = map[i][j];
						visited[i][j] = 1;
						bfs(i, j);
					}
				}
			}
			if(teams == 0) { // 연합이 하나도 없을 때
				System.out.println(day);
				return;
			}
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					visited[i][j] = 0;
				}
			}
			
			day++;
		}
	}
}
