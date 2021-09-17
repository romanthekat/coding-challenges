package dev.romangaranin.leetcode.top.easy;

import static dev.romangaranin.leetcode.Helper.*;

/**
 * Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both l1 and l2 are sorted in non-decreasing order.
 */
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        var s = new Solution();

        var output1 = s.mergeTwoLists(newLinkedList(1, 2, 4), newLinkedList(1, 3, 4));
        testLinkedList(output1, 1, 1, 2, 3, 4, 4);
        System.out.println();

        var output2 = s.mergeTwoLists(newLinkedList(), newLinkedList());
        test(output2, null);
        System.out.println();

        var output3 = s.mergeTwoLists(newLinkedList(), newLinkedList(0));
        testLinkedList(output3, 0);
        System.out.println();
    }

    static class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode head = new ListNode();
            ListNode curr = head;

            while (l1 != null || l2 != null) {
                if (l1 != null && l2 != null) {
                    if (l1.val < l2.val) {
                        curr.next = l1;
                        curr = l1;
                        l1 = l1.next;
                    } else {
                        curr.next = l2;
                        curr = l2;
                        l2 = l2.next;
                    }
                } else if (l1 != null) {
                    curr.next = l1;
                    break;
                } else if (l2 != null) {
                    curr.next = l2;
                    break;
                }
            }

            return head.next;
        }
    }
}
