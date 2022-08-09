package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_13913 {
	
	static Deque<int[]> que;
	static boolean[] visited = new boolean[100_001]; // 방문 체크
	static int[] parent = new int[100_001]; // 이전에 어디서 이어진건지 연결을 체크
	static int n, k;
	
	public static int[] bfs() {
		while(!que.isEmpty()) {
			int[] now = que.removeFirst();
			int x = now[0];
			int sec = now[1];
			int[] cal = {x+1, x-1, x*2};
			
			for(int i = 0; i < 3; i++) {
				if(cal[i] == k) {
					visited[cal[i]] = true;
					parent[cal[i]] = x;
					return new int[]{cal[i], sec+1};
				}
				if(cal[i] < 0 || cal[i] >= visited.length || visited[cal[i]]) continue;
				
				que.add(new int[]{cal[i], sec+1});
				visited[cal[i]] = true; // 방문 체크
				parent[cal[i]] = x; // 이전에 어디서 이어진건지 기록해두기
			}
		}
		return new int[]{};
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder out = new StringBuilder();
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		if(n == k) {
			System.out.println(0 + "\n" + n);
		}
		else {
			visited[n] = true;
			parent[n] = n;
			que = new ArrayDeque<>();
			que.add(new int[]{n, 0});
			
			// 거꾸로 탐색하면서 이어진 노드들 stack에 넣었다가 다시 빼면서 출력
			Stack<Integer> stack = new Stack<>();
			int[] result = bfs();
			int idx = result[0];
			while(idx != n) {
				stack.push(parent[idx]);
				idx = parent[idx];
			}
			
			out.append(result[1] + "\n");
			while(!stack.isEmpty()) {
				out.append(stack.pop() + " ");
			}
			System.out.println(out.append(result[0]));
		}
	}

}
