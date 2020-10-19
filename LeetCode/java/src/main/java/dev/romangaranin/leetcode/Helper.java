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

    public static void test2dArrays(int[][] got, int[][] want) {
        System.out.printf("%s\ngot: \n%swant: \n%s%n", Arrays.equals(got, want), print2dArray(got), print2dArray(want));
    }

    private static String print2dArray(int[][] a) {
        var result = new StringBuilder();
        for (var row : a) {
            result.append(String.format("%s\n", Arrays.toString(row)));
        }
        return result.toString();
    }
}
