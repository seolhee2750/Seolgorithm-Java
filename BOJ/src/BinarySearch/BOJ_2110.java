package BinarySearch;

/*
 * BOJ #2110 공유기 설치
 * https://www.acmicpc.net/problem/2110
 * 이분 탐색
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
 
public class BOJ_2110 {
	
	public static int n, m;
	public static int[] map;
	public static int min, max;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
				
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n];
		
		for(int i = 0; i < n; i++) {
			map[i] = Integer.parseInt(in.readLine());
		}
		Arrays.sort(map);
		
		min = 1; // 가능한 가장 짧은 거리
		max = map[n-1] - map[0] + 1; // 가능한 가장 긴 거리
		
		makeDis();
		System.out.println(min - 1);
	}
	
	public static void makeDis() {
		while(min < max) {
			int mid = (min + max) / 2;
			
			if(find(mid) < m) {
				max = mid;
			} else {
				min = mid + 1;
			}
		}
	}
	
	public static int find(int dis) {
		int count = 1; // 첫 번째 집은 무조건 설치
		int last = map[0]; // 마지막으로 설치한 집의 위치
		
		for(int i = 1; i < map.length; i++) {
			int now = map[i];
			if(now - last >= dis) { // 지난번 설치한 집부터 현재 집까지의 거리가 설정한 거리 이상일 때
				count++;
				last = now;
			}
		}

		return count;
	}
}