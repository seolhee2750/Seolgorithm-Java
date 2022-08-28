package Greedy;

/**
 * BOJ #4458 녹색 옷 입은 애가 젤다지?
 * https://www.acmicpc.net/problem/4485
 * 다익스트라
 * 
 * 그냥 비교하는 것보다 PriorityQueue 쓰는게 훨씬 빠르고,
 * PriorityQueue에서 람다식으로 가중치 기준 정렬하는 것보다 Node 클래스에서 Comparable 이용하여 정렬하는게 훨씬 빠름
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_4485 {
	
	static class Node implements Comparable<Node> {
		int x;
		int y;
		int w;
		
		public Node(int x, int y, int w) {
			this.x = x;
			this.y = y;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.w, o.w);
		}
	}

	static int n, idx;
	static int[][] map;
	static int[][] dis;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	
	public static void Dijk() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(0, 0, map[0][0])); // x, y, w
		dis[0][0] = map[0][0];
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			int x = now.x;
			int y = now.y;
			int w = now.w;
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= n || ny >= n || dis[nx][ny] <= map[nx][ny] + w) continue;
				
				dis[nx][ny] = map[nx][ny] + w;
				pq.add(new Node(nx, ny, dis[nx][ny]));
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder out = new StringBuilder();
		
		while(true) {
			idx++;
			n = Integer.parseInt(in.readLine());
			if(n == 0) break;
			
			map = new int[n][n];
			dis = new int[n][n];
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(in.readLine());
				for(int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					dis[i][j] = Integer.MAX_VALUE;
				}
			}
			
			Dijk();
			out.append("Problem " + idx + ": " + dis[n-1][n-1] + "\n");
		}
		
		System.out.print(out);
	}
}
