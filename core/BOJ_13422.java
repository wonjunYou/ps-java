package core;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13422 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[] amounts = new int[n];
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                amounts[j] = Integer.parseInt(st.nextToken());
            }

            int count = 0;
            int left = 0;
            int right = 0;
            int profit = 0;

            while (right < m) {
                profit += amounts[right];
                right += 1;
            }

            right -= 1;

            if (n == m) {
                System.out.println(profit < k ? 1 : 0);
                continue;
            }

            while (left < n) {
                if (profit < k) {
                    count++;
                }

                profit -= amounts[left];
                left++;
                right = (right + 1) % n;
                profit += amounts[right];
            }

            System.out.println(count);
        }

    }
}
