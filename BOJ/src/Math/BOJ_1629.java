package Math;

/*
 * BOJ #1629 곱셈
 * https://www.acmicpc.net/problem/1629
 * 분할정복
 * 
 * 참고 블로그
 * https://youngest-programming.tistory.com/m/407
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1629 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		long a = Long.parseLong(st.nextToken()); // 밑
		long b = Long.parseLong(st.nextToken()); // 지수
		long c = Long.parseLong(st.nextToken());
		System.out.println(cal(a, b, c) % c);
	}
	
	public static long cal(long a, long b, long c) {
		if(b == 0) {
			return 1;
		} else if(b == 1) {
			return a;
		} else if(b % 2 == 0) { // 짝수 지수
			long n = cal(a, b/2, c) % c;
			return (n * n) % c;
		} else { // 홀수 지수
			long n = cal(a, b/2, c) % c;
			return (((n * n) % c) * a) % c;
		}
	}
}
