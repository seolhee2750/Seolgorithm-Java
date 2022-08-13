package BruteForce;

/**
 * BOJ #3040 백설 공주와 일곱 난쟁이
 * https://www.acmicpc.net/problem/3040
 * 조합
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_3040 {

	static int[] nanjaeng;
	static boolean finish = false;
	static int[] result;
	
	public static void combi(int nth, int[] choosed, int start) {
		if(nth == 7) {
			int sum = 0;
			for(int c: choosed) sum += c;
			if(sum == 100) {
				result = Arrays.copyOf(choosed, choosed.length);
				finish = true;
			}
			return;
		}
		for(int i = start; i < nanjaeng.length; i++) {
			choosed[nth] = nanjaeng[i];
			if(!finish)combi(nth+1, choosed, i+1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer out = new StringBuffer();
		nanjaeng = new int[9];
		for(int i = 0; i < 9; i++) nanjaeng[i] = Integer.parseInt(in.readLine());	
		combi(0, new int[7], 0);
		for(int r: result) out.append(r + "\n");
		System.out.print(out);
	}

}

