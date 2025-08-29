import java.io.*;
import java.util.*;

public class Main {
    public static class Parentheses implements Comparable<Parentheses> {
        int val;
        int depth;

        public Parentheses() {}

        // 깊은순대로
        public int compareTo(Parentheses other) {
            return other.depth - this.depth;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        PriorityQueue<Parentheses> queue = new PriorityQueue<>();

        boolean isPossible = true;
        String str = br.readLine();
        for(int i = 0; i < str.length() && isPossible; i++) {
            char curr = str.charAt(i);
            Parentheses p = new Parentheses();
            switch(curr) {
                case ')':
                    if(stack.isEmpty() || stack.peek() != '(') {
                        isPossible = false;
                        break;
                    }

                    p.val = 2; p.depth = stack.size();
                    if(!queue.isEmpty() && queue.peek().depth > stack.size()) {
                        p.val *= queue.poll().val;
                    }

                    while(!queue.isEmpty() && queue.peek().depth == p.depth) {
                        Parentheses next = queue.poll();
                        p.val += next.val;
                    }
                    queue.offer(p);

                    stack.pop();
                    break;

                case ']':
                    if(stack.isEmpty() || stack.peek() != '[') {
                        isPossible = false;
                        break;
                    }

                    p.val = 3; p.depth = stack.size();
                    if(!queue.isEmpty() && queue.peek().depth > stack.size()) {
                        p.val *= queue.poll().val;
                    }

                    while(!queue.isEmpty() && queue.peek().depth == p.depth) {
                        Parentheses next = queue.poll();
                        p.val += next.val;
                    }
                    queue.offer(p);

                    stack.pop();
                    break;

                default:
                    stack.add(str.charAt(i));
                    break;
            }
        }

        System.out.println(!isPossible || !stack.isEmpty() ? 0 : queue.poll().val);
    }
}