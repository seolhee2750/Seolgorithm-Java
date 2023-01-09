package Implementation;

/*
 * BOJ #1213 팰린드롬 만들기
 * 구현
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1213 {

    static char[] str; // 주어진 문자열
    static int len;
    static boolean type; // (true면 짝수, false면 홀수)
    static Map<Character, Integer> map = new HashMap<>(); // 각 알파벳 개수 세기 위함
    static int n; // 홀수인 알파벳의 개수를 세기 위함

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        str = in.readLine().toCharArray();
        len = str.length;
        type = true ? (len % 2 == 0) : false;

        for(char s: str) {
            if(map.get(s) != null) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }

        for(Map.Entry<Character, Integer> ent: map.entrySet()) {
            if (ent.getValue() % 2 != 0) { // 홀수개인 알파벳 발견
                if(type || (!type && n == 1)) { // 문자열의 개수가 짝수개이거나, 홀수개이지만 홀수개인 알파벳이 두 개 이상일 때
                    System.out.println("I'm Sorry Hansoo");
                    return;
                } else {
                    n++;
                }
            }
        }

        char[] res = new char[len];
        List<Character> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);
        char tmp = 0;
        int nowIdx = 0;

        for(int i = 0; i < keySet.size(); i++) {
            int now = map.get(keySet.get(i));
            if(now % 2 != 0) res[len/2] = keySet.get(i);
            if(now > 1) {
                for(int j = 0; j < now/2; j++) {
                    res[nowIdx] = keySet.get(i);
                    res[res.length - 1 - nowIdx] = keySet.get(i);
                    nowIdx++;
                }
            }
        }

        for(char r: res) out.append(r);
        System.out.println(out);
    }
}
