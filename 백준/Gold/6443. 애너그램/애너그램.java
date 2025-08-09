import java.io.*;
import java.util.*;

/*
    입력받은 영단어의 철자들로 만들 수 있는 모든 단어를 출력
    입력받은 단어 내의 몇몇 철자가 중복될 수 있음 
    -> 이 경우를 줄여야 함
*/

public class Main {
    static int[] alphabet;
    static int size;
    static Stack<Character> stack;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            String word = br.readLine();
            alphabet = new int[26];    
            size = word.length();
            
            // 알파벳 개수 세기
            for(int j = 0; j < size; j++) {
                alphabet[word.charAt(j)-'a']++;
            }
            
            stack = new Stack<Character>();
            dfs();
        }
        
        System.out.println(sb);
    }
    
    public static void dfs() {
        if(stack.size() == size) {
            String result = "";
            for(char c : stack) result += c;
            sb.append(result).append("\n");
            return;
        }
        
        for(int i = 0; i < 26; i++) {
            if(alphabet[i] > 0) {
                alphabet[i]--;
                stack.add((char)(i+'a'));
                
                dfs();
                
                alphabet[i]++;
                stack.pop();
            }
        }
    }
}