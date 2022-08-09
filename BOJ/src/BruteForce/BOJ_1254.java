package BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1254 {

	public static boolean bruteForce(char[] str, int i) {
		int idx1 = i;
		int idx2 = str.length - 1;
		
		while(true) {
			if(idx1 > idx2 || str[idx1] != str[idx2]) return false;
			
			if(idx2 - idx1 <= 2) return true;
			
			idx1++;
			idx2--;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char[] str = in.readLine().toCharArray();
		
		for(int i = 0; i < str.length-1; i++) {
			if(str[i] == str[str.length-1]) {
				if(bruteForce(str, i)) {
					System.out.println(i + str.length);
					return;
				}
			}
		}
		
		System.out.println(str.length * 2 - 1);
	}

}