package Graph;

/**
 * BOJ #15649 N과 M (1)
 * https://www.acmicpc.net/problem/15649
 * 백트래킹, 순열
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15649 {
	
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
		for(int i = 0; i < n; i++) nums[i] = i+1;
		
		permu(0, new int[m], new boolean[n]);
		System.out.println(out);		
	}
}
