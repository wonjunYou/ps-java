package history;

import java.util.Arrays;
import java.util.Collections;

public class PRG_배열_정렬하기 {
  private static int[] solution(int[] arr) {
    int[] clone = arr.clone();

    Arrays.sort(clone);

    return clone;
  }

  private static int[] solution2(int[] arr) {
    Integer[] result = Arrays.stream(arr)
        .boxed()
        .distinct()
        .toArray(Integer[]::new);

    Arrays.sort(result, Collections.reverseOrder());

    return Arrays.stream(result).mapToInt(Integer::intValue).toArray();
  }

}
