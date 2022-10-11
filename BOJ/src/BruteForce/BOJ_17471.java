package BruteForce;

/*
 * BOJ #17471 게리맨더링
 * https://www.acmicpc.net/problem/17471
 * 부분 집합, DFS 사용
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_17471 {

	static int n; // 구역 수
	static int[] areaInfo; // 구역별 인구 수 저장 (인덱스 번호 == 구역 번호)
	static List<Integer>[] lines; // 구역별 인접 구역 저장 (인덱스 번호 == 구역 번호)
	static int[] areaList; // 구역들의 번호를 저장 (인덱스 번호 + 1 == 구역 번호) -> 부분 집합 위해 사용
	static boolean check;
	static int ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(in.readLine());
		areaInfo = new int[n+1];
		
		st = new StringTokenizer(in.readLine());
		for(int i = 1; i < n+1; i++) {
			areaInfo[i] = Integer.parseInt(st.nextToken());
		}
		
		lines = new ArrayList[n+1];
		for(int i = 1; i < n+1; i++) {
			lines[i] = new ArrayList<>();
		}
		
		for(int i = 1; i < n+1; i++) {
			st = new StringTokenizer(in.readLine());
			int amount = Integer.parseInt(st.nextToken());
			for(int j = 0; j < amount; j++) {
				lines[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		areaList = new int[n];
		ans = Integer.MAX_VALUE;
		makeAreaList();
		makeSubSet(0, new boolean[n]);
		
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
	}
	
	public static void makeAreaList() { // 구역 번호들을 저장하는 전체 집합 만들기
		for(int i = 0; i < n; i++) {
			areaList[i] = i + 1;
		}
	}
	
	public static void makeSubSet(int toCheck, boolean[] checked) { // 부분집합
		if(toCheck == checked.length) {
			goToDfs(checked);
			return;
		}
		
		checked[toCheck] = true;
		makeSubSet(toCheck+1, checked);
		checked[toCheck] = false;
		makeSubSet(toCheck+1, checked);
	}
	
	public static void goToDfs(boolean[] checked) {
		List<Integer> areaA = new LinkedList<>();
		List<Integer> areaB = new LinkedList<>();
		for(int i = 0; i < checked.length; i++) { // 두 개의 부분집합 완성시켜주기
			if(checked[i]) areaA.add(areaList[i]);
			else areaB.add(areaList[i]);
		}
		
		if(areaA.size() > 0 && areaB.size() > 0) { // 두 집합 모두 하나 이상의 구역을 가질 때
			check = false;
			List<Integer> tmpA = new ArrayList<>();
			List<Integer> tmpB = new ArrayList<>();
			tmpA.addAll(areaA);
			tmpB.addAll(areaB);
			
			int nowA = tmpA.remove(0); // 첫 번째 구역 빼오기
			dfs(tmpA, nowA);
			if(check) { // areaA가 모두 이어져있음이 확인되었을 때
				check = false;
				int nowB = tmpB.remove(0); // 첫 번째 구역 빼오기
				dfs(tmpB, nowB);
			}
			
			if(check) { // 두 구역 모두 이어져있을 때
				counting(areaA, areaB);
			}
		}
	}
	
	public static void dfs(List<Integer> area, int now) { // 하나의 집합에 포함된 구역들이 모두 이어져있는지 확인
		if(area.size() == 0) {
			check = true;
			return;
		}
		
		List<Integer> linesNow = lines[now];
		for(int i = 0; i < linesNow.size(); i++) {
			for(int j = 0; j < area.size(); j++) {
				if(area.get(j) == linesNow.get(i)) { // area 집합에 존재하는 구역 발견 시
					int tmp = area.get(j);
					area.remove(j);
					dfs(area, tmp);
				}
			}
		}
	}
	
	public static void counting(List<Integer> areaA, List<Integer> areaB) { // 인구 수 차이를 연산하고, 최솟값 갱신
		int aCnt = 0;
		int bCnt = 0;
		
		for(int i = 0; i < areaA.size(); i++) {
			aCnt += areaInfo[areaA.get(i)];
		}
		for(int i = 0; i < areaB.size(); i++) {
			bCnt += areaInfo[areaB.get(i)];
		}
		
		int tmp = Math.abs(aCnt - bCnt);
		ans = Math.min(ans, tmp);
	}
}
