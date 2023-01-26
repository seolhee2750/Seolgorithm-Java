package Graph;

/*
 * BOJ #14284 간선 이어가기 2
 * https://www.acmicpc.net/problem/14284
 * 다익스트라
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_14284 {

	static class Node implements Comparable<Node> {
		int to;
		int weight;
		
		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.to - o.to;
		}
	}
	
	static int n, m;
	static int s, e;
	static ArrayList<Node>[] list;
	static PriorityQueue<Node> que = new PriorityQueue<>();
	static int[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		visited = new int[n+1];
		Arrays.fill(visited, Integer.MAX_VALUE);
		
		list = new ArrayList[n+1];
		for(int i = 1; i < n+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 1; i < m+1; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list[a].add(new Node(b, c));
			list[b].add(new Node(a, c));
		}
		
		st = new StringTokenizer(in.readLine());
		s = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		bfs();
		System.out.println(visited[e]);
	}
	
	public static void bfs() {
		que.add(new Node(s, 0));
		visited[s] = 0;
		
		while(!que.isEmpty()) {
			Node node = que.poll();
			int now_to = node.to;
			int now_weight = node.weight;
			
			if(visited[now_to] < now_weight) continue;
			
			for(Node next: list[now_to]) {
				int next_to = next.to;
				int next_weight = next.weight;
				int sum = now_weight + next_weight;
				
				if(visited[next_to] <= sum) continue;
				
				visited[next_to] = sum;
				que.add(new Node(next_to, sum));
			}
		}
	}
}
