package Greedy;

/**
 * BOJ #1931 회의실 배정
 * https://www.acmicpc.net/problem/1931
 * 그리디
 * 
 * 종료 시간 기준 정렬하고, 회의들을 탐색하면서 마지막 종료시간을 저장하는 lastEnd보다 시작시간이 더 클 경우
 * 카운트를 증가시키고, lastEnd를 현재 회의의 종료 시간으로 업데이트시켜주는 식으로 구현
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1931 {
	
	static class Meetings implements Comparable<Meetings> {
		int s, e;

		public Meetings(int s, int e) {
			super();
			this.s = s;
			this.e = e;
		}

		@Override
		public int compareTo(Meetings o) {
			return this.e != o.e ? this.e - o.e : this.s - o.s; // 종료 시간 기준 정렬, 종료 시간 같을 시 시작 시간 기준 정렬
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
		
		int cnt = 1;
		int lastEnd = meetings[0].e;
		for(int i = 1; i < meetings.length; i++) {
			if(meetings[i].s >= lastEnd) {
				lastEnd = meetings[i].e;
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

}
