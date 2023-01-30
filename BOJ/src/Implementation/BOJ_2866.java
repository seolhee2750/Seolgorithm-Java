package Implementation;

/*
 * BOJ #2866 문자열 잘라내기
 * https://www.acmicpc.net/problem/2866
 * 문자열
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_2866 {
	
	static int r, c;
	static Set<String> set;
	static StringBuilder makeStr;
	static int cnt = 0;
	static String[] str;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		char[][] word = new char[r][c];
		for (int i = 0; i < r; i++) {
			word[i] = in.readLine().toCharArray();
		}
		
		// 한 열 더해서 문자열 만들고 저장
		str = new String[c];
		for (int i = 0; i < c; i++) {
			makeStr = new StringBuilder();
			for (int j = 1; j < r; j++) {
				makeStr.append(word[j][i]);
			}
			str[i] = makeStr + "";
		}
		
		findAns();
		System.out.println(cnt);
	}
	
	public static void findAns() {
		for (int i = 0; i < r; i++) {
			set = new HashSet<>();
			for (int j = 0; j < c; j++) {
				String now = str[j].substring(i);
				if (set.contains(now)) {
					return;
				} else {
					set.add(now);
				}
			}
			cnt++;
		}
	}
}
