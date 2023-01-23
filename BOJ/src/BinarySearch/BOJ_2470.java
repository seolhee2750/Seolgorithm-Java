package BinarySearch;

/*
 * BOJ #2470 두 용액
 * https://www.acmicpc.net/problem/2470
 * 이분 탐색
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2470 {
	
	static int n;
	static long[] arr;
	static long min = Long.MAX_VALUE;
	static int[] ans = new int[2];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(in.readLine());
		arr = new long[n];
		
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(arr);
		
		findMin();
		System.out.println(arr[ans[0]] + " " + arr[ans[1]]);
	}
	
	public static void findMin() {
		for(int i = 0; i < n-1; i++) {
			int left = i+1;
			int right = n-1;
			
			while(left <= right) {
				int mid = (left + right) / 2;
				long sum = Math.abs(arr[i] + arr[mid]);
				
				if(min > sum) {
					min = sum;
					ans[0] = i;
					ans[1] = mid;
					if(min == 0) return;
				}
				
				if(arr[mid] >= -arr[i]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
		}
	}
}
