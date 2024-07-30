package core;

import java.io.*;
import java.util.*;

public class BOJ_5430 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        String functions;
        int n;
        for (int i = 0; i < t; i++) {
            functions = br.readLine();
            n = Integer.parseInt(br.readLine().strip());
            String input = br.readLine();

            if (n == 0 && !functions.isEmpty()) {
                boolean errorFlag = false;
                for (int k = 0; k < functions.length(); k++) {
                    if (functions.charAt(k) == 'D') {
                        System.out.println("error");
                        errorFlag = true;
                        break;
                    }
                }

                if (!errorFlag) {
                    System.out.println("[]");
                }

                continue;
            }

            String[] numbers = input.substring(1, input.length() - 1).split(",");

            ArrayDeque<Integer> deque = new ArrayDeque<>();
            for (String number : numbers) {
                deque.addLast(Integer.parseInt(number));
            }

            boolean reverseFlag = false;
            boolean errorFlag = false;

            for (int j = 0; j < functions.length(); j++) {
                char function = functions.charAt(j);

                if (function == 'R') {
                    reverseFlag = !reverseFlag;
                } else {
                    if (deque.isEmpty()) {
                        errorFlag = true;
                        break;
                    } else if (reverseFlag) {
                        deque.pollLast();
                    } else {
                        deque.pollFirst();
                    }
                }
            }


            if (!errorFlag) {
                Integer[] result = deque.toArray(Integer[]::new);
                if (reverseFlag) {
                    Arrays.sort(result, Collections.reverseOrder());
                }

                StringBuilder sb = new StringBuilder();
                sb.append('[');
                for (int l = 0; l < deque.size(); l++) {
                    sb.append(result[l]);

                    if (l != deque.size() - 1) {
                        sb.append(',');
                    }
                }
                sb.append("]");

                if (reverseFlag) {
                    Arrays.sort(result, Collections.reverseOrder());
                }

                System.out.println(sb);
            } else {
                System.out.println("error");
            }
        }

    }

}
