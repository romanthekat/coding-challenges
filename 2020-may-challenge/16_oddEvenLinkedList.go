package main

import (
	"fmt"
)

func main() {
	assert(oddEvenList(newList([]int{1, 2, 3, 4, 5})), newList([]int{1, 3, 5, 2, 4}))
	assert(oddEvenList(newList([]int{2, 1, 3, 5, 6, 4, 7})), newList([]int{2, 3, 6, 7, 1, 5, 4}))
	assert(oddEvenList(newList([]int{42})), newList([]int{42}))
	assert(oddEvenList(nil), nil)
}

func assert(got, want interface{}) {
	fmt.Printf("%v|got: %v, want: %v\n", got == want, got, want)
}

func newList(values []int) *ListNode {
	head := &ListNode{Val: values[0]}
	currNode := head

	for _, value := range values {
		if value == values[0] {
			continue
		}

		currNode.Next = &ListNode{Val: value}
		currNode = currNode.Next
	}

	return head
}

type ListNode struct {
	Val  int
	Next *ListNode
}

func (l ListNode) String() string {
	return fmt.Sprintf("%d -> %v", l.Val, l.Next)
}

func oddEvenList(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}

	oddNode, evenNode := head, head.Next
	firstEvenNode := evenNode

	for oddNode.Next != nil && evenNode.Next != nil {
		oddNode.Next = oddNode.Next.Next
		evenNode.Next = evenNode.Next.Next

		oddNode = oddNode.Next
		evenNode = evenNode.Next
	}

	oddNode.Next = firstEvenNode

	return head
}
