package D4;

/**
 * SWEA #1233 사칙연산 유효성 검사
 * https://swexpertacademy.com/main/talk/solvingClub/problemView.do?contestProbId=AV141176AIwCFAYD&solveclubId=AYHg4cRqHpADFAV6&problemBoxTitle=8%EC%9B%94+2%EC%A3%BC&problemBoxCnt=5&probBoxId=AYJ7e5KK4AIDFAVG
 * 
 * 단말 노드는 연산자면 안됨
 * 단말노드가 아닐 경우 숫자면 안됨
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1233 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer out = new StringBuffer();
		
		for(int t = 1; t <= 10; t++) {
			int n = Integer.parseInt(in.readLine());
			int answer = 1;			
			
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(in.readLine());
				if(answer == 0) continue; // answer가 0이면 다음 입력부터 검사할 필요x
				st.nextToken(); // 노드 번호 알 필요x => 패스
				String cal = st.nextToken();
				
				if(st.hasMoreTokens()) { // 입력 남았을 떼 == 단말 노드가 아닐 때 == 숫자면 안돼 !
					if(!(cal.equals("+") || cal.equals("-") || cal.equals("*") || cal.equals("/"))) answer = 0;
				} else { // 더 이상 입력 없을 때 == 단말 노드일 때 == 연산자면 안돼 !
					if(cal.equals("+") || cal.equals("-") || cal.equals("*") || cal.equals("/")) answer = 0;
				}
			}
			out.append("#" + t + " " + answer + "\n");
		}
		System.out.println(out);
	}
}
