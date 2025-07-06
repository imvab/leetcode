package trees

import "fmt"

type TreeNode struct {
	val   int
	left  *TreeNode
	right *TreeNode
}

func NewTreeNode(val int, left, right *TreeNode) *TreeNode {
	return &TreeNode{
		val:   val,
		left:  left,
		right: right,
	}
}

type Tree struct {
	root *TreeNode
}

func NewTree() *Tree {
	return &Tree{}
}

func DFS(t *TreeNode, takeVal bool) int {
	if t == nil {
		return 0
	}

	// not taking the current val
	if !takeVal {
		return max(DFS(t.left, true)+DFS(t.right, true), DFS(t.left, false)+DFS(t.right, true), DFS(t.left, true)+DFS(t.right, false))
	}

	return DFS(t.left, false) + DFS(t.right, false) + t.val
}

func (t *Tree) MaximiseNodeSelection() int {
	return max(DFS(t.root, false), DFS(t.root, true))
}

func main() {
	tree := NewTree()
	tree.root = NewTreeNode(10, NewTreeNode(5, NewTreeNode(1, nil, nil), NewTreeNode(2, nil, nil)), NewTreeNode(6, NewTreeNode(1, nil, nil), NewTreeNode(1, nil, nil)))

	fmt.Println(tree.MaximiseNodeSelection())
}
