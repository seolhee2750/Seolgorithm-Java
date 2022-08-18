package Implementation;

/** 
 * BOJ #1074 Z [두 번째 풀이]
 * https://www.acmicpc.net/problem/1074
 * 분할 정복, 재귀
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1074_2nd {
	
	static int n, r, c, cnt;
	
	public static void move(int x, int y, int len) {
		if(len == 1) return;
		
		len /= 2;
		if(x < len && y < len) { // 1
			move(x, y, len);
		} else if(x < len && y >= len) { // 2
			cnt += len*len;
			move(x, y-len, len);
		} else if(x >= len && y < len) { // 3
			cnt += len*len*2;
			move(x-len, y, len);
		} else if(x >= len && y >= len) { // 4
			cnt += len*len*3;
			move(x-len, y-len, len);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		move(r, c, (int)Math.pow(2, n)); // 행, 열, 한 변 길이
		System.out.println(cnt);
	}
}
