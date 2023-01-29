package Implementation;

/*
 * BOJ #8393 합
 * https://www.acmicpc.net/problem/8393
 * 구현
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_8393 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		 
		int n = Integer.parseInt(in.readLine());
		int ans = 0;
		
		for(int i = 1 ; i < n+1 ; i++) ans += i;
		System.out.println(ans);
	}
}
