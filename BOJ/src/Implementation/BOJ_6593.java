package Implementation;

/**
 * BOJ #6593 상범 빌딩
 * https://www.acmicpc.net/problem/6593
 * BFS
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_6593 {

	static int l, r, c;
	static char[][][] map;
	static int[] start, end;
	static int[] dx = {0, 0, 0, 0, -1, 1};
	static int[] dy = {0, 0, -1, 1, 0, 0};
	static int[] dz = {-1, 1, 0, 0, 0, 0};
	static Deque<int[]> que;
	static int[][][] visited;
	
	public static int bfs() {
		while(!que.isEmpty()) {
			int[] now = que.removeFirst();
			int z = now[0];
			int x = now[1];
			int y = now[2];
			if(map[z][x][y] == 'E') return visited[z][x][y];
			
			for(int i = 0; i < 6; i++) {
				int nz = z + dz[i];
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nz < 0 || nx < 0 || ny < 0 || nz >= l || nx >= r || ny >= c || visited[nz][nx][ny] > 0) continue;
				if(map[nz][nx][ny] == '#') continue;
				
				visited[nz][nx][ny] = visited[z][x][y] + 1;
				que.add(new int[]{nz, nx, ny});			
			}
		}
		return -1;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder out = new StringBuilder();
		
		while(true) {
			st = new StringTokenizer(in.readLine());
			l = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			if(l == 0 && r == 0 && c == 0) break;
			
			map = new char[l][r][c];
			que = new ArrayDeque<>();
			int s_l = 0;
			int s_r = 0;
			int s_c = 0;
			for(int i = 0; i < l; i++) {
				for(int j = 0; j < r; j++) {
					String str = in.readLine();
					for(int k = 0; k < c; k++) {
						map[i][j][k] = str.charAt(k);
						if(str.charAt(k) == 'S') {
							s_l = i;
							s_r = j;
							s_c = k;
							que.add(new int[]{i, j, k});
						}
					}
				}
				in.readLine();
			}			
			
			visited = new int[l][r][c];
			visited[s_l][s_r][s_c] = 1;
			int result = bfs();
			if(result == -1) out.append("Trapped!\n");
			else out.append("Escaped in " + (result - 1) + " minute(s).\n");
		}
		System.out.println(out);
	}

}