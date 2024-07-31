package history;

import java.util.*;

public class PRG_가장_먼_노드 {

    class Solution {
        public int solution(int n, int[][] edge) {

            boolean[][] node = new boolean[n + 1][n + 1];
            boolean[] visited = new boolean[n + 1];

            for(int i = 0 ; i < edge.length; i++){
                node[edge[i][0]][edge[i][1]] = true;
                node[edge[i][1]][edge[i][0]] = true;
            }

            Queue<Integer> queue = new LinkedList<>();
            queue.add(1);

            int result = 0;

            while(!queue.isEmpty()) {
                result = queue.size();

                for(int i = 0; i < result; i++) {
                    int current = queue.poll();

                    for(int next = 2; next < n + 1; next++) {
                        if(visited[next] || !node[current][next]) continue;
                        visited[next] = true;
                        queue.add(next);
                    }
                }
            }

            return result;
        }
    }
}
