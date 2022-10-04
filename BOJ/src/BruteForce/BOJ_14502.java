package BruteForce;

/*
 * BOJ #14502 연구소
 * https://www.acmicpc.net/problem/14502
 * 브루트포스, DFS 문제
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_14502 {

	static int n, m;
	static int[][] map, check;
	static List<int[]> virus;
	static int ans;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	
	public static void dfs(int x, int y, int[][] check) {
		if(check[x][y] == 2) {
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
				
				if(check[nx][ny] == 0) {
					check[nx][ny] = 2;
					dfs(nx, ny, check);
				}
			}
		}
	}
	
	public static void makeWall(int start, int cnt) { // 벽을 세울 수 있는 모든 경우의 수 구하기
		int safeCnt = 0;
		
		if(cnt == 3) { // 세울 3개의 벽의 위치를 모두 정했을 때
			for(int i = 0; i < n; i++) System.arraycopy(map[i], 0, check[i], 0, map[i].length);	// check 원상복귀
			for(int i = 0; i < virus.size(); i++) dfs(virus.get(i)[0], virus.get(i)[1], check); // 바이러스 퍼뜨리기
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(check[i][j] == 0) safeCnt++;
				}
			}
			ans = Math.max(ans, safeCnt);
			return;
		}
		
		for(int i = start; i < n*m; i++) { // map의 모든 자리 탐색
			int x = i / m;
			int y = i % m;
			if(map[x][y] == 0) { // 0 발견 시 바로 벽 세우기
				map[x][y] = 1;
				makeWall(i, cnt+1); // 3개의 벽 세울 때까지 재귀 호출
				map[x][y] = 0;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		check = new int[n][m];
		virus = new ArrayList<>();
		ans = 0;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < m; j++) {
				int now = Integer.parseInt(st.nextToken());
				if(now == 2) virus.add(new int[]{i, j}); // 바이러스 위치 저장
				map[i][j] = now;
				check[i][j] = now;
			}
		}
		
		makeWall(0, 0); // 0, 0부터 탐색 시작
		System.out.println(ans);
	}
}
