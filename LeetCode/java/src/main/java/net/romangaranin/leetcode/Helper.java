package net.romangaranin.leetcode;

import java.util.Arrays;
import java.util.Objects;

public class Helper {
    public static void test(Object got, Object want) {
        System.out.printf("%s|got: %s, want: %s%n", Objects.equals(got, want), got, want);
    }

    public static void testArrays(int[] got, int[] want) {
        System.out.printf("%s|got: %s, want: %s%n", Arrays.equals(got, want), Arrays.toString(got), Arrays.toString(want));
    }

    public static void testCharArrays(char[] got, char[] want) {
        System.out.printf("%s|got: %s, want: %s%n", Arrays.equals(got, want), Arrays.toString(got), Arrays.toString(want));
    }

    public static void test2dArrays(int[][] got, int[][] want) {
        System.out.printf("%s\ngot: \n%swant: \n%s%n", Arrays.deepEquals(got, want), print2dArray(got), print2dArray(want));
    }

    private static String print2dArray(int[][] a) {
        var result = new StringBuilder();
        for (var row : a) {
            result.append(String.format("%s\n", Arrays.toString(row)));
        }
        return result.toString();
    }

    public static void testLinkedList(ListNode got, int... want) {
        var curr = got;
        for (var wantValue : want) {
            System.out.printf("%s|got: %s, want: %s%n", curr.val == wantValue, curr.val, wantValue);
            curr = curr.next;
        }

        System.out.printf("%s|got: %s, want: %s%n", curr == null, curr, null);
    }

    public static ListNode newLinkedList(int... input) {
        var pseudoHead = new ListNode();

        var current = pseudoHead;
        for (var value : input) {
            current.next = new ListNode(value);
            current = current.next;
        }

        return pseudoHead.next;
    }

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            if (next != null) {
                return val + " " + next;
            } else {
                return String.valueOf(val);
            }
        }
    }

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }



        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
