package Implementation;

/**
 * BOJ #1074 Z
 * https://www.acmicpc.net/problem/1074
 * 분할 정복, 재귀
 * 
 * 재귀를 돌며 탐색의 범위를 점점 좁혀 나가는 것이 포인트!
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1074 {
	
	static int n, r, c, cnt;
	
	public static void move(int len, int r, int c) {
		if(len == 1) return; // 우리가 찾던 딱 한 칸만 남을 때 반환
		
		len /= 2; // 4등분한 한 변의 길이
		if(r < len && c < len) { // 1
			move(len, r, c);
		} else if(r < len && c < len*2) { // 2
			cnt += len*len;
			move(len, r, c-len);
		} else if(r < len*2 && c < len) { // 3
			cnt += len*len*2;
			move(len, r-len, c);
		} else if(r < len*2 && c < len*2) { // 4
			cnt += len*len*3;
			move(len, r-len, c-len);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		move((int)Math.pow(2, n), r, c);
		System.out.println(cnt);
	}

}
