package Graph;

/**
 * BOJ #15654 N과 M (5)
 * https://www.acmicpc.net/problem/15654
 * 백트래킹, 순열BOJ_15654.java
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15654 {
	
	static int n, m;
	static int[] nums;
	static StringBuilder out;
	
	public static void permu(int nth, int[] choosed, boolean[] visited) {
		if(nth == choosed.length) {
			for(int i = 0; i < nth; i++) {
				out.append(choosed[i]);
				if(i < nth-1) out.append(" ");
			}
			out.append("\n");
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
		StringTokenizer st;
		out = new StringBuilder();
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		nums = new int[n];
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < n; i++) nums[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(nums);
		
		permu(0, new int[m], new boolean[n]);
		System.out.println(out);		
	}
}
