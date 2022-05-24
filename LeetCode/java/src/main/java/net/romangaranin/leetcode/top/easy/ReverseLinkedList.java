package net.romangaranin.leetcode.top.easy;

import static dev.romangaranin.leetcode.Helper.*;

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
        testLinkedList(output1, 1);
        System.out.println();

        var input2 = newLinkedList(1, 2);
        var output2 = s.reverseList(input2);
        testLinkedList(output2, 2, 1);
        System.out.println();

        var input5 = newLinkedList(1, 2, 3, 4, 5);
        var output5 = s.reverseList(input5);
        testLinkedList(output5, 5, 4, 3, 2, 1);
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
