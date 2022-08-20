package BruteForce;

/**
 * BOJ #2309 일곱 난쟁이
 * https://www.acmicpc.net/problem/2309
 * 조합
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2309 {
	
	static int[] nums = new int[9];
	static boolean over = false;
	static StringBuilder out;
	
	public static void combi(int nth, int[] choosed, int startIdx) {
		if(over) return;
		if(nth == choosed.length) {
			isTrue(choosed); 
			return;
		}
		
		for(int i = startIdx; i < nums.length; i++) {
			choosed[nth] = nums[i];
			combi(nth+1, choosed, i+1);
		}
	}
	
	private static void isTrue(int[] choosed) {
		int sum = 0;
		for(int i = 0; i < choosed.length; i++) sum += choosed[i];
		if(sum == 100) {
			over = true;
			Arrays.sort(choosed);
			for(int i = 0; i < choosed.length; i++) {
				out.append(choosed[i] + "\n");
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		out = new StringBuilder();
		for(int i = 0; i < 9; i++) nums[i] = Integer.parseInt(in.readLine());
				
		combi(0, new int[7], 0);
		System.out.print(out);
	}
}
