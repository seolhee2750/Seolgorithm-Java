package Graph;

/**
 * BOJ #1697 숨바꼭질
 * https://www.acmicpc.net/problem/1697
 * BFS
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_1697 {
	static Deque<int[]> que;
	static int[] load = new int[100_001];
	static int[] visited = new int[100_001];
	static int n, k;
	
	public static int bfs() {
		while(!que.isEmpty()) {
			int[] now = que.removeFirst();
			int x = now[0];
			int sec = now[1];
			
			int[] cal = {x+1, x-1, x*2};
			
			for(int i = 0; i < 3; i++) {
				if(cal[i] == k) {
					visited[k] = Math.min(visited[k], sec+1);
					continue;
				}
				if(cal[i] < 0 || cal[i] >= load.length || visited[cal[i]] <= sec) continue;

				que.add(new int[]{cal[i], sec+1});
				visited[cal[i]] = sec+1;
			}
		}
		return visited[k];
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());;
		
		if(n == k) System.out.println(0);
		else {
			load = new int[100_001];
			visited = new int[100_001];
			for(int i = 0; i < visited.length; i++) visited[i] = Integer.MAX_VALUE;
			que = new ArrayDeque<>();
			que.add(new int[]{n, 0});
			System.out.println(bfs());
		}		
	}

}
