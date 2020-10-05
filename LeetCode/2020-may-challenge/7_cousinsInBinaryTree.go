package main

import "fmt"

func main() {
	assert(isCousins(getTestTree(), 4, 3), false)
	assert(isCousins(getTestTree(), 2, 3), false)
	assert(isCousins(getTestTree(), 5, 4), true)
}

func getTestTree() *TreeNode {
	root := &TreeNode{Val: 1}
	node2 := &TreeNode{Val: 2}
	node3 := &TreeNode{Val: 3}
	node4 := &TreeNode{Val: 4}
	node5 := &TreeNode{Val: 5}

	root.Left = node2
	root.Right = node3

	node2.Left = node4

	node3.Right = node5

	return root
}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func assert(got, want interface{}) {
	fmt.Printf("got: %t, want: %t\n", got, want)
}

//solution

type LeveledTreeNode struct {
	*TreeNode
	parent *LeveledTreeNode
	level  int
}

func isCousins(root *TreeNode, x int, y int) bool {
	nodesToCheck := []*LeveledTreeNode{{TreeNode: root, level: 0}}

	var xNode *LeveledTreeNode
	var yNode *LeveledTreeNode
	for {
		if len(nodesToCheck) == 0 {
			fmt.Println("no nodes to check, but x and y nodes not found - tree structure is incorrect")
			break
		}

		nodeToCheck := nodesToCheck[0]
		nodesToCheck = nodesToCheck[1:]

		if nodeToCheck.Val == x {
			xNode = nodeToCheck
		}
		if nodeToCheck.Val == y {
			yNode = nodeToCheck
		}

		if xNode != nil && yNode != nil {
			return xNode.level == yNode.level && xNode.parent != yNode.parent
		}

		nodesToCheck = addNode(nodesToCheck, nodeToCheck, nodeToCheck.Left)
		nodesToCheck = addNode(nodesToCheck, nodeToCheck, nodeToCheck.Right)
	}

	return false
}

func addNode(nodesToCheck []*LeveledTreeNode, parentNode *LeveledTreeNode, nodeToAdd *TreeNode) []*LeveledTreeNode {
	if nodeToAdd == nil {
		return nodesToCheck
	}

	return append(nodesToCheck, &LeveledTreeNode{
		TreeNode: nodeToAdd,
		parent:   parentNode,
		level:    parentNode.level + 1,
	})
}
