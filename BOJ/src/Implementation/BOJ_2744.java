package Implementation;

/*
 * BOJ #2744 대소문자 바꾸기
 * https://www.acmicpc.net/problem/2744
 * 문자열
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2744 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		
		String str = in.readLine();

		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			
			if(Character.isUpperCase(c)) {
				out.append(String.valueOf(c).toLowerCase());
			} else {
				out.append(String.valueOf(c).toUpperCase());
			}
		}
		System.out.println(out);
	}
}
