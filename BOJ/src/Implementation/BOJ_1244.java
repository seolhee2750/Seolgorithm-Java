package Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1244 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine()); // 스위치 개수
		String[] switches = in.readLine().split(" "); // 스위치 정보
		int m = Integer.parseInt(in.readLine()); // 학생 수
		
		for(int i = 0; i < m; i++) {
			String[] student = in.readLine().split(" ");
			String sex = student[0];
			int num = Integer.parseInt(student[1]);
			
			if(sex.equals("1")) { // 남학생
				for(int j = 0; j < switches.length; j++) {
					if((j + 1) % num == 0) switches[j] = (switches[j].equals("0")) ? "1" : "0";
				}
			}
			if(sex.equals("2")) { // 여학생
				switches[num-1] = (switches[num-1].equals("0")) ? "1" : "0";
				int idx = 1;
				
				while(true) {
					int target1 = num-1-idx;
					int target2 = num-1+idx;
					
					if(target1 < 0 || target2 >= switches.length) break;
					
					if(switches[target1].equals(switches[target2])) {
						switches[target1] = (switches[target1].equals("0")) ? "1" : "0";
						switches[target2] = (switches[target2].equals("0")) ? "1" : "0";
					}
					else break;
					
					idx++;
				}
			}
		}
		
		// 한 줄에 20개씩 출력
		for(int i=0; i<n; i++) {
			System.out.print(switches[i] + " ");
			if((i + 1) % 20 == 0)	System.out.println();
		}
	}

}
