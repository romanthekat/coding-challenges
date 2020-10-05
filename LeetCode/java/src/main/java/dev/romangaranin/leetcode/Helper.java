package dev.romangaranin.leetcode;

import java.util.Objects;

import static java.lang.String.format;

public class Helper {
    public static void test(Object got, Object want) {
        System.out.printf("%s|got: %s, want: %s%n", Objects.equals(got, want), got, want);
    }
}
