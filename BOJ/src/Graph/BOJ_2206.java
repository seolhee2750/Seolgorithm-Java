package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_2206 {
	static int[] dx = {0, 0 ,-1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static Deque<int[]> que;
	static char[][] map;
	static int n;
	static int m;
	static int[][][] visited; // 자리마다 벽을 부수고 왔는지, 안부수고 왔는지를 저장
	
	public static int bfs() {
		while(!que.isEmpty()) {
			int[] now = que.removeFirst();
			int x = now[0];
			int y = now[1];
			int z = now[2];
			
			if(x == n-1 && y == m-1) return visited[x][y][z];
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
				
				if(visited[nx][ny][z] == 0) {
					// 벽이 있는데, 이전까지는 벽을 부수지 않았던 경우 (== 부술 수 있는 경우)
					if(map[nx][ny] == '1' && z == 1) {
						visited[nx][ny][0] = visited[x][y][1] + 1;
						que.add(new int[]{nx, ny, 0});
					}
					// 벽이 아닌 경우
					else if(map[nx][ny] == '0') {
						visited[nx][ny][z] = visited[x][y][z] + 1;
						que.add(new int[]{nx, ny, z});
					}
				}
			}
		}
		
		return -1;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		
		for(int i = 0; i < n; i++) {
			String tmp = in.readLine();
			for(int j = 0; j < m; j++) {
				map[i][j] = tmp.charAt(j);
			}
		}
		
		que = new ArrayDeque<>();
		que.add(new int[]{0, 0, 1}); // {x좌표, y좌표, 벽을 부쉈는지 아닌지} (부순 경우 0, 부수지 않은 경우 1)
		visited = new int[n][m][2];
		visited[0][0][1] = 1; // [][][0]은 부순적 있는 경우, [][][1]은 부순적 없는 경우에 대한 누적 시간을 저장
		
		System.out.println(bfs());
	}

}
