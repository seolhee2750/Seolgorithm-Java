package Graph;

/*
 * BOJ #15723 n단 논법
 * https://www.acmicpc.net/problem/15723
 * BFS
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15723 {
	
	static int n, m;
	static char[] alpha = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	static List<Character>[] relation = new ArrayList[26];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder out = new StringBuilder();
		
		for(int i = 0; i < relation.length; i++) {
			relation[i] = new ArrayList<Character>();
		}
		
		n = Integer.parseInt(in.readLine());
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			char a = st.nextToken().charAt(0);
			st.nextToken(); // is
			char b = st.nextToken().charAt(0);
			
			for(int j = 0; j < alpha.length; j++) {
				if(alpha[j] == a) relation[j].add(b);
			}
		}
		
		m = Integer.parseInt(in.readLine());
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());
			char a = st.nextToken().charAt(0);
			st.nextToken(); // is
			char b = st.nextToken().charAt(0);
			
			boolean ans = bfs(a, b);
			if(ans) {
				out.append('T');
				out.append('\n');
			} else {
				out.append('F');
				out.append('\n');
			}	
		}
		System.out.print(out);
	}
	
	public static boolean bfs(char start, char target) {
		Deque<Integer> que = new ArrayDeque<>();
		boolean[] visited = new boolean[26];
		
		for(int i = 0; i < alpha.length; i++) {
			if(alpha[i] == start) {
				que.add(i);
				visited[i] = true;
				break;
			}
		}
		
		while(!que.isEmpty()) {
			int idx = que.poll();
			
			for(int i = 0; i < relation[idx].size(); i++) {
				int next_idx = 0;
				for(int j = 0; j < alpha.length; j++) {
					if(alpha[j] == relation[idx].get(i)) next_idx = j;
				}
				
				if(alpha[next_idx] == target) return true;
				if(relation[next_idx].size() == 0 || visited[next_idx]) continue;
				
				visited[next_idx] = true;
				que.add(next_idx);
			}
		}
		
		return false;
	}
}
