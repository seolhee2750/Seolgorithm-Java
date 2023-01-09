package Graph;

/*
 * BOJ #2644 촌수계산 
 * dfs
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2644 {
	
	static int n, m;
	static int a, b;
	static List<Integer>[] fam;
	static boolean[] visited;
	static int ans = -1;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(in.readLine());
		fam = new ArrayList[n];
		visited = new boolean[n];
		for(int i = 0; i < n; i++) {
			fam[i] = new ArrayList<>();
		}
		
		st = new StringTokenizer(in.readLine());
		a = Integer.parseInt(st.nextToken()) - 1;
		b = Integer.parseInt(st.nextToken()) - 1;
		m = Integer.parseInt(in.readLine());
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			fam[x].add(y);
			fam[y].add(x);
		}
		
		dfs(a, 0);
		System.out.println(ans);
	}
	
	public static void dfs(int start, int cnt) {
		if(start == b) {
			ans = cnt;
			return;
		}
		
		visited[start] = true;
		for(int i = 0; i < fam[start].size(); i++) {
			int next = fam[start].get(i);
			if(visited[next]) continue;
			dfs(next, cnt+1);
		}
	}
}