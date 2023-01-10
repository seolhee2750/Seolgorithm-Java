package Graph;

/*
 * BOJ #5014 스타트링크
 * https://www.acmicpc.net/problem/5014
 * BFS
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_5014 {

	static int f, s, g, u, d;
	static Deque<Info> que;
	static int[] upDown;
	static boolean[] visited;
	
	static class Info {
		int s;
		int cnt;
		
		public Info(int s, int cnt) {
			this.s = s;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		f = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		g = Integer.parseInt(st.nextToken());
		u = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		upDown = new int[]{u, -d};
		visited = new boolean[f+1]; // 층 수 == 인덱스
		
		if(s == g) {
			System.out.println(0);
		} else {
			int ans = bfs();
			if(ans == -1) {
				System.out.println("use the stairs");
			} else {
				System.out.println(ans);
			}
		}
	}
	
	public static int bfs() {
		que = new ArrayDeque<>();
		que.add(new Info(s, 0));
		visited[s] = true;
		
		while(!que.isEmpty()) {
			Info now = que.poll();
			int now_s = now.s;
			int now_cnt = now.cnt;
			
			for(int i = 0; i < 2; i++) {
				int next_s = now_s + upDown[i];
				int next_cnt = now_cnt + 1;
				
				if(next_s < 1 || next_s > f || visited[next_s]) continue;
				if(next_s == g) return next_cnt; // 도착
				
				visited[next_s] = true;
				que.add(new Info(next_s, next_cnt));
			}
		}
		
		return -1;
	}
}
