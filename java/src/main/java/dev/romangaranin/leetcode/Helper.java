package dev.romangaranin.leetcode;

import java.util.Objects;

import static java.lang.String.format;

public class Helper {
    public static void test(Object got, Object want) {
        System.out.println(format("%s|got: %s, want: %s", Objects.equals(got, want), got, want));
    }
}
