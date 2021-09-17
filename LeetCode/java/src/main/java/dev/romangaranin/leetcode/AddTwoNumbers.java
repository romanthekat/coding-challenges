package dev.romangaranin.leetcode;

import dev.romangaranin.leetcode.Helper.ListNode;

import static dev.romangaranin.leetcode.Helper.newLinkedList;

/**
 * https://leetcode.com/problems/add-two-numbers/
 * <p>
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse
 * order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8 Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

/*        ListNode result = addTwoNumbers.addTwoNumbers(
                createListNode(Arrays.asList(2, 4, 3)),
                createListNode(Arrays.asList(5, 6, 4)));
        System.out.println(result);*/

        ListNode result = addTwoNumbers.addTwoNumbers(
                newLinkedList(9),
                newLinkedList(1, 9, 9, 9, 9, 9, 9, 9, 9, 9));
        System.out.println(result);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode currentL1 = l1;
        ListNode currentL2 = l2;

        ListNode l3 = null;
        ListNode currentL3 = null;

        int extra = 0;

        while (currentL1 != null || currentL2 != null) {
            int interim = getValue(currentL1) + getValue(currentL2) + extra;

            if (interim >= 10) {
                interim -= 10;
                extra = 1;
            } else {
                extra = 0;
            }

            if (l3 == null) { //TODO can be done without if
                l3 = new ListNode(interim);
                currentL3 = l3;
            } else {
                currentL3 = addNewNode(currentL3, interim);
            }

            if (currentL1 != null) {
                currentL1 = currentL1.next;
            }

            if (currentL2 != null) {
                currentL2 = currentL2.next;
            }
        }

        if (extra != 0) {
            addNewNode(currentL3, extra); //TODO can be covered in main cycle
        }

        return l3;
    }

    private ListNode addNewNode(ListNode currentL3, int value) {
        currentL3.next = new ListNode(value);
        currentL3 = currentL3.next;

        return currentL3;
    }

    private int getValue(ListNode l) {
        if (l != null) {
            return l.val;
        } else {
            return 0;
        }
    }
}
