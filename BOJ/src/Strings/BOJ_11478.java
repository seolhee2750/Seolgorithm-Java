package Strings;

/*
 * BOJ #11478 서로 다른 부분 문자열의 개수
 * https://www.acmicpc.net/problem/11478
 * 문자열
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BOJ_11478 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		
		Set<String> set = new HashSet<>();
		
		for(int i = 0; i < str.length(); i++) {
			for(int j = i+1; j <= str.length(); j++) {
				set.add(str.substring(i, j));
			}
		}
		
		System.out.println(set.size());
	}
}
