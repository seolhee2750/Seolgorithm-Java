package Graph;

/*
 * BOJ #16953 A -> B
 * https://www.acmicpc.net/problem/16953
 * BFS
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_16953 {
	
	static long a, b;
	
	static class Num {
		long a;
		int cnt;
		
		public Num(long a, int cnt) {
			this.a = a;
			this.cnt = cnt;
		}
	}

	public static int bfs() {
		Deque<Num> que = new ArrayDeque<>();
		que.add(new Num(a, 0));
		
		while(!que.isEmpty()) {
			Num num = que.poll();
			long nowA = num.a;
			int nowCnt = num.cnt;
			
			if(nowA == b) return nowCnt+1;
			if(nowA > b) continue;
			
			que.add(new Num(nowA*2, nowCnt+1));
			que.add(new Num(nowA*10+1, nowCnt+1));
		}
		
		return -1;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		a = Long.parseLong(st.nextToken());
		b = Long.parseLong(st.nextToken());
		
		System.out.println(bfs());
	}
}
