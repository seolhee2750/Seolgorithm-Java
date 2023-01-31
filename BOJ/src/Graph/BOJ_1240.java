package Graph;

/*
 * BOJ #1240 노드사이의 거리
 * https://www.acmicpc.net/problem/1240
 * BFS
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_1240 {
	
	static class Info {
		int to;
		int dis;
	
		public Info(int to, int dis) {
			this.to = to;
			this.dis = dis;
		}
	}
	
	static int n, m;
	static ArrayList<Info>[] node;
	static int x, y;
	static Deque<Info> que;
	static boolean[] visited;
	static StringBuilder out = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		node = new ArrayList[n];
		for(int i = 0; i < n; i++) {
			node[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < n-1; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken());
			node[a].add(new Info(b, c));
			node[b].add(new Info(a, c));
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());
			x = Integer.parseInt(st.nextToken()) - 1;
			y = Integer.parseInt(st.nextToken()) - 1;
			bfs();
		}
		
		System.out.print(out);
	}
	
	public static void bfs() {
		que = new ArrayDeque<>();
		visited = new boolean[n];
		
		que.add(new Info(x, 0));
		visited[x] = true;
		
		while(!que.isEmpty()) {
			Info info = que.poll();
			int now_to = info.to;
			int now_dis = info.dis;
			
			if(now_to == y) {
				out.append(now_dis + "\n");
				return;
			}
			
			for(Info next: node[now_to]) {
				if(visited[next.to]) continue;
				que.add(new Info(next.to, next.dis + now_dis));
				visited[next.to] = true;
			}
		}
	}
}
