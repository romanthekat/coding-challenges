package main

import "fmt"

func main() {
	trie := Constructor()

	trie.Insert("apple")

	assert(trie.Search("apple"), true)
	assert(trie.Search("app"), false)
	assert(trie.StartsWith("app"), true)

	trie.Insert("app")
	assert(trie.Search("app"), true)

}

func assert(got, want interface{}) {
	fmt.Printf("%t|got: %t, want: %t\n", got == want, got, want)
}

type Trie struct {
	root *Node
}

type Node struct {
	value    rune
	wordEnd  bool
	children map[rune]*Node //alternatively: use rune/int array
}

/** Initialize your data structure here. */
func Constructor() Trie {
	return Trie{root: NewNode()}
}

func NewNode() *Node {
	return &Node{children: make(map[rune]*Node)}
}

func NewNodeWithValue(value rune) *Node {
	return &Node{value: value, children: make(map[rune]*Node)}
}

/** Inserts a word into the trie. */
func (t *Trie) Insert(word string) {
	node := t.root

	for _, char := range word {
		child, ok := node.children[char]
		if !ok {
			child = NewNodeWithValue(char)
			child.value = char
			node.children[char] = child
		}

		node = child
	}

	node.wordEnd = true
}

/** Returns if the word is in the trie. */
func (t *Trie) Search(word string) bool {
	node, found := t.findNode(word)
	if !found {
		return false
	}

	return node.wordEnd
}

/** Returns if there is any word in the trie that starts with the given prefix. */
func (t *Trie) StartsWith(prefix string) bool {
	_, found := t.findNode(prefix)
	return found
}

func (t *Trie) findNode(prefix string) (*Node, bool) {
	node := t.root
	for _, char := range prefix {
		if child, ok := node.children[char]; !ok {
			return nil, false
		} else {
			node = child
		}
	}

	return node, true
}
