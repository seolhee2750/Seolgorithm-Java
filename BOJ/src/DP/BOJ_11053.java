package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11053 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(in.readLine());
		int[] nums = new int[n];
		int[] lis = new int[n];
		int max = 0;
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			lis[i] = 1;
			for(int j = 0; j < i; j++) {
				if(nums[j] < nums[i] && lis[j]+1 > lis[i]) {
					lis[i] = lis[j] + 1;
				}
			}
			max = Math.max(max, lis[i]);
		}
		System.out.println(max);
	}
}
