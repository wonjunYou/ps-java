package history;

import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] dimensions = br.readLine().split(" ");

        int n = Integer.parseInt(dimensions[0]);
        int m = Integer.parseInt(dimensions[1]);

        int[][] array = new int[n][m];

        int x = -1;
        int y = -1;

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                array[i][j] = Integer.parseInt(line[j]);

                if (array[i][j] == 2) {  // 2를 기준으로 BFS 시작
                    x = i;
                    y = j;
                    array[x][y] = 0;  // 시작점은 거리 0
                }
            }
        }

        int[][] visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], -1);
        }

        bfs(x, y, n, m, visited, array);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (array[i][j] == 0) {
                    System.out.print(0 + " ");
                } else {
                    System.out.print(visited[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void bfs(int x, int y, int n, int m, int[][] visited, int[][] array) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));

        visited[x][y] = 0;

        while (!q.isEmpty()) {
            Point point = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || array[nx][ny] == 0) {
                    continue;
                }

                if (visited[nx][ny] == -1) {  // 방문하지 않은 곳만
                    visited[nx][ny] = visited[point.x][point.y] + 1;  // 이전 방문한 곳에서 +1
                    q.offer(new Point(nx, ny));
                }
            }
        }
    }
}

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
