package Graph;

/*
 * BOJ #24479 알고리즘 수업 - 깊이 우선 탐색 2
 * https://www.acmicpc.net/problem/24480
 * dfs
 */

import java.io.*;
import java.util.*;

public class BOJ_24480 {

	static int n, m, r;
	static ArrayList<Integer>[] node;
	static int[] visited;
	static StringBuilder out = new StringBuilder();
	static int cnt = 1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken()) - 1;
		
		visited = new int[n];
		visited[r] = 1;
		
		node = new ArrayList[n];
		for(int i = 0; i < n; i++) {
			node[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			
			node[a].add(b);
			node[b].add(a);
		}
		
		for(int i = 0; i < n; i++) {
			Collections.sort(node[i], Collections.reverseOrder());
		}
		
		dfs(r);
		for(int i = 0; i < n; i++) {
			out.append(visited[i] + "\n");
		}
		System.out.print(out);
	}
	
	public static void dfs(int r) {
		for(int next: node[r]) {
			if(visited[next] > 0) continue;
			visited[next] = ++cnt;
			dfs(next);
		}
	}
}
