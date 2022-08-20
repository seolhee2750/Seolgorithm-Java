package BruteForce;

/*
 * BOJ #10974 모든 순열
 * https://www.acmicpc.net/problem/10974
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_10974 {

	static int n;
	static int[] nums;
	static StringBuilder out = new StringBuilder();
	
	public static void permu(int nth, int[] choosed, boolean[] visited) {
		if(nth == choosed.length) {
			for(int i = 0; i < nth; i++) {
				if(i == nth-1) out.append(choosed[i] + "\n");
				else out.append(choosed[i] + " ");
			}
			return;
		}
		
		for(int i = 0; i < nums.length; i++) {
			if(!visited[i]) {
				choosed[nth] = nums[i];
				visited[i] = true;
				permu(nth+1, choosed, visited);
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(in.readLine());
		nums = new int[n];
		for(int i = 0; i < n; i++) nums[i] = i+1;
		
		permu(0, new int[n], new boolean[n]);
		System.out.println(out);
	}

}
