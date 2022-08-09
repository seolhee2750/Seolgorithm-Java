package Math;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class BOJ_2023 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Deque<Integer> que = new ArrayDeque<>(Arrays.asList(2, 3, 5, 7));
		int[] secondNums = {1, 3, 7, 9};
		boolean isFirst = true;
		int[] toPlus = new int[n];
		toPlus[0] = 1;
		for(int i = 1; i < n; i++) toPlus[i] = toPlus[i-1] * 10;
		int idx = 0;
		
		mainLoop:
		while(true) {
			int num = que.removeFirst();
			
			if(idx >= 4) {
				for(int i = 2; i <= Math.sqrt(num); i++) {
					if(num % i == 0) continue mainLoop;
				}
			}
			
			for(int i: secondNums) {
				String tmp = Integer.toString(num);
				if(tmp.length() == n) {
					que.addFirst(num);
					break mainLoop;
				}
	
				que.add(i + (num * 10)); // 자릿수 늘려주며 수 더하기
			}
			
			if(idx <= 4) idx++;
		}
		
		printLoop:
		while(que.size() > 0) {
			int num = que.removeFirst();
			for(int i = 2; i <= Math.sqrt(num); i++) {
				if(num % i == 0) continue printLoop;
			}
			System.out.println(num);
		}
	}
}
