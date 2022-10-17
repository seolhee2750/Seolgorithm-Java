package Implementation;

/*
 * BOJ #20299 3대 측정
 * https://www.acmicpc.net/problem/20299
 * 구현
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20299 {

	static int n, s, m;
	static int cnt;
	static int[][] students;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder out = new StringBuilder();
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken()); // 팀의 수
		s = Integer.parseInt(st.nextToken()); // 팀원 3명의 레이팅 합에 대한 클럽 가입 조건
		m = Integer.parseInt(st.nextToken()); // 개인 능력치에 대한 클럽 가입 조건
		
		cnt = 0; // cnt 변수 초기화
		students = new int[n][3]; // Students 변수 초기화
		for(int i = 0; i < n; i++) {
			int tmpSum = 0;
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < 3; j++) {
				int nowStudent = Integer.parseInt(st.nextToken());
				students[i][j] = nowStudent;
				if(nowStudent < m) { // 개인 조건 미충족
					tmpSum = -1;
					break;
				} else { // 개인 조건 충족
					tmpSum += nowStudent;
				}
			}
			
			if(tmpSum >= s) { // 팀 조건 충족
				cnt++;
				for(int j = 0; j < 3; j++) {
					out.append(students[i][j] + " ");
				}
			}
		}
		
		// 출력
		System.out.println(cnt);
		System.out.println(out);
	}
}
