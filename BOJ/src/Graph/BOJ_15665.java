package Graph;

/**
 * BOJ #15665 N과 M (11)
 * https://www.acmicpc.net/problem/15665
 * 백트래킹, 중복 순열
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class BOJ_15665 {
	
	static int n, m;
	static int[] nums;
	static LinkedHashSet<String> answer = new LinkedHashSet<>(); // 들어가는 순서 유지 위해 LinkedHashSet 이용
	static StringBuilder out;
	
	public static void permu(int nth, int[] choosed) {
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
		for(String s: answer) out.append(s + "\n");
		System.out.println(out);
	}
}
