package dev.romangaranin.leetcode;

import java.util.Objects;

import static dev.romangaranin.leetcode.Helper.test;

/**
 * Merge two sorted linked lists and return it as a new sorted list. The new list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        var first = createListNode(1, 2, 4);
        var second = createListNode(1, 3, 4);
        var result = createListNode(1, 1, 2, 3, 4, 4);
        test(new Solution().mergeTwoLists(first, second), result);
        test(new Solution().mergeTwoLists(first, null), first);
        test(new Solution().mergeTwoLists(second, null), second);
        test(new Solution().mergeTwoLists(null, null), null);
    }

    static ListNode createListNode(int... values) {
        var root = new ListNode();
        var node = root;
        for (var i = 0; i < values.length; i++) {
            var val = values[i];
            if (i == 0) {
                node.val = val;
            } else {
                node.next = new ListNode(val);
                node = node.next;
            }
        }

        return root;
    }
}

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root = null;
        ListNode current = null;
        ListNode next; //alternatively: add dummy initial node, one 'active' pointer, return dummy.next

        while (true) {
            if (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    next = l1;
                    l1 = l1.next;
                } else {
                    next = l2;
                    l2 = l2.next;
                }
            } else if (l1 != null) {
                next = l1;
                l1 = l1.next;
            } else if (l2 != null) {
                next = l2;
                l2 = l2.next;
            } else {
                break;
            }

            if (current != null) {
                current.next = next;
            }
            current = next;

            if (root == null) {
                root = current;
            }
        }

        return root;
    }
}

class ListNode {
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
        return val + " " + next;
    }
}

