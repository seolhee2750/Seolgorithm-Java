package Greedy;

/**
 * BOJ #19598 최소 회의실 개수
 * https://www.acmicpc.net/problem/19598
 * 그리디
 * 
 * 시작 시간 기준으로 정렬, 첫 번째 회의부터 차례대로 끝나는 시간을 PriorityQueue인 endTimes에 넣어주었음
 * 첫 번째 회의는 비교 대상이 없으니 그냥 넣어주었고, 
 * 두 번째 회의부터는 endTimes의 첫 번째 끝나는 시간과 비교하여서 넣어주었음
 * 현재 회의의 시작시간이 endTimes 첫 번째 끝나는 시간과 같거나 느리다면, 한 회의실을 사용할 수 있는 것이므로
 * endTimes의 첫 번째 회의를 꺼내주고, 현재 회의의 끝나는 시간을 대신해서 넣어주었다. (== 해당 회의실의 끝나는 시간 업데이트)
 * => 모든 회의 탐색을 끝낸 후 완성된 endTimes의 size가 총 회의실의 개수가 됨
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_19598 {
	
	static class Meetings implements Comparable<Meetings> {
		int s, e;

		public Meetings(int s, int e) {
			super();
			this.s = s;
			this.e = e;
		}

		@Override
		public int compareTo(Meetings o) {
			return this.s - o.s; // 시작 시간 기준 정렬
		}	
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(in.readLine());
		Meetings[] meetings = new Meetings[n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			meetings[i] = new Meetings(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(meetings);
		
		PriorityQueue<Integer> endTimes = new PriorityQueue<>();
		endTimes.add(meetings[0].e);
		for(int i = 1; i < meetings.length; i++) {
			if(endTimes.peek() <= meetings[i].s) {
				endTimes.poll();
			}
			endTimes.add(meetings[i].e);
		}
		
		System.out.println(endTimes.size());
	}
}
