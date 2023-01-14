package Implementation;

/*
 * BOJ #2810 컵홀더
 * https://www.acmicpc.net/problem/2810
 * 구현
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2810 {

	static int n;
	static String seat;
	static int population;
	static boolean couple;
	static int holder = 1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(in.readLine());
		seat = in.readLine();
		population = seat.length();
		
		for(int i = 0; i < population; i++) {
			if(seat.charAt(i) == 'S') {
				couple = false;
				holder++;
			} else {
				if(couple) {
					couple = false;
					holder++;
				} else {
					couple = true;
				}
			}
		}
		
		if(population > holder) {
			System.out.println(holder);
		} else {
			System.out.println(population);
		}
	}
}
