package BruteForce;

/**
 * BOJ #9663 N-Queen
 * https://www.acmicpc.net/problem/9663
 * 브루트포스
 * 
 * 첫 번째 행부터 순서대로 완전탐색 해주었음
 * 두 번째 행부터는 isPossible 메서드를 이용해서, 이전에 놓은 퀸들과 비교하여 놓을 수 있는 자리인지를 확인 후 놓아주었음
 * 
 * [주의 사항]
 * 처음엔 queens를 각 퀸의 x, y 좌표 값을 담을 수 있도록 2차원 배열로 만들어주었는데
 * 생각해보니까 어차피 행 순서대로 퀸을 놓을 것이므로, 1차원 배열로 만든 뒤, queens의 인덱스를 행 번호로 생각해주면 되었음
 * (=> 2차원으로 만들면 시간 초과남!!!)
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_9663 {

	static int n, cnt;
	
	public static void dfs(int[] queens, int row) {
		for(int j = 0; j < n; j++) {
			if(row == 0 || isPossible(queens, row, j)) {
				if(row == n-1) {
					cnt++;
					return;
				}
				queens[row] = j;
				dfs(queens, row+1);
			}
		}
	}
	
	private static boolean isPossible(int[] queens, int x, int y) {
		for(int i = 0; i < x; i++) {
			int preX = i;
			int preY = queens[i];
			if(preX == x || preY == y || (x-preX == Math.abs(y-preY))) return false;
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		dfs(new int[n], 0);
		System.out.println(cnt);
	}
}
