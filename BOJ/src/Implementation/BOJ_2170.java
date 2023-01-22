package Implementation;

/*
 * BOJ #2170 선 긋기
 * https://www.acmicpc.net/problem/2170
 * 정렬
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2170 {
	
	static int n;
	static PriorityQueue<Line> pq = new PriorityQueue<>();
	static int len;
	
	static class Line implements Comparable<Line> {
		int a;
		int b;
		
		public Line(int a, int b) {
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(Line o) {
			return this.a >= o.a ? 1 : -1;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(in.readLine());
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			pq.add(new Line(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		findLength();
		System.out.println(len);
	}
	
	public static void findLength() {
		Line last = pq.poll();
		int last_a = last.a;
		int last_b = last.b;
		
		while(!pq.isEmpty()) {
			Line now = pq.poll();
			int now_a = now.a;
			int now_b = now.b;
			
			if(now_a <= last_b) { // 현재 시작점이 이전 끝점보다 작거나 같을 때 
				if(now_b <= last_b) continue;
				last_b = now_b;
			} else {
				len += last_b - last_a;
				last_a = now_a;
				last_b = now_b;
			}
		}
		
		len += last_b - last_a;
	}
}
