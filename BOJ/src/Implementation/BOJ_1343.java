package Implementation;

/*
 * BOJ #1343 폴리오미노
 * 구현
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_1343 {

    static class Info {
        char type;
        int cnt;

        public Info(char type, int cnt) {
            this.type = type;
            this.cnt = cnt;
        }
    }

    static char[] str;
    static List<Info> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        str = in.readLine().toCharArray();

        for(int i = 0; i < str.length; i++) {
            if(str[i] == 'X') {
                int cnt = 1;
                for(int j = i+1; j < str.length; j++) {
                    if(str[j] == 'X') cnt++;
                    else break;
                }
                if (cnt % 2 > 0) {
                    System.out.println(-1);
                    return;
                } else {
                    list.add(new Info('X', cnt));
                    i += cnt - 1;
                }
            } else {
                int cnt = 1;
                for(int j = i+1; j < str.length; j++) {
                    if(str[j] == '.') cnt++;
                    else break;
                }
                list.add(new Info('.', cnt));
                i += cnt - 1;
            }
        }

        for(Info now: list) {
            if(now.type == 'X') {
                for(int i = 0; i < (now.cnt - (now.cnt % 4)); i++) out.append('A');
                for(int i = 0; i < now.cnt % 4; i++) out.append('B');
            } else {
                for(int i = 0; i < now.cnt; i++) out.append('.');
            }
        }
        System.out.println(out);
    }
}
