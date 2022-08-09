package D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_6808 {

	static int[] gyuyoung; // 규영이 카드
	static int[] inyoung; // 인영이 카드
	static boolean[] allNums; // 전체 숫자
	static boolean[] visited; // 순열 생성 위한 방문 체크 배열
	static int[] perm; // 인영이의 카드 제출 순서 순열
	static int win, lose;
	
	public static void game(int cnt) {
		if(cnt == 9) { // 인영이 카드 순열 생성 완료 -> 승부 판단
			int gSum = 0; // 규영 점수
			int iSum = 0; // 인영 점수
			for(int i = 0; i < 9; i++) {
				if(gyuyoung[i] > perm[i]) gSum += (gyuyoung[i] + perm[i]);
				else iSum += (gyuyoung[i] + perm[i]);
			}
			if(gSum > iSum) win++;
			else if(gSum < iSum) lose++;
			return;
		}
		for(int i = 0; i < 9; i++) {
			if(visited[i]) continue;
			perm[cnt] = inyoung[i];
			visited[i] = true;
			game(cnt+1);
			visited[i] = false;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer out = new StringBuffer();
		
		int tc = Integer.parseInt(in.readLine());
		
		for(int t = 0; t < tc; t++) {
			allNums = new boolean[19];
			gyuyoung = new int[9];
			inyoung = new int[9];
			visited = new boolean[9];
			perm = new int[9];
			win = 0;
			lose = 0;
			
			st = new StringTokenizer(in.readLine());
			for(int i = 0; i < 9; i++) { // 규영이 숫자 입력받기
				int now = Integer.parseInt(st.nextToken());
				gyuyoung[i] = now;
				allNums[now] = true;
			}
			
			int idx = 0;
			for(int i = 1; i < 19; i++) { // 인영이 숫자 찾기
				if(!allNums[i]) inyoung[idx++] = i;
			}
			
			game(0);
			out.append("#" + (t+1) + " " + win + " " + lose + "\n");
		}
		
		System.out.println(out);
	}

}
