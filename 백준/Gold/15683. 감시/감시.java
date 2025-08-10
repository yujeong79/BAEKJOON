import java.io.*;
import java.util.*;

public class Main {
    static class CCTV {
        char num;
        int r, c;
        int dir; // 0:상, 1:우, 2:하, 3좌

        public CCTV(char num, int r, int c) {
            this.num = num;
            this.r = r;
            this.c = c;
        }
    }

    static int N, M;
    static char[][] map;
    static char[][] temp;
    static List<CCTV> cctvLst;
    static int blindSpot;
    static int answer;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        temp = new char[N][M];
        cctvLst = new ArrayList<>();
        blindSpot = 0;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                map[i][j] = st.nextToken().charAt(0);

                if(map[i][j] == '0') blindSpot++; // 사각지대 개수 세기
                else if(map[i][j] != '6') cctvLst.add(new CCTV(map[i][j], i, j)); // cctv 위치 및 방향 저장
            }
        }

        answer = blindSpot;
        dfs(0);

        System.out.println(answer);
    }

    public static void dfs(int idx) {
        if(idx >= cctvLst.size()) { // 모든 cctv의 방향을 정했다면
            int result = blindSpot - sumVisibleSpot();
            answer = Math.min(answer, result);
            return;
        }

        switch(cctvLst.get(idx).num) {
            case '1':
            case '3':
            case '4':
                for(int i = 0; i < 4; i++) {
                    cctvLst.get(idx).dir = i; // 현재 cctv의 방향
                    dfs(idx+1);
                }
                break;
            case '2':
                for(int i = 0; i < 2; i++) {
                    cctvLst.get(idx).dir = i;
                    dfs(idx+1);
                }
                break;
            case '5':
                cctvLst.get(idx).dir = 0;
                dfs(idx+1);
                break;
        }

    }

    public static int sumVisibleSpot() {
        int sum = 0;
        for(int i = 0; i < N; i++) {
            temp[i] = map[i].clone();
        }

        for(CCTV cctv : cctvLst) {
            switch(cctv.num) {
                case '1':
                    sum += countVisibleSpot1(cctv);
                    break;
                case '2':
                    sum += countVisibleSpot2(cctv);
                    break;
                case '3':
                    sum += countVisibleSpot3(cctv);
                    break;
                case '4':
                    sum += countVisibleSpot4(cctv);
                    break;
                case '5':
                    sum += countVisibleSpot5(cctv);
                    break;
            }
        }

//        System.out.println(sum);
        return sum;
    }

    public static int countVisibleSpot5(CCTV cctv) {
        int cnt = 0;

        for(int d = 0; d < 4; d++) { // 상, 하, 좌, 우 네 방향을 모두 감시
            int nr = cctv.r + dir[d][0];
            int nc = cctv.c + dir[d][1];
            while(nr >= 0 && nc >= 0 && nr < N && nc < M && map[nr][nc] != '6') {
                if(temp[nr][nc] == '0') {
                    temp[nr][nc] = '#';
                    cnt++;
                }

                nr = nr + dir[d][0];
                nc = nc + dir[d][1];
            }
        }

        return cnt;
    }

    public static int countVisibleSpot4(CCTV cctv) {
        int cnt = 0;

        for(int d = 0; d < 4; d++) { // 상, 하, 좌, 우 중 cctv.dir에 해당하는 한 방향만 감시하지 않음
            if(d == cctv.dir) continue;

            int nr = cctv.r + dir[d][0];
            int nc = cctv.c + dir[d][1];

            while(nr >= 0 && nc >= 0 && nr < N && nc < M && map[nr][nc] != '6') {
                if(temp[nr][nc] == '0') {
                    temp[nr][nc] = '#';
                    cnt++;
                }

                nr = nr + dir[d][0];
                nc = nc + dir[d][1];
            }
        }

        return cnt;
    }

    public static int countVisibleSpot3(CCTV cctv) {
        int cnt = 0;

        int d = cctv.dir;
        for(int i = 0; i < 2; i++) {
            int nr = cctv.r + dir[d][0];
            int nc = cctv.c + dir[d][1];
            while(nr >= 0 && nc >= 0 && nr < N && nc < M && map[nr][nc] != '6') {
                if(temp[nr][nc] == '0') {
                    temp[nr][nc] = '#';
                    cnt++;
                }

                nr = nr + dir[d][0];
                nc = nc + dir[d][1];
            }

            d = (d+1) % 4;
        }

        return cnt;
    }

    public static int countVisibleSpot2(CCTV cctv) {
        int cnt = 0;

        int d = cctv.dir;
        for(int i = 0; i < 2; i++) {
            int nr = cctv.r + dir[d][0];
            int nc = cctv.c + dir[d][1];
            while(nr >= 0 && nc >= 0 && nr < N && nc < M && map[nr][nc] != '6') {
                if(temp[nr][nc] == '0') {
                    temp[nr][nc] = '#';
                    cnt++;
                }

                nr = nr + dir[d][0];
                nc = nc + dir[d][1];
            }

            d = (d+2) % 4;
        }

        return cnt;
    }

    public static int countVisibleSpot1(CCTV cctv) {
        int cnt = 0;

        int d = cctv.dir;
        int nr = cctv.r + dir[d][0];
        int nc = cctv.c + dir[d][1];
        while(nr >= 0 && nc >= 0 && nr < N && nc < M && map[nr][nc] != '6') {
            if(temp[nr][nc] == '0') {
                temp[nr][nc] = '#';
                cnt++;
            }

            nr = nr + dir[d][0];
            nc = nc + dir[d][1];
        }

        return cnt;
    }
}