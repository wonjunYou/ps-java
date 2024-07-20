package core;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[][] coins = new int[K][2];

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            coins[i][0] = Integer.parseInt(st.nextToken());
            coins[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[K+1][T+1];

        for (int k = 1; k < K + 1; k++) {
            dp[k-1][0] = 1; // 0원을 만드는 경우의 수는 항상 1이기 때문에 해당 값을 넣는다.
            for (int t = 1; t < T + 1; t++) { // 만드는 금액
                for (int n = 0; n <= coins[k-1][1]; n++) { // i번째 동전의 개수
                    if (t < coins[k-1][0] * n) { break; }
                    dp[k][t] += dp[k-1][t - coins[k-1][0] * n];
                }
            }
        }

        System.out.println(dp[K][T]);
        br.close();
    }
}

public class BOJ_2624 {
    public static void main(String[] args) throws Exception {
        new Main().main(args);
    }

}
