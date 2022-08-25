package Graph;

/**
 * BOJ #13023 ABCDE
 * https://www.acmicpc.net/problem/13023
 * DFS
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_13023 {

	static int n, m, parents[];
	static boolean result = false;
	static List<Integer>[] graph;
	static boolean[] visited;
	
	public static void dfs(int start, int cnt, boolean[] visited) {
		if(cnt == 5)  {
			result = true;
			return;
		}
		
		visited[start] = true;
		for(int i = 0; i < graph[start].size(); i++) {
			int now = graph[start].get(i);
			if(!visited[now]) {
				visited[now] = true;
				dfs(now, cnt+1, visited);
				visited[now] = false;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[n];
		for(int i = 0; i < n; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		
		for(int i = 0; i < n; i++) {
			dfs(i, 1, visited = new boolean[n]);
			if(result) {
				System.out.println(1);
				return;
			}
		}
		
		System.out.println(0);
	}
}


/*
[도움받은 반례]

12 10
0 1
0 2
0 3
0 4
0 5
6 7
7 8
8 9
9 10
10 11

5 4
0 1
1 2
2 3
3 0
*/