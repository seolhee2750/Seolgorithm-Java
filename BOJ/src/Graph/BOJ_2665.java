package Graph;

/*
 * BOJ #2665 미로만들기
 * https://www.acmicpc.net/problem/2665
 * BFS, 다익스트라 
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ_2665 {

	static int n;
	static int[][] map;
	static int[][] dist;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	
	static class Node {
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(in.readLine());
		map = new int[n][n];
		dist = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			String str = in.readLine();
			for(int j = 0; j < str.length(); j++) {
				map[i][j] = str.charAt(j) - '0';
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		
		bfs();
		System.out.println(dist[n-1][n-1]);
	}
	
	public static void bfs() {
		Deque<Node> que = new ArrayDeque<>();
		que.add(new Node(0, 0));
		dist[0][0] = 0;
		
		while(!que.isEmpty()) {
			Node info = que.poll();
			int x = info.x;
			int y = info.y;
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= n || ny >= n || (map[nx][ny] == 0 && dist[x][y]+1 >= dist[nx][ny]) || (map[nx][ny] != 0 && dist[x][y] >= dist[nx][ny])) continue;
				
				if(map[nx][ny] == 0) {
					dist[nx][ny] = dist[x][y] + 1;
				} else {
					dist[nx][ny] = dist[x][y];
				}
				que.add(new Node(nx, ny));
			}		
		}
	}
}