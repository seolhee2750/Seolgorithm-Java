package BinarySearch;

/*
 * BOJ #9024 두 수의 합
 * https://www.acmicpc.net/problem/9024
 * 이분 탐색
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_9024 {

	static int t, n, k;
	static StringBuilder out = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		t = Integer.parseInt(in.readLine());
		
		for(int i = 0; i < t; i++) {
			st = new StringTokenizer(in.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];
			
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < n; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			
			bs(arr);
		}
		
		System.out.print(out);
	}
	
	public static void bs(int[] arr) {
		int tmp = Integer.MAX_VALUE;
		int cnt = 0;
		
		for(int i = 0; i < n-1; i++) {
			int num = arr[i];
			int min = i+1, max = n-1, mid = 0;
			
			while(min <= max) {
				mid = (min + max) / 2;
				int dif = arr[mid] + num - k;
				int now = Math.abs(dif); // k와의 차
				
				if(now < tmp) {
					tmp = now;
					cnt = 1;
				} else if(now == tmp) {
					cnt++;
				}
				
				if(dif == 0) { // k와 같을 때
					break;
				} else if(dif < 0) { // k가 더 클 때
					min = mid + 1;
				} else { // k가 더 작을 때
					max = mid - 1;
				}
			}
		}
		
		out.append(cnt + "\n");
	}
}