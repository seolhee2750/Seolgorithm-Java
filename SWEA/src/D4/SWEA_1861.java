package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class SWEA_1861 {
	
	static boolean[][] visited;
	static int[][] rooms;
	static int min;
	static int cnt;
	static Deque<int[]> que;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static int n;
	
	public static void bfs(int minNum) {
		int count = 1; // 방 개수 (처음 시작 방 포함이므로 1로 초기화)
		
		while(!que.isEmpty()) {
			int[] now = que.removeFirst();
			int x = now[0];
			int y = now[1];
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= n || ny >= n || visited[nx][ny] || Math.abs(rooms[x][y] - rooms[nx][ny]) > 1) continue;
				
				visited[nx][ny] = true;
				minNum = Math.min(minNum, rooms[nx][ny]);
				count++;
				que.add(new int[]{nx, ny});
			}
		}
		
		if(cnt < count) {
			cnt = count;
			min = minNum;
		}
		else if(cnt == count) {
			min = Math.min(min, minNum);
		}
		return;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder out = new StringBuilder();
		
		int tc = Integer.parseInt(in.readLine());
		for(int t = 0; t < tc; t++) {
			n = Integer.parseInt(in.readLine());
			rooms = new int[n][n];
			visited = new boolean[n][n];
			que = new ArrayDeque<>();
			cnt = 0;
			min = Integer.MAX_VALUE;
			
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(in.readLine());
				for(int j = 0; j < n; j++) {
					rooms[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(!visited[i][j]) {
						visited[i][j] = true;
						que.add(new int[]{i, j});
						bfs(rooms[i][j]);
					}
				}
			}
			
			out.append("#" + (t+1) + " " + min + " " + cnt + "\n");
		}
		
		System.out.println(out);
	}
}
