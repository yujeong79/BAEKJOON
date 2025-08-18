import java.io.*;
import java.util.*;

public class Main {
    static class Move implements Comparable<Move> {
        int point;
        int time;

        public Move(int point, int time) {
            this.point = point;
            this.time = time;
        }

        @Override
        public int compareTo(Move other) {
            return this.time - other.time;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 0 ≤ N ≤ 100,000
        int K = sc.nextInt(); // 0 ≤ K ≤ 100,000

        int answer = BFS(N, K);
        System.out.println(answer);
    }

    public static int BFS(int N, int K) {
        PriorityQueue<Move> pq = new PriorityQueue<>();
        int[] isVisited = new int[200_001];
        Arrays.fill(isVisited, 100_000);
        pq.add(new Move(N, 0));
        isVisited[N] = 0;

        while(!pq.isEmpty()) {
            Move curr = pq.poll();

            if(curr.point-1 >= 0 && isVisited[curr.point-1] > curr.time+1) {
                isVisited[curr.point-1] = curr.time+1;
                pq.add(new Move(curr.point-1, curr.time+1));
            }

            if(curr.point+1 <= 200_000 && isVisited[curr.point+1] > curr.time+1) {
                isVisited[curr.point+1] = curr.time+1;
                pq.add(new Move(curr.point+1, curr.time+1));
            }

            if(curr.point*2 <= 200_000 && isVisited[curr.point*2] > curr.time) {
                isVisited[curr.point*2] = curr.time;
                pq.add(new Move(curr.point*2, curr.time));
            }
        }

        return isVisited[K];
    }
}