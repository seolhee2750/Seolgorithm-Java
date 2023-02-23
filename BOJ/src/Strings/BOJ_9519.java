package Strings;

/*
 * BOJ #9519 졸려
 * https://www.acmicpc.net/problem/9519
 * 문자열, 구현
 */

import java.io.*;
import java.util.*;

public class BOJ_9519 {

	static int x;
	static String str;
	static int len;
	static ArrayList<String> roop;
	static StringBuilder out = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		x = Integer.parseInt(in.readLine());
		str = in.readLine();
		len = str.length();
		roop = new ArrayList<>();
		
		for(int i = 0; i < x; i++) {
			char[] tmp = new char[len];
			for(int j = 0; j < len-1; j += 2) {
				tmp[j/2] = str.charAt(j); // 앞에 하나
				tmp[len-1-(j/2)] = str.charAt(j+1); // 뒤에 하나
			}
			if(len % 2 > 0) tmp[len / 2] = str.charAt(len - 1);
			
			str = new String(tmp);
			
			if(i == 0) {
				roop.add(str);
			} else {
				if(roop.get(0).equals(str)) {
					break;
				} else {
					roop.add(str);
				}
			}
		}
		
		System.out.println(roop.get((x - 1) % roop.size()));
	}
}
