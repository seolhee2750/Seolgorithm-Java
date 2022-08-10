package Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ #16927 배열 돌리기 2
 * https://www.acmicpc.net/problem/16927
 * 구현
 * #16926번 문제와 같은데, 이 문제의 경우 회전을 아~~주 많이 하게 될 수 있음
 * 아~~주 많이 하게 될 경우 같은 회전을 반복할 수 있으므로 그 경우를 제외해주어야 함
 * => 회전하였을 때 다시 제자리로 돌아오는 회전의 수를 구하고, 회전에서 제외해주자 !!
 * 
 * 점화식
 * 띠마다 원상복귀되는 회전 수 : (세로 길이 + 가로 길이 - 2) * 2
 * => 띠마다 유효한 회전 수 : R % ((세로 길이 + 가로 길이 - 2) * 2)
 */

public class BOJ_16927 {
	
	static int[][] nums;
	static int n, m, r;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int nNext, mNext; // 띠마다 줄어드는 변의 길이 저장을 위함
	
	public static void turn(int start, int nowTurnNum) {
		for(int i = 0; i < nowTurnNum ; i++) { // 유효 회전 수 만큼만 회전
			int x = start;
			int y = start;
			int tmp = nums[start][start];
			int dir = 0; // 범위를 벗어날 때마다 dir을 바꿔주어 방향 전환
			
			while(dir < 4) {
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				
				if(nx < start || ny < start || nx >= n-start || ny >= m-start) { // 범위 벗어날 시 방향 전환
					dir++; 
					continue;
				}
				
				nums[x][y] = nums[nx][ny];
				x = nx;
				y = ny;
			}
			
			nums[start+1][start] = tmp;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer out = new StringBuffer();
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		nNext = n;
		mNext = m;
		r = Integer.parseInt(st.nextToken());
		int turnNum = Math.min(n, m) / 2; // 회전시켜야 하는 띠의 개수
		nums = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < m; j++) nums[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < turnNum; i++) { // 내부로 들어가면서 모든 띠 순회
			turn(i, r % ((nNext + mNext - 2) * 2));
			nNext -= 2;
			mNext -= 2;
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				out.append(nums[i][j]);
				if(j < m-1) out.append(" ");
			}
			out.append("\n");
		}
		System.out.println(out);
	}

}