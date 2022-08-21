package Graph;

/**
 * BOJ #15655 N과 M (6)
 * https://www.acmicpc.net/problem/15655
 * 백트래킹, 조합
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15657 {
	
	static int n, m;
	static int[] nums;
	static StringBuilder out;
	
	public static void combi(int nth, int[] choosed, int startIdx) {
		if(nth == choosed.length) {
			for(int i = 0; i < nth; i++) {
				out.append(choosed[i]);
				if(i < nth-1) out.append(" ");
			}
			out.append("\n");
			return;
		}
		
		for(int i = startIdx; i < nums.length; i++) {
			choosed[nth] = nums[i];
			combi(nth+1, choosed, i+1);
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
		
		combi(0, new int[m], 0);
		System.out.println(out);		
	}
}
