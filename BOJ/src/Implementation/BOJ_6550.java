package Implementation;

import java.util.Scanner;

public class BOJ_6550 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()) {
			String[] str = sc.nextLine().split(" ");
			String s = str[0];
			String t = str[1];
			
			int idx = 0;
			String answer = "No";
			
			for(int i = 0; i < t.length(); i++) {
				if(t.charAt(i) == s.charAt(idx)) idx++;
				if(idx == s.length()) {
					answer = "Yes";
					break;
				}
			}
			
			System.out.println(answer);
		}
	}

}