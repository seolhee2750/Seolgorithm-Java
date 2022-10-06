package Graph;

/*
 * BOJ #1194 달이 차오른다, 가자.
 * https://www.acmicpc.net/problem/1194
 * BFS, 비트마스킹
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_1194 {

	static class Node {
		int x;
		int y;
		int key;
		int cnt;
		
		public Node(int x, int y, int key, int cnt) {
			this.x = x;
			this.y = y;
			this.key = key;
			this.cnt = cnt;
		}
	}
	
	static int n, m;
	static char[][] map;
	static boolean[][][] visited;
	static Deque<Node> que;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		visited = new boolean[64][n][m];
		que = new ArrayDeque<>();
		
		for(int i = 0; i < n; i++) {
			String str = in.readLine();
			for(int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == '0') { // 시작점 체크
					que.add(new Node(i, j, 0, 0));
					visited[0][i][j] = true;
				}
			}
		}
		
		System.out.println(bfs());
	}
	
	public static int bfs() {
		while(!que.isEmpty()) {
			Node node = que.removeFirst();
			int x = node.x;
			int y = node.y;
			int key = node.key;
			int cnt = node.cnt;
			if(map[x][y] == '1') return cnt;
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= n || ny >= m || map[nx][ny] == '#' || visited[key][nx][ny]) continue;
				
				char now = map[nx][ny];
				if(now == '.' || now == '0' || now == '1') { // 지나갈 수 있는 곳
					visited[key][nx][ny] = true;
					que.add(new Node(nx, ny, key, cnt+1));
				} else if(now >= 'a' && now <= 'f') { // 열쇠
					int nKey = (1 << (now - 'a')) | key; // 열쇠 추가
					visited[key][nx][ny] = true;
					que.add(new Node(nx, ny, nKey, cnt+1));
				} else if(now >= 'A' && now <= 'F') { // 문
					if((key & (1 << (now - 'A'))) > 0) { // 이 문에 해당하는 열쇠 있을 때
						visited[key][nx][ny] = true;
						que.add(new Node(nx, ny, key, cnt+1));
					}
				}
			}
		}
		
		return -1;
	}
}
