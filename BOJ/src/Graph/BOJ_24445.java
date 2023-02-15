package Graph;

/*
 * BOJ #24445 알고리즘 수업 - 너비 우선 탐색 2
 * https://www.acmicpc.net/problem/24445
 * bfs
 */

import java.io.*;
import java.util.*;

public class BOJ_24445 {
	
	static int n, m, r;
	static ArrayList<Integer>[] list;
	static int[] visited;
	static int cnt = 1;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder out = new StringBuilder();
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken()) - 1;
		
		visited = new int[n];
		list = new ArrayList[n];
		for(int i = 0; i < n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			
			list[a].add(b);
			list[b].add(a);
		}
	
		for(int i = 0; i < n; i++) {
			Collections.sort(list[i], Collections.reverseOrder());
		}
		
		bfs(r);
		
		for(int i = 0; i < visited.length; i++) {
			out.append(visited[i] + "\n");
		}
		
		System.out.print(out);
	}
	
	public static void bfs(int r) {
		Deque<Integer> que = new ArrayDeque<>();
		que.add(r);
		visited[r] = cnt++;
		
		while(!que.isEmpty()) {
			int now = que.poll();
			
			for(int i = 0; i < list[now].size(); i++) {
				int next = list[now].get(i);
				
				if(visited[next] > 0) continue;
				
				visited[next] = cnt++;
				que.add(next);
			}
		}
	}
}
