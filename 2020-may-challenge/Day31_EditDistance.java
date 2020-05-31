import java.util.Objects;

import static java.lang.String.format;

class Day31_EditDistance {
    public static void main(String[] args) {
        test(new Solution().minDistance("horse", "ros"), 3);
        test(new Solution().minDistance("intention", "execution"), 5);
    }

    protected static void test(Object got, Object want) {
        System.out.println(format("%s|got: %s, want: %s", Objects.equals(got, want), got, want));
    }
}

class Solution {
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