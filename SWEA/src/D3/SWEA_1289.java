package D3;

//SWEA #1289 원재의 메모리 복구하기

import java.util.Scanner;

public class SWEA_1289 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		for(int t = 0; t < tc; t++) {
			char[] origin = sc.next().toCharArray();
			char[] now = new char[origin.length];
			for(int i = 0; i < now.length; i++) {
				now[i] = '0';
			}
			
			int last = now[0];
			int cnt = 0;
			for(int i = 0; i < origin.length; i++) {
				if(last != origin[i]) {
					last = origin[i];
					cnt++;
				}
			}
			System.out.printf("#%d %d\n", t+1, cnt);
		}
	}

}
