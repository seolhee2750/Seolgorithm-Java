package Graph;

/**
 * BOJ #15656 N과 M (7)
 * https://www.acmicpc.net/problem/15656
 * 백트래킹, 중복 순열
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15656 {
	
	static int n, m;
	static int[] nums;
	static StringBuilder out;
	
	public static void permu(int nth, int[] choosed) {
		if(nth == choosed.length) {
			for(int i = 0; i < nth; i++) {
				out.append(choosed[i]);
				if(i < nth-1) out.append(" ");
			}
			out.append("\n");
			return;
		}
		
		for(int i = 0; i < nums.length; i++) {
			choosed[nth] = nums[i];
			permu(nth+1, choosed);
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
		
		permu(0, new int[m]);
		System.out.println(out);
	}
}
