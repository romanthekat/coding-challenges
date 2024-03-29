package main

import (
	"github.com/romanthekat/coding-challenges/LeetCode/common"
)

type ListNode struct {
	Val  int
	Next *ListNode
}

/**
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.

Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.

alternatively: original idea of a list and two pointers is good enough in execution time, wasting extra O(n) memory
*/
func reorderList(head *ListNode) {
	if head == nil {
		return
	}

	slow, fast := head, head

	//find mid
	for fast.Next != nil && fast.Next.Next != nil {
		slow = slow.Next
		fast = fast.Next.Next
	}

	//reverse second half of list
	var prev *ListNode
	curr := slow.Next
	for curr != nil {
		next := curr.Next

		curr.Next = prev
		prev = curr
		curr = next
	}
	slow.Next = nil

	//merge
	head1, head2 := head, prev
	for head2 != nil {
		next := head1.Next

		head1.Next = head2
		head1 = head2
		head2 = next
	}
}

func main() {
	reorderList(&ListNode{})
	reorderList(nil)

	node1 := ListNode{Val: 1}
	node2 := ListNode{Val: 2}
	node3 := ListNode{Val: 3}
	node4 := ListNode{Val: 4}

	node1.Next = &node2
	node2.Next = &node3
	node3.Next = &node4

	reorderList(&node1)
	head := node1
	common.AssertEqual(head.Val, 1)
	common.AssertEqual(head.Next.Val, 4)
	common.AssertEqual(head.Next.Next.Val, 2)
	common.AssertEqual(head.Next.Next.Next.Val, 3)
}
