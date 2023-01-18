package BruteForce;

/*
 * BOJ #1062 가르침
 * https://www.acmicpc.net/problem/1062
 * 완전탐색, 조합
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_1062 {

	static int n, k;
	static String[] str;
	static char[] defaultWord = {'a', 'c', 'i', 'n', 't'};
	static Set<Character> set = new HashSet<>();
	static List<Character> list;
	static int num;
	static int max;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		str = new String[n];
		
		for(int i = 0; i < n; i++) {
			str[i] = in.readLine();
			for(int j = 4; j < str[i].length()-4; j++) {
				char now = str[i].charAt(j);
				boolean flag = false;
				for(int k = 0; k < 5; k++) {
					if(defaultWord[k] == now) { 
						flag = true;
						break;
					}
				}
				if(!flag) set.add(now); // anta, tica에 포함되는 글자를 제외한 모든 글자를 중복 없이 모아 저장
			}
		}
		
		num = k - 5; // anta, tica를 제외한 글자의 개수
		if(num == 0) { // 조합으로 고를 수 있는 글자의 개수가 5개
			checkToRead(new char[]{'a', 'c', 'i', 'n', 't'});
		} else if(num < 0) { // 조합으로 고를 수 있는 글자의 개수가 5개 미만
			System.out.println(0);
			return;
		} else { // 조합으로 고를 수 있는 글자의 개수가 5개 초과
			list = new ArrayList<>(set);
			if(set.size() < num) {
				makeCombi(0, new char[set.size()], 0);
			} else {
				makeCombi(0, new char[num], 0);
			}
		}
		
		System.out.println(max);
	}
	
	static void makeCombi(int nth, char[] choosed, int startIdx) {
		if(nth == choosed.length) {
			checkToRead(choosed);
			return;
		}
		
		for(int i = startIdx; i < list.size(); i++) {
			choosed[nth] = list.get(i);
			makeCombi(nth+1, choosed, i+1);
		}
	}
	
	static void checkToRead(char[] choosed) {
		int cnt = 0;
		char[] finalChoosed = new char[choosed.length + 5];
		
		for(int i = 0; i < choosed.length; i++) {
			finalChoosed[i] = choosed[i];
		}
		
		for(int i = choosed.length; i < finalChoosed.length; i++) {
			finalChoosed[i] = defaultWord[i-choosed.length];
		}
		
		for(int i = 0; i < n; i++) { // 모든 단어를 읽을 수 있는지 확인
			boolean flag1 = true;
			for(int j = 4; j < str[i].length()-4; j++) { // 현재 단어를 읽을 수 있는지 확인
				boolean flag2 = false;
				for(char c: finalChoosed) { // 현재 글자를 배웠는지 확인
					if(str[i].charAt(j) == c) {
						flag2 = true;
						break;
					}
				}
				if(!flag2) {
					flag1 = false;
					break;
				}
			}
			if(flag1) cnt++;
		}
		
		if(cnt > max) max = cnt;
	}
}
