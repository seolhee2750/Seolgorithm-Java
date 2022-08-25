package Graph;

/** 
 * BOJ #3055 탈출
 * https://www.acmicpc.net/problem/3055
 * BFS
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_3055 {
	
	static int r, c;
	static char[][] map;
	static int[] start;
	static Deque<int[]> que = new ArrayDeque<>();
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	
	public static int bfs() {
		while(!que.isEmpty()) {
			int[] now = que.removeFirst();
			int x = now[0];
			int y = now[1];
			int check = now[2]; // 물인지 고슴도치인지 판단 (물 == 0, 고슴도치 == 1)
			int cnt = now[3];
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
				if(check == 1 && map[nx][ny] == 'D') {
					return cnt+1;
				}
				if(map[nx][ny] != '.') continue;
				
				if(check == 0) map[nx][ny] = '*';
				if(check == 1) map[nx][ny] = 'S';
				que.add(new int[]{nx, ny, check, cnt+1});
			}
		}
		return -1;
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
				if(map[i][j] == '*') que.add(new int[]{i, j, 0, 0}); // 물의 위치 큐에 추가
				else if(map[i][j] == 'S') start = new int[]{i, j, 1, 0}; // 고슴도치 위치 일단 저장
			}
		}
		que.add(start); // 고슴도치를 물 이동 후 움직이기 위해 마지막에 추가
		
		int ans = bfs();
		System.out.println(ans == -1 ? "KAKTUS" : ans);
	}
}
