package Graph;

/**
 * BOJ #1600 말이 되고픈 원숭이
 * BFS 문제
 * 나는 DP 느낌으로 풀었는데,, 자꾸 틀림
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_1600 {

	static int k, r, c;
	static int[][] map;
	static int[][][] visited;
	static Deque<int[]> que = new ArrayDeque<>();
	static int[] dx = {0, 0, -1, 1, 2, 2, -2, -2, 1, 1, -1, -1};
	static int[] dy = {-1, 1, 0, 0, -1, 1, -1, 1, -2, 2, -2, 2};
	
	public static void bfs() {
		visited = new int[r][c][2];
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				Arrays.fill(visited[i][j], Integer.MAX_VALUE);
			}
		}
		visited[0][0][0] = 0;
		visited[0][0][1] = 0;
		
		que.add(new int[]{0, 0, 0, 0});
		que.add(new int[]{0, 0, 1, 0});
		
		while(!que.isEmpty()) {
			int[] now = que.poll();
			int x = now[0];
			int y = now[1];
			int check = now[2]; // check가 0이면 상하좌우 이동, 1이면 나이트 이동을 해서 여기로 왔다는 뜻
			int horse = now[3];
			
			for(int i = 0; i < 12; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= r || ny >= c || map[nx][ny] == 1) continue;
				
				if(i < 4) { // 상하좌우 이동
					if(check == 0 && visited[nx][ny][0] > visited[x][y][0] + 1) {
						visited[nx][ny][0] = visited[x][y][0] + 1;
						que.add(new int[]{nx, ny, 0, horse});
					} else if(check == 1 && visited[nx][ny][0] > visited[x][y][1] + 1) {
						visited[nx][ny][0] = visited[x][y][1] + 1;
						que.add(new int[]{nx, ny, 0, horse});
					}
				} else if(i >= 4 && horse < k) { // 나이트 이동
					if(check == 0 && visited[nx][ny][1] > visited[x][y][0] + 1) {
						visited[nx][ny][1] = visited[x][y][0] + 1;
						que.add(new int[]{nx, ny, 1, horse+1});
					} else if(check == 1 && visited[nx][ny][1] > visited[x][y][1] + 1) {
						visited[nx][ny][1] = visited[x][y][1] + 1;
						que.add(new int[]{nx, ny, 1, horse+1});
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		k = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine());
		c = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		map = new int[r][c];
		for(int i = 0; i < r; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < c; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
		if(visited[r-1][c-1][0] == Integer.MAX_VALUE && visited[r-1][c-1][1] == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(Math.min(visited[r-1][c-1][0], visited[r-1][c-1][1]));
	}

}


