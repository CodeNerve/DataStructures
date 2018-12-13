
public class BinaryTrees {
	
	// Trees provide quick insertion, searching and deletion
	// Time to do any operation on a Tree is O(log N), so we can see why it is such a great data structure
	
	// Top node of the Tree is called it's root, Leaf is a node that does not have any children nodes to it
	
	
	// Binary trees are special trees which only have two or less children each node and always the parent has mid value, left child has
	// smaller value and right child has larger value, NOTE that right child MUST be greater than both parent and left child and left child
	// needs to be smaller than both parent and right child; for the tree to  be called Binary tree.
	
	// Unbalanced trees are those trees in which most of the data is found on one particular side of the whole tree, either left or right
	
	Node root;
	
	public void addNode(int key, String name) {
		
		Node newNode = new Node(key, name);
		
		if(root == null)
			root = newNode;
		
		else {
			
			Node focusNode = root;
			
			Node parent;
			
			while(true) {
				
				
				parent = focusNode;
				
				if(key < focusNode.key) {
					
					focusNode = focusNode.leftChild;
					
					if(focusNode == null) {
						
						parent.leftChild = newNode;
						return;
						
					}
					
				}
				
				else {
					
					focusNode = focusNode.rightChild;
					
					if(focusNode == null) {
						
						parent.rightChild = newNode;
						return;
						
					}
					
					
				}
				
			}
			
		}
		
	}
	
	// Deleting a node is the only thing that is a bit longer and complex relatively and so is important too!!!
	
	public boolean remove(int key) {
		
		
		Node focusNode = root;
		Node parent = root;
		
		boolean isItLeftChild = true;
		
		while(focusNode.key!=key) {
			
			parent = focusNode;
			
			if(key < focusNode.key) {
				
				isItLeftChild = true;
				
				focusNode = focusNode.leftChild;
				
			}
			
			else {
				
				isItLeftChild = false;
				
				focusNode = focusNode.rightChild;
				
				
			}
			
			if(focusNode == null)
				return false;
			
			
		}
	
		if(focusNode.leftChild == null && focusNode.rightChild == null) {
			
			
			if(focusNode == root)
				root = null;
			
			else if(isItLeftChild) {
				
				parent.leftChild = null;
				
			}
			else
				parent.rightChild = null;
			
		}
		
		else if(focusNode.rightChild == null) {
			
			if(focusNode == root)
				root = focusNode.leftChild;
			
			else if(isItLeftChild) {
				
				parent.leftChild = focusNode.leftChild;	
				
			}
			
			else
				parent.rightChild = focusNode.leftChild;
			
			
		}
		
		else if(focusNode.leftChild == null) {
			
			
			if(focusNode == root)
				root = focusNode.rightChild;
			
			else if(isItLeftChild)
				parent.leftChild = focusNode.rightChild;
			
			else
				parent.rightChild = focusNode.leftChild;
			
		}
		
		else {
			
			
			Node replacement = getReplacementNode(focusNode);
			
			if(focusNode == root)
				root = replacement;
			
			else if(isItLeftChild)
				parent.leftChild = replacement;
			
			else
				parent.rightChild = replacement;
			
			
			replacement.leftChild = focusNode.leftChild;
			
		}
		
		return true;
		
	}
	
	public Node getReplacementNode(Node toReplaceNode) {
		
		Node replacementParent = toReplaceNode;
		Node replacement = toReplaceNode;
		
		
		Node focusNode = toReplaceNode.rightChild;
		
		
		while(focusNode != null) {
			
			replacementParent = replacement;
			replacement = focusNode;
			focusNode = focusNode.leftChild;
			
		}
		
		if(replacement!=toReplaceNode.leftChild) {
			
			replacementParent.leftChild = replacement.rightChild;
			
			replacement.rightChild = toReplaceNode.rightChild;
			
			
		}
		
		return replacement;
		
	}
	
	
	// There are three types of traversal in Trees, In-Order traversal aims for the smallest value first (start from left child from root)
	
	public void inOrderTraverseTree(Node focusNode) {
		
		if(focusNode!=null) {
			
			inOrderTraverseTree(focusNode.leftChild);
			
			System.out.println(focusNode);
			
			inOrderTraverseTree(focusNode.rightChild);
			
		}
		
		
	}
	
	// Second traversing way of Trees is Pre-order Traversal
	
	public void preOrderTraverseTree(Node focusNode) {
		
		if(focusNode!=null) {
			
			System.out.println(focusNode);
			
			preOrderTraverseTree(focusNode.leftChild);
			
			preOrderTraverseTree(focusNode.rightChild);
			
		}
		
		
	}
	
	// Third traversing way of Trees
	
	public void postOrderTraverseTree(Node focusNode) {
		
		if(focusNode!=null) {
			
			postOrderTraverseTree(focusNode.leftChild);
			
			postOrderTraverseTree(focusNode.rightChild);
			
			System.out.println(focusNode);
			
		}
		
		
	}
	
	
	public static void main(String[] args) {
		
		
		BinaryTrees tree = new BinaryTrees();
		
		
		tree.addNode(50, "Boss");
		tree.addNode(25, "Vice presidnet");
		tree.addNode(15, "Manager");
		tree.addNode(30, "Secretary");
		tree.addNode(75, "Sales Manager");
		tree.addNode(80, "SalesMan");
		
		tree.inOrderTraverseTree(tree.root);
		
		System.out.println();
		
		tree.preOrderTraverseTree(tree.root);
		
		System.out.println();
		
		tree.postOrderTraverseTree(tree.root);
		
		System.out.println();
		
		
		System.out.println(tree.findNode(30));
		
		
		System.out.println();
		
		tree.remove(15);
		
		System.out.println("Removed 15");
		
		System.out.println();
		
		tree.inOrderTraverseTree(tree.root);
		
	}
	
	public Node findNode(int key) {
		
		Node focusNode = root;
		
		while(focusNode.key!=key) {
			
			if(key < focusNode.key)
				focusNode = focusNode.leftChild;
			
			else
				focusNode = focusNode.rightChild;
			
			if(focusNode == null)
				return null;
			
			
		}
		
		return focusNode;
		
	}
	

}

class Node {
	
	int key;
	String name;
	
	Node leftChild;
	Node rightChild;
	
	
	public Node(int key, String name) {
		
		this.key = key;
		this.name = name;
	}
	
	
	@Override
	public String toString() {
		
		return name+" with key "+key;
	}
	
	
	
	
	
}
