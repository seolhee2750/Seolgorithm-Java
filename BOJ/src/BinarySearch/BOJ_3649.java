package BinarySearch;

/*
 * BOJ #3649 로봇 프로젝트
 * https://www.acmicpc.net/problem/3649
 * 이분 탐색
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_3649 {
	
	static long x;
	static int n;
	static long[] lego;
	static int[] ans = new int[2];
	static boolean flag;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		String now = null;
		
		while((now = in.readLine()) != null) {
			x = Long.parseLong(now) * 10000000;
			n = Integer.parseInt(in.readLine());
			lego = new long[n];
			for(int i = 0; i < n; i++) {
				lego[i] = Long.parseLong(in.readLine());
			}
			Arrays.sort(lego);
			
			find();
			if(flag) {
				System.out.println("yes " + lego[ans[0]] + " " + lego[ans[1]]);
				flag = false;
			} else {
				System.out.println("danger");
			}
		}
	}
	
	public static void find() {
		for(int i = 0; i < n-1; i++) {
			int left = i+1;
			int right = n-1;
			while(left <= right) {
				int mid = (left + right) / 2;
				long sum = lego[i] + lego[mid];
				
				if(sum == x) {
					ans[0] = i;
					ans[1] = mid;
					flag = true;
					return;
				}
				
				if(sum > x) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
		}
	}
}
