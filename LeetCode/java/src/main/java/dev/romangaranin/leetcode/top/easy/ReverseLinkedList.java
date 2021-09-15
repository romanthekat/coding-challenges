package dev.romangaranin.leetcode.top.easy;

import static dev.romangaranin.leetcode.Helper.test;

/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        var s = new Solution();

        var input0 = newLinkedList();
        var output0 = s.reverseList(input0);
        test(output0, null);
        System.out.println();

        var input1 = newLinkedList(1);
        var output1 = s.reverseList(input1);
        test(output1.val, 1);
        test(output1.next, null);
        System.out.println();

        var input2 = newLinkedList(1, 2);
        var output2 = s.reverseList(input2);
        test(output2.val, 2);
        test(output2.next.val, 1);
        test(output2.next.next, null);
        System.out.println();

        var input5 = newLinkedList(1, 2, 3, 4, 5);
        var output5 = s.reverseList(input5);
        test(output5.val, 5);
        test(output5.next.val, 4);
        test(output5.next.next.val, 3);
        test(output5.next.next.next.val, 2);
        test(output5.next.next.next.next.val, 1);
        test(output5.next.next.next.next.next, null);
    }

    private static ListNode newLinkedList(int... input) {
        var pseudoHead = new ListNode();

        var current = pseudoHead;
        for (var value : input) {
            current.next = new ListNode(value);
            current = current.next;
        }

        return pseudoHead.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    '}';
        }
    }

    static class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;
            ListNode next = null;

            while (curr != null) {
                next = curr.next;
                curr.next = prev;

                prev = curr;
                curr = next;
            }

            return prev;
        }
    }
}
