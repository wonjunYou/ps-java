package core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

class BOJ_6198 {
    public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int n = Integer.parseInt(br.readLine());
            int[] buildings = new int[n];

            for (int i = 0; i < n; i++) {
                buildings[i] = Integer.parseInt(br.readLine());
            }

            Stack<Integer> stack = new Stack<>();
            long answer = 0;

            for (int i = 0; i < n; i++) {
                while (!stack.isEmpty() && stack.peek() <= buildings[i]) {
                    stack.pop();
                }

                stack.push(buildings[i]);
                answer += stack.size() - 1;
            }

            bw.write(String.valueOf(answer));
            bw.flush();
            bw.close();
            br.close();
        }
    }

}
