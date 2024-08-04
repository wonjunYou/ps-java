package history;

import java.io.*;
import java.util.*;

public class BOJ_14725 {
    static StringBuilder result = new StringBuilder();
    static TreeMap<String, TreeMap> treeMap = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k;

        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");
            k = Integer.parseInt(inputs[0]);

            TreeMap currentFoodInfo = treeMap;

            for (int j = 0; j < k; j++) {
                String food = inputs[j + 1];

                if (!currentFoodInfo.containsKey(food)) {
                    currentFoodInfo.put(food, new TreeMap<>());
                }

                currentFoodInfo = (TreeMap)currentFoodInfo.get(food);
            }
        }

        draw(treeMap, 0);

        System.out.println(result);
    }

    private static void draw(TreeMap<String, TreeMap> treeMap, int nodeCount) {
        for (Object food : treeMap.keySet()) {
            for (int i = 0; i < nodeCount; i++) {
                result.append("--");
            }
            result.append(food).append("\n");

            draw(treeMap.get(food), nodeCount + 1);
        }
    }

}
