package Graph;

/**
 * BOJ #1260 DFS와 BFS
 * https://www.acmicpc.net/problem/1260
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_1260 {
	
	static int n, m, v;
	static ArrayList<Integer>[] lines;
	static StringBuilder out = new StringBuilder();
	static boolean[] visited;
	static ArrayList<Integer> dfsResult = new ArrayList<>();
	static ArrayList<Integer> bfsResult = new ArrayList<>();
	static Deque<int[]> que = new ArrayDeque<>();
	
	public static void dfs(int s) {
		for(int i = 0; i < lines[s].size(); i++) {
			int now = lines[s].get(i);
			if(visited[now]) continue;
			else {
				visited[now] = true;
				dfsResult.add(now);
				dfs(now);
			}
		}
	}
	
	public static void bfs() {
		while(!que.isEmpty()) {
			int[] now = que.removeFirst();
			int s = now[0];
			int e = now[1];
			
			if(visited[e]) continue;
			bfsResult.add(e);
			visited[e] = true;
			for(int i = 0; i < lines[e].size(); i++) {
				que.add(new int[]{e, lines[e].get(i)});
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken()) - 1;
		lines = new ArrayList[n];
		for(int i = 0; i < n; i++) {
			lines[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;
			lines[s].add(e);
			lines[e].add(s);
		}
		
		for(int i = 0; i < n; i++) {
			Collections.sort(lines[i]);
		}

		visited = new boolean[n];
		visited[v] = true;
		dfsResult.add(v);
		dfs(v);
		
		for(int i = 0; i < lines[v].size(); i++) que.add(new int[]{v, lines[v].get(i)});
		visited = new boolean[n];
		visited[v] = true;
		bfsResult.add(v);
		bfs();
		
		for(int i = 0; i < dfsResult.size(); i++) {
			if(i == dfsResult.size()-1) out.append((dfsResult.get(i) + 1) + "\n");
			else out.append((dfsResult.get(i) + 1) + " ");
		}
		for(int i = 0; i < bfsResult.size(); i++) {
			if(i == bfsResult.size()-1) out.append((bfsResult.get(i) + 1) + "\n");
			else out.append((bfsResult.get(i) + 1) + " ");
		}
		
		System.out.println(out);
	}

}
