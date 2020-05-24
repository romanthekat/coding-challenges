package main

import (
	"fmt"
	"reflect"
)

func main() {
	root := bstFromPreorder([]int{8, 5, 1, 7, 10, 12})
	fmt.Printf("%v", root)
}

func assert(got, want interface{}) {
	fmt.Printf("%v|got: %v, want: %v\n", reflect.DeepEqual(got, want), got, want)
}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func (t TreeNode) String() string {
	return fmt.Sprintf("%v %v %v", t.Left, t.Val, t.Right)
}

func bstFromPreorder(preorder []int) *TreeNode {
	var root *TreeNode

	for _, value := range preorder {
		if root == nil {
			root = &TreeNode{Val: value}
		} else {
			node := root
			for {
				if value < node.Val {
					if node.Left == nil {
						node.Left = &TreeNode{Val: value}
						break
					} else {
						node = node.Left
					}
				} else {
					if node.Right == nil {
						node.Right = &TreeNode{Val: value}
						break
					} else {
						node = node.Right
					}
				}
			}
		}
	}

	return root
}
