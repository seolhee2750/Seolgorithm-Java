package DP;

/* BOJ #2660 회장뽑기
 * https://www.acmicpc.net/problem/2660
 * 플로이드 워셜
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_2660 {

	static int n;
	static int[][] dist;
	static StringBuilder out = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(in.readLine());
		dist = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(i == j) dist[i][j] = 0;
				else dist[i][j] = 51; // 회원 수는 50명 이하
			}
		}
		
		while(true) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			
			if(a < 0) break;
			
			// 가중치를 1로 부여함으로써 한 번 친구를 거칠 때마다 1점씩 증가하도록 함
			dist[a][b] = 1;
			dist[b][a] = 1;
		}
		
		Floyd();
		findCandidate();
		System.out.println(out);
	}
	
	public static void Floyd() { // 플로이드 워셜
		for(int k = 0; k < n; k++) {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
	}
	
	public static void findCandidate() {
		int score = 51; // 회장 후보의 점수
		Deque<Integer> que = new ArrayDeque<>(); // 회장 후보 리스트
		
		for(int i = 0; i < n; i++) {
			int tmpMax = 0; // 개개인의 최대 점수 저장
			for(int j = 0; j < n; j++) {
				if(tmpMax < dist[i][j]) tmpMax = dist[i][j]; // 최댓값 갱신
			}
			
			if(score == tmpMax) { // score와 tmpMax가 같을 때 (== 현재 회장 후보들과 같은 점수)
				que.add(i); // 회장 후보 추가
			} else if(score > tmpMax) { // score보다 tmpMax가 작을 떄 (== 더 적합한 회장 후보 찾음)
				que.clear(); // 이전까지 누적한 회장 후보 리스트 비우고
				que.add(i); // 새로운 회장 후보 담기
				score = tmpMax; // 회장 후보의 점수 초기화
			}
		}
		
		out.append(score + " " + que.size() + "\n");
		while(!que.isEmpty()) {
			out.append((que.poll()+1) + " ");
		}
	}
}
