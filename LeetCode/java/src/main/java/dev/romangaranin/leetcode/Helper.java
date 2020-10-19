package dev.romangaranin.leetcode;

import java.util.Arrays;
import java.util.Objects;

import static java.lang.String.format;

public class Helper {
    public static void test(Object got, Object want) {
        System.out.printf("%s|got: %s, want: %s%n", Objects.equals(got, want), got, want);
    }

    public static void testArrays(int[] got, int[] want) {
        System.out.printf("%s|got: %s, want: %s%n", Arrays.equals(got, want), Arrays.toString(got), Arrays.toString(want));
    }
}
