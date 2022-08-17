package Greedy;

/**
 * BOJ #1541 잃어버린 괄호
 * https://www.acmicpc.net/problem/1541
 * 그리디
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1541 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		ArrayList<String> list = new ArrayList<>();
		st = new StringTokenizer(in.readLine());
		while(st.hasMoreTokens()) {
			list.add(st.nextToken("-"));
		}
		
		int sum = 0;
		for(int i = 0; i < list.size(); i++) {
			int tmp = 0;
			st = new StringTokenizer(list.get(i), "+");
			while(st.hasMoreTokens()) tmp += Integer.parseInt(st.nextToken());
			
			if(i == 0) sum += tmp;
			else sum -= tmp;
		}
		System.out.println(sum);
	}

}
