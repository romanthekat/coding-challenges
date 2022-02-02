"""
Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL

Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?
"""
from common import assert_equal


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        cur = head
        prev = None

        while cur:
            next = cur.next

            cur.next = prev
            prev = cur
            cur = next

        return prev


if __name__ == '__main__':
    s = Solution()

    linked_list = ListNode(1, ListNode(2, ListNode(3, ListNode(4))))
    reversed_list = s.reverseList(linked_list)

    assert_equal(reversed_list.val, 4)
    assert_equal(reversed_list.next.val, 3)
    assert_equal(reversed_list.next.next.val, 2)
    assert_equal(reversed_list.next.next.next.val, 1)
    print()

    linked_list = ListNode(1, ListNode(2, ListNode(3)))
    reversed_list = s.reverseList(linked_list)

    assert_equal(reversed_list.val, 3)
    assert_equal(reversed_list.next.val, 2)
    assert_equal(reversed_list.next.next.val, 1)
    print()

    linked_list = ListNode(1, ListNode(2))
    reversed_list = s.reverseList(linked_list)
    assert_equal(reversed_list.val, 2)
    assert_equal(reversed_list.next.val, 1)
    print()

    reversed_list = s.reverseList(ListNode(1))
    assert_equal(reversed_list.val, 1)
