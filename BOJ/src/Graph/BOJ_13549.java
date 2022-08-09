package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_13549 {
	static Deque<int[]> que;
	static int[] visited = new int[100_001];
	static int n, k;
	
	public static int bfs() {
		while(!que.isEmpty()) {
			int[] now = que.removeFirst();
			int x = now[0];
			int sec = now[1];
			int[] cal = {x+1, x-1, x*2};
			
			for(int i = 0; i < 3; i++) {
				if(cal[i] == k) { // 동생 찾으면 동생 위치의 visited 최솟값 갱신
					if(i == 2) visited[k] = Math.min(visited[k], sec);
					else visited[k] = Math.min(visited[k], sec+1);
					continue;
				}
				if(cal[i] < 0 || cal[i] >= visited.length || visited[cal[i]] <= sec) continue;
				
				if(i == 2) { // 순간이동 하는 경우 초 증가x
					que.add(new int[]{cal[i], sec});
					visited[cal[i]] = sec;
				}
				else { // 걸어갈 땐 1초 증가
					que.add(new int[]{cal[i], sec+1});
					visited[cal[i]] = sec+1;
				}
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
			for(int i = 0; i < visited.length; i++) visited[i] = Integer.MAX_VALUE;
			que = new ArrayDeque<>();
			que.add(new int[]{n, 0});
			
			System.out.println(bfs());
		}		
	}

}
