package BinarySearch;

/*
 * BOJ #2230 수 고르기
 * https://www.acmicpc.net/problem/2230
 * 이분 탐색
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2230 {

	static int n, m;
	static int[] num;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		num = new int[n];
		
		for(int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(in.readLine());
		}
		Arrays.sort(num);
		
		findAns();
		System.out.println(min);
	}
	
	public static void findAns() {
		for(int i = 0; i < n-1; i++) {
			int now = num[i];
			int left = i+1, right = n-1, mid = 0;
			
			while(left <= right) {
				mid = (left + right) / 2;
				int dif = num[mid] - now;
				
				if(dif >= m) {
					if(dif < min) min = dif;
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
		}
	}
}