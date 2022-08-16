package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2839 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int cnt = 0;
		
		if((n % 5) % 3 > 0) System.out.println(-1);
		else System.out.println((n / 5) + ((n % 5) / 3));
	}

}
