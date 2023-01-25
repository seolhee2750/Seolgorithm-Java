package Graph;

/*
 * BOJ #11779 최소 비용 구하기 2
 * https://www.acmicpc.net/problem/11779
 * 다익스트라
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_11779 {
	
	static class Info implements Comparable<Info> {
		int station;
		int cost;

		public Info(int to, int weight) {
			this.station = to;
			this.cost = weight;
		}

		@Override
		public int compareTo(Info o) {
			return this.cost - o.cost;
		}
	}

	static int n, m;
	static int visited[], route[];
	static int s, e;
	static List<ArrayList<Info>> list;
	static PriorityQueue<Info> que = new PriorityQueue<Info>();
	static Stack<Integer> stack = new Stack<>();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder out = new StringBuilder();
		
		n = Integer.parseInt(in.readLine());
		m = Integer.parseInt(in.readLine());

		visited = new int[n + 1];
		route = new int[n + 1];
		Arrays.fill(visited, Integer.MAX_VALUE);

		list = new ArrayList<>();
		for (int i = 0; i < n + 1; i++) {
			list.add(new ArrayList<Info>());
		}
			
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list.get(a).add(new Info(b, w));
		}
		
		st = new StringTokenizer(in.readLine());
		s = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());

		bfs();
		out.append(visited[e] + "\n");
		stack.push(e);
		while (route[e] != 0) {
			stack.push(route[e]);
			e = route[e];
		}
		out.append(stack.size() + "\n");
		while (!stack.isEmpty()) {
			out.append(stack.pop() + " ");
		}
		System.out.println(out);
	}

	private static void bfs() {
		que.add(new Info(s, 0));
		visited[s] = 0;

		while (!que.isEmpty()) {
			Info info = que.poll();
			int now_station = info.station;
			int now_cost = info.cost;
			
			if (visited[now_station] < now_cost) continue;
			
			for (Info next : list.get(now_station)) {
				int next_cost = visited[now_station] + next.cost;
				if (visited[next.station] <= next_cost) continue;
				
				visited[next.station] = next_cost;
				route[next.station] = now_station;
				que.offer(new Info(next.station, visited[next.station]));
			}
		}
	}
}