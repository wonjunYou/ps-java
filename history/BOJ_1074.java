import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int n = Integer.parseInt(inputs[0]);
        int r = Integer.parseInt(inputs[1]);
        int c = Integer.parseInt(inputs[2]);

        System.out.println(func(n, r, c));
    }

    public static int func(int n, int r, int c) {
        if (n == 0) {
            return 0;
        }

        int half = 1 << (n - 1);

        if (r < half && c < half) {
            return func(n - 1, r, c);
        } else if (r < half && c >= half) {
            return half * half + func(n - 1, r, c - half);
        } else if (r >= half && c < half) {
            return 2 * half * half + func(n - 1, r - half, c);
        } else {
            return 3 * half * half + func(n - 1, r - half, c - half);
        }
    }

}
