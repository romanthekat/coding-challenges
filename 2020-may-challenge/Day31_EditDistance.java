import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static java.lang.String.format;

class Day31_EditDistance {
    public static void main(String[] args) {
        test(new Solution().minDistance("horse", "ros"), 3);
        test(new Solution().minDistance("intention", "execution"), 5);
        test(new Solution().minDistance("dinitrophenylhydrazine", "acetylphenylhydrazine"), 5);
    }

    protected static void test(Object got, Object want) {
        System.out.println(format("%s|got: %s, want: %s", Objects.equals(got, want), got, want));
    }
}

class Solution {
    public int minDistance(String from, String to) {
        return minDistance(from, to, 0, 0, new HashMap<>());
    }

    int minDistance(String from, String to, int i, int j, Map<Pair, Integer> cache) {
        if (from.length() == 0 && to.length() == 0) {
            return 0;
        }
        if (from.length() == 0) {
            return to.length();
        }
        if (to.length() == 0) {
            return from.length();
        }

        var state = new Pair(i, j);
        if (!cache.containsKey(state)) {
            var answer = 0;
            if (from.charAt(0) == to.charAt(0)) {
                answer = minDistance(from, to, i + 1, j + 1, cache);
            } else {
                var insert = 1 + minDistance(from, to, i, j + 1, cache);
                var remove = 1 + minDistance(from, to, i + 1, j, cache);
                var change = 1 + minDistance(from, to, i + 1, j + 1, cache);

                answer = Math.min(insert, Math.min(remove, change));
            }

            cache.put(state, answer);
            System.out.println("cache updated");
        }

        return cache.get(state);
    }

    static class Pair {
        int i;
        int j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}

class SolutionNaiveRecursive {
    public int minDistance(String from, String to) {
        if (from.length() == 0 && to.length() == 0) {
            return 0;
        }
        if (from.length() == 0) {
            return to.length();
        }
        if (to.length() == 0) {
            return from.length();
        }

        if (from.charAt(0) == to.charAt(0)) {
            return minDistance(from.substring(1), to.substring(1));
        }

        var insert = 1 + minDistance(from, to.substring(1));
        var remove = 1 + minDistance(from.substring(1), to);
        var change = 1 + minDistance(from.substring(1), to.substring(1));

        return Math.min(insert, Math.min(remove, change));
    }
}