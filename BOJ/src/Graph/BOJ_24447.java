package Graph;

/*
 * BOJ #24447 알고리즘 수업 - 너비 우선 탐색 4
 * https://www.acmicpc.net/problem/24447
 * bfs
 */

import java.io.*;
import java.util.*;

public class BOJ_24447 {
	
	static int n, m, r;
	static ArrayList<Long>[] list;
	static Node[] visited;
	static long cnt = 1;
	static long answer;
	
	static class Node {
		long d;
		long t;
		
		public Node(long d, long t) {
			this.d = d;
			this.t = t;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken()) - 1;
		
		visited = new Node[n];
		Arrays.fill(visited, new Node(-1, 0));
		
		list = new ArrayList[n];
		for(int i = 0; i < n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());
			long a = Long.parseLong(st.nextToken()) - 1;
			long b = Long.parseLong(st.nextToken()) - 1;
			
			list[(int) a].add(b);
			list[(int) b].add(a);
		}
	
		for(int i = 0; i < n; i++) {
			Collections.sort(list[i]);
		}
		
		bfs(r);
		
		for(int i = 0; i < visited.length; i++) {
			answer += (visited[i].d * visited[i].t);
		}
		
		System.out.print(answer);
	}
	
	public static void bfs(int r) {
		Deque<Long> que = new ArrayDeque<>();
		que.add((long) r);
		visited[r] = new Node(0, cnt++);
		
		while(!que.isEmpty()) {
			long now = que.poll();
			
			for(int i = 0; i < list[(int) now].size(); i++) {
				long next = list[(int) now].get(i);
				
				if(visited[(int) next].d > -1) continue;
				
				visited[(int) next] = new Node(visited[(int) now].d + 1, cnt++);
				que.add(next);
			}
		}
	}
}
