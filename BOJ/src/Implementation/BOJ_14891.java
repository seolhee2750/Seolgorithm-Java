package Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14891 {
	
	static char[][] ns = new char[4][]; // 각 기어들의 n, s극 정보
	static int[] dirs; // 각 기어들이 갖게 될 회전 방향 정보
	
	// 각 톱니의 회전 방향에 맞게 회전시켜주는 메소드
	public static void spin() {
		int tmp = 0;
		
		for(int i = 0; i < 4; i++) {
			// 시계 방향
			if(dirs[i] == 1) {
				tmp = ns[i][7];
				for(int j = 7; j > 0; j--) ns[i][j] = ns[i][j - 1];
				ns[i][0] = (char)tmp;
			}
			// 반시계 방향
			if(dirs[i] == -1) {
				tmp = ns[i][0];
				for(int j = 0; j < 7; j++) ns[i][j] = ns[i][j + 1];
				ns[i][7] = (char)tmp; 
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for(int i = 0; i < 4; i++) ns[i] = in.readLine().toCharArray();
		int num = Integer.parseInt(in.readLine());
		
		for(int i = 0; i < num; i++) {
			st = new StringTokenizer(in.readLine());
			int tobni = Integer.parseInt(st.nextToken()) - 1; // 회전을 시작하는 톱니의 인덱스
			dirs = new int[4];
			dirs[tobni] = Integer.parseInt(st.nextToken());
			
			// 왼쪽 톱니바퀴 검사
			for(int j = (tobni - 1); j >= 0; j--) {
				if(ns[j][2] == ns[j+1][6]) break;
				else dirs[j] = -dirs[j+1];
			}
			// 오른쪽 톱니바퀴 검사
			for(int j = (tobni + 1); j < 4; j++) {
				if(ns[j][6] == ns[j-1][2]) break;
				else dirs[j] = -dirs[j-1];
			}
			
			spin(); // 각 톱니 회전
		}
		
		// 결과 출력
		int answer = 0;
		int[] score = {1, 2, 4, 8};
		for(int i = 0; i < 4; i++) {
			if(ns[i][0] == '1') answer += score[i];
		}
		System.out.println(answer);
	}

}