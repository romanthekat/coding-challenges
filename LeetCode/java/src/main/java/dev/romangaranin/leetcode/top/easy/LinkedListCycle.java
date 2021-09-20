package dev.romangaranin.leetcode.top.easy;

import dev.romangaranin.leetcode.Helper.ListNode;

import static dev.romangaranin.leetcode.Helper.newLinkedList;
import static dev.romangaranin.leetcode.Helper.test;

/**
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * <p>
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 * <p>
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 * <p>
 * <p>
 * The number of the nodes in the list is in the range [0, 10^4].
 * -10^5 <= Node.val <= 10^5
 * pos is -1 or a valid index in the linked-list.
 * <p>
 * Follow up: Can you solve it using O(1) (i.e. constant) memory?
 */
public class LinkedListCycle {
    public static void main(String[] args) {
        var s = new Solution();

        var input1 = newLinkedList(1, 2, 3, 4);
        input1.next.next.next.next = input1;
        test(s.hasCycle(input1), true);

        var input2 = newLinkedList(1, 2, 3, 4);
        input2.next.next.next.next = input2.next;
        test(s.hasCycle(input2), true);

        var input3 = newLinkedList(1, 2, 3, 4);
        test(s.hasCycle(input3), false);

        var input4 = newLinkedList(1, 2);
        test(s.hasCycle(input4), false);

        var input5 = newLinkedList(1, 2);
        input5.next.next = input5;
        test(s.hasCycle(input5), true);

        var input6 = newLinkedList(1);
        input6.next = input6;
        test(s.hasCycle(input6), true);
    }

    static class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null) {
                return false;
            }

            var slow = head;
            var fast = head;

            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;

                if (slow == fast) {
                    return true;
                }
            }

            return false;
        }
    }

}
