package BruteForce;

/*
 * BOJ #18442 우체국 1
 * https://www.acmicpc.net/problem/18442
 * 브루트포스
 * => 조합과 메모이제이션 활용하여 풀이했음
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_18442 {

	static int v, p;
	static long l;
	static int[] town; // 각 마을들의 인덱스를 담는 배열
	static long[] townInfo; // 각 마을들의 좌표를 담는 배열
	static long[][] dist; // 모든 (마을 to 마을) 거리에 대한 정보를 담는 배열
	static long min; // 최솟값
	static int[] postOffice; // 우체국 목록
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder out = new StringBuilder();

		st = new StringTokenizer(in.readLine());
		v = Integer.parseInt(st.nextToken()); // 마을의 개수
		p = Integer.parseInt(st.nextToken()); // 우체국의 개수
		l = Long.parseLong(st.nextToken()); // 각 좌표의 범위 0 ~ n-1
		min = Long.MAX_VALUE;
		
		townInfo = new long[v];
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < v; i++) {
			townInfo[i] = Long.parseLong(st.nextToken());
		}
		
		makeTown(); // 각 마을 번호에 대한 배열 만들기
		combi(0, new int[p], 0); // v개의 마을 중 p개를 선택하는 조합 구하기
		
		// 출력
		out.append(min + "\n");
		for(int i: postOffice) {
			out.append(townInfo[i] + " ");
		}
		out.deleteCharAt(out.length()-1);
		System.out.print(out);
	}
	
	public static void makeTown() {
		town = new int[v];
		for(int i = 0; i < v; i++) town[i] = i; // (마을 번호 == 인덱스)로 설정
	} // => 마을의 좌표가 아닌 마을의 인덱스로 조합을 구하기 위한 과정
	
	public static void combi(int nth, int[] choosed, int startIdx) {
		if(nth == choosed.length) { // 하나의 조합이 완성되었을 때
			distance(choosed);
			return;
		}
		
		for(int i = startIdx; i < v; i++) {
			choosed[nth] = town[i];
			combi(nth+1, choosed, i+1);
		}
	}
	
	public static void distance(int[] choosed) {
		makeDist(); // 모든 (마을 to 마을)에 대한 거리 구하기
		long tmpSum = 0;
		for(int i = 0; i < v; i++) {
			long tmpMin = Long.MAX_VALUE; // 현재 마을과 가장 가까운 우체국과의 거리를 담기 위한 변수
			for(int j = 0; j < choosed.length; j++) {
				if(dist[i][choosed[j]] < tmpMin) tmpMin = dist[i][choosed[j]]; // 가장 가까운 우체국 고르기
			}
			tmpSum += tmpMin; // 가장 가까운 우체국과의 거리 누적
		}
		
		if(min > tmpSum) { // 최솟값 갱신
			min = tmpSum;
			postOffice = Arrays.copyOf(choosed, choosed.length);
		}
	}
	
	public static void makeDist() {
		dist = new long[v][v];
		for(int i = 0; i < v; i++) {
			for(int j = 0; j < v; j++) {
				long abs = Math.abs(townInfo[i] - townInfo[j]);
				long nowDist = Math.min(abs, l-abs);
				dist[i][j] = nowDist; // i to j
				dist[j][i] = nowDist; // j to i
            }
		}
	} // => 모든 (마을 to 마을) 거리를 미리 연산해둠으로써, 우체국과 가장 가까운 마을을 효율적으로 구하기 위함
}