//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(new Comparator<int[]>() {
//            @Override
//            public int compare(int[] arr1, int[] arr2) {
//                return Integer.compare(arr2[0], arr1[0]);
//            }
//        });
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int n = Integer.parseInt(st.nextToken());
//        int m = Integer.parseInt(st.nextToken());
//        int l = Integer.parseInt(st.nextToken());
//
//        if (n == 0) {
//            maxHeap.add(new int[]{l, 0, l});
//        } else {
//            String locations = br.readLine();
//            int[] restShops = Arrays.stream(locations.split(" "))
//                .mapToInt(Integer::parseInt)
//                .toArray();
//
//            Arrays.sort(restShops);
//
//            int position = 0;
//            int distance;
//            for (int restShop : restShops) {
//                distance = restShop - position;
//                maxHeap.add(new int[]{distance, position, restShop});
//                position = restShop;
//            }
//
//            // 마지막 구간 추가
//            maxHeap.add(new int[]{l - position, position, l});
//        }
//
//        for (int i = 0; i < m; i++) {
//            int[] elements = maxHeap.poll();
//
//            if (elements != null) {
//                int newShopPosition = (elements[0] / 2) + elements[1];
//
//                maxHeap.add(new int[] {(newShopPosition - elements[1]), elements[1], newShopPosition});
//                maxHeap.add(new int[] {(elements[2] - newShopPosition), newShopPosition, elements[2]});
//            }
//        }
//
//        int[] elements = maxHeap.poll();
//
//        assert elements != null;
//        System.out.print(elements[0]);
//    }
//}
