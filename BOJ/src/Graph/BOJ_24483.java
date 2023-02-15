package Graph;

/*
 * BOJ #24483 알고리즘 수업 - 깊이 우선 탐색 5
 * https://www.acmicpc.net/problem/24483
 * dfs
 */

import java.io.*;
import java.util.*;

public class BOJ_24483 {
	
	static int n, m, r;
	static ArrayList<Long>[] list;
	static Node[] visited;
	static long cnt = 1;
	static long answer;
	
	static class Node {
		long d; // 깊이
		long t; // 순서
		
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
		
		visited[r] = new Node(0, cnt++); // 시작점의 깊이는 0, 방문 순서는 1
		dfs(r);
		
		for(int i = 0; i < visited.length; i++) {
			// System.out.println("d : " + visited[i].d + " t : " + visited[i].t);
			answer += (visited[i].d * visited[i].t);
		}
		System.out.print(answer);
	}
	
	public static void dfs(int r) {
		for(int i = 0; i < list[r].size(); i++) {
			long idx = list[r].get(i);
			if(visited[(int) idx].d > -1) continue;
			Node now = new Node(visited[r].d + 1, cnt++);
			visited[(int) idx] = now;
			dfs((int) idx);
		}
	}
}
