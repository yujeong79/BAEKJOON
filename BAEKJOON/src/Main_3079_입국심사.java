import java.io.*;
import java.util.*;

public class Main_3079_입국심사 {
    static class Person implements Comparable<Person>{
        int immigrationNum;
        int startTime;
        int endTime;

        public Person() {}

        public Person(int immigrationNum, int startTime, int endTime) {
            this.immigrationNum = immigrationNum;
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Person o) {
            if(this.endTime == o.endTime) return this.immigrationNum - o.immigrationNum;
            return this.endTime - o.endTime;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "immigrationNum=" + immigrationNum +
                    ", startTime=" + startTime +
                    ", endTime=" + endTime +
                    '}';
        }

    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, currT;
    static int[] T;

    public static void init() {
        T = new int[N];
    }
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " "); // (1 ≤ N ≤ 100,000, 1 ≤ M ≤ 1,000,000,000)
        N = Integer.parseInt(st.nextToken()); // 입국심사대의 수
        M = Integer.parseInt(st.nextToken()); // 상근이와 친구들의 수

        init();

        for(int i = 0; i < N; i++) {
            T[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(T); // 입국 심사가 빠른 순서대로 오름차순 정렬

        immigration();

    } // end of main

    private static void immigration() {
        Queue<Person> queue = new PriorityQueue<>();
        boolean[] isVisited = new boolean[N];

        queue.add(new Person(0, 0, T[0]));
        int passedCnt = 1;
        isVisited[0] = true;

        while(!queue.isEmpty()) {
            System.out.println(queue.toString());

            Person p = queue.poll(); // Person(0, 0, 2)
            if(passedCnt < M) {
                queue.add(new Person(p.immigrationNum, p.endTime, p.endTime + T[p.immigrationNum]));
                passedCnt++;
            }

            currT = p.endTime + T[p.immigrationNum]; // 4

        // binary search ////////////////////////////////////////
            int start = 0;
            int end = N-1;
            while(start <= end) {
                int mid = (start + end)/2;
                System.out.println(mid);

                if(T[mid] <= currT && !isVisited[mid]) {
                    isVisited[mid] = true;
                    queue.add(new Person(mid, 0, T[mid]));
                    start = mid;
                } else {
                    end = mid;
                }

                System.out.println(start + ", " + end);
            }

            System.out.println(queue.toString());
        }
    }

} // end of class

// 이분 탐색

// 1번 심사대(7초) 2번 심사대(10초)
// 7초(1) -> 10초(2) -> 14초(3) -> 20초(4) -> 21초(5) -> 30초(6)
// 7초(1) -> 10초(2) -> 14초(3) -> 20초(4) -> 21초(5) -> 28초(6)

// T = [3, 8, 3, 6, 9, 2, 4]
// [2, 3, 3, 4, 6, 8, 9]
// [0] : 3 -> 6 -> 9 -> 12 -> 15 -> 18 ->
// [1] : 8 -> 16 ->
// [2] : 3 -> 6 -> 9 -> 12 -> 15 -> 18 ->
// [3] : 6 -> 12 -> 18 ->
// [4] : 9 -> 18 ->
// [5] : 2 -> 4 -> 6 -> 8 -> 10 -> 12 -> 14 -> 16 -> 18 -> 20
// [6] : 4 -> 8 -> 12 -> 16 -> 20 ->

// [1] 5번 2초 [2] 5번 4초 [3] 0번 3초 [4] 2번 3초 [5] 6번 4초 [6] 5번 6초 [7] 0번 6초 [8] 2번 6초 [9] 3번 6초 [10] 5번 8초

// 1. 입국 심사 시간이 가장 빠른 심사대로 보낸다.
// 2. 가장 빠른 심사대로 2번째 사람을 보낸다.
// 2-1. 가장 빠른 심사대에서 2번째 사람까지 심사하는 동안 내로 시간이 걸리는 심사대로 다른 사람들을 보낸다.
// queue를 사용하면 되나?
/**
 * queue
 * 입국 심사를 마친 사람의 수 : 6 (=> add 할 때 1 증가)
 * 이분 탐색 => 6초 이내에 임국 심사가 끝나는 심사대를 찾아서 사람을 넣는다.
 *
 * person(0번 심사대, 6초)
 * person(3번 심사대, 6초)
 * person(5번 심사대, 4초, )
 * person(6번 심사대, 4초, 8초)
 * person(2번 심사대, 3초, 6초)
 */
