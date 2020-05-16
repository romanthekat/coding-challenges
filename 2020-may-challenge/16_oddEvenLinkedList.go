package main

import (
	"fmt"
)

func main() {
	assert(oddEvenList(newList([]int{1, 2, 3, 4, 5})), newList([]int{1, 3, 5, 2, 4}))
	assert(oddEvenList(newList([]int{2, 1, 3, 5, 6, 4, 7})), newList([]int{2, 3, 6, 7, 1, 5, 4}))
	assert(oddEvenList(newList([]int{42})), newList([]int{42}))
	assert(oddEvenList(newList([]int{})), newList([]int{}))
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

func assert(got, want interface{}) {
	fmt.Printf("%v|got: %v, want: %v\n", got == want, got, want)
}

type ListNode struct {
	Val  int
	Next *ListNode
}

func (l ListNode) String() string {
	return fmt.Sprintf("%d -> %v", l.Val, l.Next)
}

func oddEvenList(head *ListNode) *ListNode {
	if head == nil {
		return head
	}

	oddNode := head
	evenNode := head.Next
	firstEvenNode := evenNode

	currNode := head

	isOdd := true
	nodesChecked := 0
	for currNode != nil {
		if nodesChecked >= 2 {
			if isOdd {
				oddNode.Next = currNode
				oddNode = currNode
			} else {
				evenNode.Next = currNode
				evenNode = currNode
			}
		}

		isOdd = !isOdd
		nodesChecked++
		currNode = currNode.Next
	}

	oddNode.Next = firstEvenNode
	if evenNode != nil {
		evenNode.Next = nil
	}

	return head
}
