package main

import "fmt"

/**
  3
 / \
1   4
 \
  2
*/
func main() {
	root := &TreeNode{Val: 3}
	node1 := &TreeNode{Val: 1}
	node2 := &TreeNode{Val: 2}
	node4 := &TreeNode{Val: 4}

	root.Left = node1
	root.Right = node4
	node1.Right = node2

	assert(kthSmallest(root, 1), 1)
	assert(kthSmallest(root, 2), 2)
}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func assert(got, want interface{}) {
	fmt.Printf("%v|got: %v, want: %v\n", got == want, got, want)
}

type context struct {
	counter, value int
	finished       bool
}

func kthSmallest(node *TreeNode, k int) int {
	ctx := &context{}
	traverse(ctx, node, k)
	return ctx.value
}

func traverse(ctx *context, node *TreeNode, k int) {
	if node == nil || ctx.finished {
		return
	}

	traverse(ctx, node.Left, k)
	ctx.counter++
	if ctx.counter == k {
		ctx.value = node.Val
		ctx.finished = true
		return
	}
	traverse(ctx, node.Right, k)
}
