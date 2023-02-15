package Graph;

/*
 * BOJ #24481 알고리즘 수업 - 깊이 우선 탐색 3
 * https://www.acmicpc.net/problem/24481
 * dfs
 */

import java.io.*;
import java.util.*;

public class BOJ_24481 {
	
	static int n, m, r;
	static ArrayList<Integer>[] list;
	static int[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder out = new StringBuilder();
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken()) - 1;
		
		visited = new int[n];
		Arrays.fill(visited, -1);
		
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
			Collections.sort(list[i]);
		}
		
		visited[r] = 0;
		dfs(r);
		
		for(int i = 0; i < visited.length; i++) {
			out.append(visited[i] + "\n");
		}
		System.out.print(out);
	}
	
	public static void dfs(int r) {
		for(int i = 0; i < list[r].size(); i++) {
			int idx = list[r].get(i);
			if(visited[idx] > -1) continue;
			visited[idx] = visited[r] + 1;
			dfs(idx);
		}
	}
}
