package Graph;

/**
 * BOJ #10971 외판원 순회2
 * https://www.acmicpc.net/problem/10971
 * DFS
 * 
 * 어디서 출발하든 한 번의 사이클을 만드는 것이므로, 최소 비용은 같을 수 밖에 없음
 * => 출발점은 하나로 고정시킨 후 dfs를 돌려주었음
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10971 {
	
	static int n, ans;
	static int[][] map;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(in.readLine());
		map = new int[n][n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[n];
		visited[0] = true;
		ans = Integer.MAX_VALUE;
		
		dfs(0, 0, n-1);
		
		System.out.println(ans);
	}

	public static void dfs(int start, int cost, int cnt) {
		if(cnt == 0 && map[start][0] != 0) { // 모든 도시를 방문했으며, 다시 출발점으로 갈 수 있을 때
			ans = Math.min(ans, cost + map[start][0]);
			return;
		}
		
		for(int i = 0; i < n; i++) { // 갈 수 있는 모든 도시 탐색
			if(!visited[i] && map[start][i] != 0) {
				visited[i] = true;
				dfs(i, cost + map[start][i], cnt-1);
				visited[i] = false;
			}
		}
	}
}
