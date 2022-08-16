package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2839 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int cnt = 0;
		
		while(true) {
			if (n % 5 == 0) {
				System.out.println(n/5 + cnt);
				break;
			} else if(n <= 0) {
	            System.out.println(-1);
	            break;
	        } else {
	        	n -= 3;
	        	cnt++;
	        }
		}
	}
}
