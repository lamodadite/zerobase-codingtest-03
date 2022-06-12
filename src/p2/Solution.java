package p2;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static int solution(int[] numbers, int target) {
        Map<Integer, Set<Integer>> dp = new HashMap<>();
        Set<Integer> set = Arrays.stream(numbers).
                boxed().collect(Collectors.toSet());

        dp.put(1, set);

        if (set.contains(target)) {
            return 1;
        }

        for (int i = 2; i <= 100; i++) {
            set = new HashSet<>();

            for (int j = 1; j <= i / 2; j++) {
                Set<Integer> set1 = dp.get(j);
                Set<Integer> set2 = dp.get(i - j);

                for (int x: set1) {
                    for (int y: set2) {
                        int addVal = x + y;
                        int multVal = x * y;

                        if (addVal == target || multVal == target) {
                            return i;
                        }

                        if (addVal < target) {
                            set.add(addVal);
                        }
                        if (multVal < target) {
                            set.add(multVal);
                        }
                    }
                }
            }
            dp.put(i, set);
        }
        return -1;
    }
}