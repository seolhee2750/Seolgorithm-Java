package Graph;

/*
 * BOJ #5972 택배 배송
 * https://www.acmicpc.net/problem/5972
 * 다익스트라
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_5972 {
	
	static class Node implements Comparable<Node> {
		int to; // 도착지
		int cow; // 도착지까지 존재하는 소의 마리 수
		
		public Node(int to, int cow) {
			this.to = to;
			this.cow = cow;
		}

		@Override
		public int compareTo(Node o) {
			return this.cow - o.cow;
		}
	}

	static int n, m;
	static ArrayList<ArrayList<Node>> list;
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
		
		list = new ArrayList<>();
		for(int i = 0; i < n+1; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 1; i < m+1; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list.get(a).add(new Node(b, c));
			list.get(b).add(new Node(a, c));
		}
		
		bfs();
		System.out.println(visited[n]);
	}
	
	public static void bfs() {
		que.add(new Node(1, 0));
		visited[1] = 0;
		
		while(!que.isEmpty()) {
			Node node = que.poll();
			int now_to = node.to;
			int now_cow = node.cow;
			
			if(visited[now_to] < now_cow) continue;
			
			// now_to가 갈 수 있는 모든 도착지들을 탐색
			for(Node next: list.get(now_to)) {
				int next_to = next.to;
				int next_cow = next.cow;
				int sum = now_cow + next_cow;
				
				if(visited[next.to] <= sum) continue;
				
				visited[next.to] = sum;
				que.add(new Node(next_to, sum));
			}
		}
	}
}
