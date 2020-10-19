package dev.romangaranin.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static dev.romangaranin.leetcode.Helper.test;
import static java.util.List.of;

public class RemoveNthNodeFromLinkedList {
    /**
     * Given the head of a linked list, remove the nth node from the end of the list and return its head.
     * <p>
     * Follow up: Could you do this in one pass?
     * <p>
     * Input: head = [1,2,3,4,5], n = 2
     * Output: [1,2,3,5]
     * <p>
     * Example 2:
     * <p>
     * Input: head = [1], n = 1
     * Output: []
     * <p>
     * Example 3:
     * <p>
     * Input: head = [1,2], n = 1
     * Output: [1]
     * <p>
     * <p>
     * Constraints:
     * <p>
     * The number of nodes in the list is sz.
     * 1 <= sz <= 30
     * <p>
     * 0 <= Node.val <= 100
     * <p>
     * 1 <= n <= sz
     *
     * @param args
     */
    public static void main(String[] args) {
        test(new Solution().removeNthFromEnd(getList(1, 2, 3, 4, 5), 2), getList(1, 2, 3, 5));
        test(new Solution().removeNthFromEnd(getList(1), 1), null);
        test(new Solution().removeNthFromEnd(getList(1, 2), 1), getList(1));
        test(new Solution().removeNthFromEnd(getList(1, 2), 2), getList(2));
    }

    static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            var fake = new ListNode();
            fake.next = head;

            var slow = fake;
            var fast = fake;

            for (var i = 1; i <= n + 1; i++) {
                fast = fast.next;
            }

            while (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }

            slow.next = slow.next.next;

            return fake.next;
        }
    }

    static ListNode getList(int... values) {
        var head = new ListNode();

        var cur = head;
        for (int value : values) {
            cur.next = new ListNode(value);
            cur = cur.next;
        }

        return head.next;
    }

    static class ListNode {
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
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ListNode listNode = (ListNode) o;
            return val == listNode.val &&
                    Objects.equals(next, listNode.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, next);
        }

        @Override
        public String toString() {
            if (next == null) {
                return String.valueOf(val);
            } else {
                return val + " " + next;
            }
        }
    }
}