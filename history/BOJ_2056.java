package history;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2056 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];

        int time;
        int preTaskCount;

        for (int i = 1; i < n + 1; i++) {
            int[] taskInfo = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

            time = taskInfo[0];
            preTaskCount = taskInfo[1];

            dp[i] = time;

            for (int j = 2; j < taskInfo.length; j++) {
                dp[i] = Math.max(dp[i], dp[taskInfo[j]] + time);
            }

        }

        int result = Arrays.stream(dp)
            .max()
            .getAsInt();

        System.out.println(result);
    }
}
