package Strings;

/*
 * BOJ #1969 DNA
 * 구현, 문자열
 * https://www.acmicpc.net/status?group_id=15162
 */

import java.io.*;
import java.util.*;

public class BOJ_1969 {
	
	static int n, m;
	static String[] dnaStr;
	static char[][] dna;
	static char[] alpha = "ACGT".toCharArray();
	static String ansDna = "";
	static int ansCnt;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
	
		dnaStr = new String[n];
		for(int i = 0; i < n; i++) {
			dnaStr[i] = in.readLine();
		}
		Arrays.sort(dnaStr);
		
		dna = new char[n][m];
		for(int i = 0; i < n; i++) {
			dna[i] = dnaStr[i].toCharArray();
		}
		
		for(int i = 0; i < m; i++) {
			int[] alphaCnt = new int[4];
			for(int j = 0; j < n; j++) {
				char alphabet = dna[j][i];
				for(int a = 0; a < 4; a++) {
					if(alphabet == alpha[a]) {
						alphaCnt[a]++;
					}
				}
			}
			
			int tmp = 0;
			int cnt = 0;
			for(int j = 0; j < 4; j++) {
				if(alphaCnt[j] > cnt) {
					cnt = alphaCnt[j];
					tmp = j;
				}
			}
			ansDna += alpha[tmp];
		}
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(dna[j][i] != ansDna.charAt(i)) ansCnt++;
			}
		}
		
		System.out.println(ansDna + "\n" + ansCnt);
	}
}