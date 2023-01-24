package Graph;

/*
 * BOJ #1916 최소비용 구하기
 * https://www.acmicpc.net/problem/1916
 * 다익스트라
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1916 {

	static int n, m;
	static ArrayList<ArrayList<Info>> list = new ArrayList<>();
	static int s, e;
	static PriorityQueue<Info> que = new PriorityQueue<>();
	static int[] visited;
	
	static class Info implements Comparable<Info> {
		int station;
		int cost;
		
		public Info(int station, int cost) {
			this.station = station;
			this.cost = cost;
		}

		@Override
		public int compareTo(Info o) {
			return this.cost - o.cost;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(in.readLine());
		m = Integer.parseInt(in.readLine());
		for(int i = 0; i < n; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int w = Integer.parseInt(st.nextToken());
			list.get(a).add(new Info(b, w));
		}
		
		st = new StringTokenizer(in.readLine());
		s = Integer.parseInt(st.nextToken()) - 1;
		e = Integer.parseInt(st.nextToken()) - 1;
		
		bfs();
		System.out.println(visited[e]);
	}
	
	public static void bfs() {
		visited = new int[n];
		Arrays.fill(visited, Integer.MAX_VALUE);
		visited[s] = 0;
		que.add(new Info(s, 0));
		
		while(!que.isEmpty()) {
			Info info = que.poll();
			int now_station = info.station;
			int now_cost = info.cost;
			
			if(now_cost > visited[now_station]) continue;
			
			for(Info next: list.get(now_station)) {
				int next_cost = next.cost + now_cost;
				if(visited[next.station] <= next_cost) continue;
				
				visited[next.station] = next_cost;
				que.add(new Info(next.station, next_cost));
			}
		}
	}
}