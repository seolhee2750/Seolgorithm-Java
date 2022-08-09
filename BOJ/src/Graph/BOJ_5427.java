package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_5427 {
	
	static Deque<int[]> que; // {상근 or 불 여부, sec, x좌표, y좌표} (상근: 0, 불: 1)
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static int h, w;
	static char[][] map;
	
	public static int bfs() {
		while(!que.isEmpty()) {
			int[] now = que.removeFirst();
			int type = now[0];
			int sec = now[1];
			int x = now[2];
			int y = now[3];
			
			findLoop:
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(type == 0) { // 상근이
					if(nx < 0 || ny < 0 || nx >= h || ny >= w) return sec+1; // 탈출 성공
					if(map[nx][ny] != '.') continue findLoop; // 빈 곳 아닐 때
					que.add(new int[]{type, sec+1, nx, ny});
					map[nx][ny] = '@';
				}
				else { // 불
					if(nx < 0 || ny < 0 || nx >= h || ny >= w || map[nx][ny] != '.') continue findLoop;
					que.add(new int[]{type, sec+1, nx, ny});
					map[nx][ny] = '*';
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer out = new StringBuffer();
		
		int tc = Integer.parseInt(in.readLine());
		
		for(int t = 0; t < tc; t++) {
			st = new StringTokenizer(in.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			int[] startPoint = new int[3]; // 상근이 정보 잠시 저장할 용도
			map = new char[h][w];
			que = new ArrayDeque<>();
			
			for(int i = 0; i < h; i++) {
				String tmp = in.readLine();
				for(int j = 0; j < w; j++) {
					map[i][j] = tmp.charAt(j);
					if(tmp.charAt(j) == '*') que.add(new int[]{1, 0, i, j});
					else if(tmp.charAt(j) == '@') startPoint = new int[]{0, 0, i, j};
				}
			}
			que.add(startPoint); // 상근이를 맨 뒤에 추가하기 위함
			
			int result = bfs();
			if(result == -1) System.out.println("IMPOSSIBLE");
			else System.out.println(result);
		}
	}

}
