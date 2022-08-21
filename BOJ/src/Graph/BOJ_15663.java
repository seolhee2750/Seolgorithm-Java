package Graph;

/**
 * BOJ #15654 N과 M (9)
 * https://www.acmicpc.net/problem/15663
 * 백트래킹, 순열
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class BOJ_15663 {
	
	static int n, m;
	static int[] nums;
	static LinkedHashSet<String> answer = new LinkedHashSet<>(); // 들어가는 순서 유지 위해 LinkedHashSet 이용
	static StringBuilder out;
	
	public static void permu(int nth, int[] choosed, boolean[] visited) {
		if(nth == choosed.length) {
			String tmp = "";
			for(int i = 0; i < nth; i++) {
				tmp += choosed[i];
				if(i < nth-1) tmp += " ";
			}
			answer.add(tmp);
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
		for(String s: answer) out.append(s + "\n");
		System.out.println(out);
	}
}
