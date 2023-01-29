package Implementation;

/*
 * BOJ #10807 개수 세기
 * https://www.acmicpc.net/problem/10807
 * 구현
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10807 {
	
	static int n, v;
	static int[] num;
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(in.readLine());
		num = new int[n];
		
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		v = Integer.parseInt(in.readLine());
		for(int n: num) {
			if(n == v) ans++;
		}
				
		System.out.println(ans);
	}
}
