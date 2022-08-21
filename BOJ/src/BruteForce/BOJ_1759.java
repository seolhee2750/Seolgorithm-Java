package BruteForce;

/*
 * BOJ #1759 암호 만들기
 * https://www.acmicpc.net/problem/1759
 * 조합, 브루트포스
 * 
 * 알파벳의 조합에서 모음은 한 개 이상, 자음은 두 개 이상의 종류를 사용해야 한다는 점을 잘 체크해주어야 함
 * 모음은 한 개만 있으면 되므로 한 개의 모음이 존재할 시 바로 모음에 대한 탐색은 종료할 수 있도록 했고,
 * 자음은 두 개 종류 이상 필요하므로, 두 가지의 자음을 찾을 시 바로 자음에 대한 탐색 또한 종료하도록 함으로써 효율을 높였음
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759 {
	
	static int l, c;
	static String[] alpha;
	static StringBuilder out;
	static String vowel = "aeiou";
	
	public static void combi(int nth, String[] choosed, int startIdx) { // 조합
		if(nth == choosed.length) {
			check(choosed);
			return;
		}
		
		for(int i = startIdx; i < alpha.length; i++) {
			choosed[nth] = alpha[i];
			combi(nth+1, choosed, i+1);
		}
	}
	
	public static void check(String[] choosed) {
		String consonant = "";
		boolean isVowel = false;
		boolean isConsonant = false;
		
		for(int i = 0; i < choosed.length; i++) { // 모음, 자음 조건 만족하는지 체크
			if(!isVowel && vowel.contains(choosed[i])) isVowel = true; // 모음이 하나도 없을 때
			if(!isConsonant && !vowel.contains(choosed[i])) { // 자음이 두 개 미만일 때
				if(consonant.equals(choosed[i])) continue;
				else consonant += choosed[i];
				if(consonant.length() == 2) isConsonant = true;
			}
		}
		
		if(isVowel && isConsonant) { // 출력
			for(int i = 0; i < choosed.length; i++) out.append(choosed[i]);
			out.append("\n");
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		out = new StringBuilder();
		
		st = new StringTokenizer(in.readLine());
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		alpha = new String[c];
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < c; i++) alpha[i] = st.nextToken();
		Arrays.sort(alpha);
		
		combi(0, new String[l], 0);
		System.out.print(out);
	}

}
