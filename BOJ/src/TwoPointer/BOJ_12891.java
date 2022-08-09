package TwoPointer;

/**
 * BOJ #12891 DNA 비밀번호
 * https://www.acmicpc.net/problem/12891
 * 슬라이딩 윈도우
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12891 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int S, P;
	static String str;
	static int A, C, G, T;
	static int[] CHAR_CNT = new int['Z' + 1];
	static int ANS;

	public static void main(String[] args) throws Exception {
		tokens = new StringTokenizer(input.readLine());
		S = Integer.parseInt(tokens.nextToken());
		P = Integer.parseInt(tokens.nextToken());
		str = input.readLine();
		tokens = new StringTokenizer(input.readLine());
		A = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		G = Integer.parseInt(tokens.nextToken());
		T = Integer.parseInt(tokens.nextToken());
		
		ANS = 0;
		for(int p = 0; p < P; p++) {
			CHAR_CNT[str.charAt(p)]++;
		}
		if(isPossible()) {
			ANS++;
		}
		for(int p = 0; p<S-P; p++) {
			CHAR_CNT[str.charAt(p)]--;
			CHAR_CNT[str.charAt(p+P)]++;
			
			if(isPossible()) {
				ANS++;
			}
		}
		
		System.out.println(ANS);
	}
	
	static boolean isPossible() {
		return CHAR_CNT['A'] >= A && CHAR_CNT['C'] >= C && CHAR_CNT['G'] >= G && CHAR_CNT['T'] >= T;
	}
}
