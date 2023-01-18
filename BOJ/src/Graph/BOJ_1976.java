package Graph;

/*
 * BOJ #1976 여행 가자
 * https://www.acmicpc.net/problem/1976
 * 그래프
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_1976 {

	static int n, m;
	static int[][] map;
	static int[] travel;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(in.readLine());
		m = Integer.parseInt(in.readLine());
		map = new int[n][n];
		travel = new int[m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < m; i++) {
			travel[i] = Integer.parseInt(st.nextToken()) - 1;
		}
		
		for(int i = 1; i < m; i++) {
			// 출발지와 목적지가 같을 경우 or 탐색해보지 않아도 바로 이어져 있는 경우
			if(travel[i-1] == travel[i] || (map[travel[i-1]][travel[i]] == 1 && map[travel[i]][travel[i-1]] == 1)) continue;
			
			boolean res = findRoute(travel[i-1], travel[i]);
			if(!res) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}
	
	public static boolean findRoute(int start, int end) {
		Deque<Integer> que = new ArrayDeque<>();
		boolean[] visited = new boolean[n];
		visited[start] = true;
		que.add(start);
		
		while(!que.isEmpty()) {
			int s = que.poll();
			
			for(int i = 0; i < n; i++) {
				if(map[s][i] == 1 && !visited[i]) {
					if(i == end) return true;
					que.add(i);
					visited[i] = true;
				}
			}
		}
		
		return false;
	}
}
