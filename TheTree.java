
public class TheTree {
	
	
	// You should have read some info about Trees in the BinaryTrees class.
	// Here we will discuss and re-implement binary search trees fundamentally and meticulously along with its important algorithms  :)
	
	// So Binary Trees are those trees which have only two child nodes for any parent node, 
	
	// Binary Search Trees are mostly the trees we talk about when we refer Binary Trees, they are important because Searching is very fast in it
	
	// Binary Search Trees are trees with every parent node having two child nodes, left child node and right child node
	// Left Child Node is the one which is smaller then parent node, and Right Child Node is the one which is larger than Parent node
	
	// Unbalanced Tree is the one with elements with higher value all being inclined to one particular side, making it be like a list and decrease the performance from O(log n) to O(n)
	// Balanced Tree is the one with everything balanced and so good for us to use in terms of performance
	
	// There are three major types of (Height First) Traversal in a Balanced tree, which are:
	// 1. In-order Traversal: left then root then right
	// 2. Pre-order Traversal: root then left then right
	// 3. Post-order Traversal: left then right then root
	
	// There is also a Breadth First Traversal, which travereses the tree along its width
	
	// Typically in Binary Search Trees (Balanced) we do In-order Traversal, as this mostly is the ascending order of values in the nodes
	
	// Recursion is almost the basis for all operations on Trees, so be prepared to see Recursion in almost all the steps
	
	
	
	public static void main(String[] args) {
		
		
		NodeChild node = new NodeChild(5);
		
		node.insert(50);
		node.insert(30);
		node.insert(20);
		node.insert(40);
		node.insert(70);
		node.insert(60);
		node.insert(80);
		
		node.printInOrder();
		
		System.out.println();
		
		
		node.deleteRec(node, 10);
		
		node.printInOrder();
		
		System.out.println();
		
		node.deleteRec(node, 60);
		
		node.printInOrder();
		
		
	}
	
	

	
	

}


class NodeChild{
	
	NodeChild left,right;
	int data;
	
	
	public NodeChild(int data) {
		
		this.data = data;
		
	}


	public void insert(int value) {
		
		if(value<data) {
			
			
			if(left == null)
				left = new NodeChild(value);
			
			else 
				left.insert(value);
		
		}
		
		else {
			
			
			if(right == null)
				right = new NodeChild(value);
			
			else
				right.insert(value);
			
		}
		
		
	}
	
	
	public boolean contains(int value) { 
		
		if( data == value)
			return true;
		
		else if(value < data) {
			
			if(left == null)
				return false;
			
			else
				return left.contains(value);
			
		}
		
		else {
			
			if(right == null)
				return false;
			
			else
				return right.contains(value);
			
		}	
		
	}
	
	public void printInOrder() { // In-Order is Left, Root, Right (Incresing order of values)
		
		if(left!=null)
			left.printInOrder();
		
		System.out.println(data);
		
		if(right!=null)
			right.printInOrder();
		
		
	}
	
	public void printPreOrder(NodeChild root) { // Pre-Order is Root, Left, Right
		
		if(root!=null)
			System.out.println(root.data);
		
		if(root.left!=null)
			printPreOrder(root.left);
		
		if(root.right!=null)
			printPreOrder(root.right);
		
		
	}
	
	
	public NodeChild deleteRec(NodeChild root, int value) {
		
					
			// leaf node is easy to delete, just set the parent node's right/left child to null
		
			// to delete a node with one child node, we have to set the parent node of the to-be-deleted node to its child node
		
			// to delete a node with one child node, we have to set the parent node of the to-be-deleted node to its child node
		
			// to delete a node with two children we exploit some properties of trees, one is that the child with minimum value in a sub tree can NOT have a left node
			// the procedure we follow to achieve this is:
		    // 1. Find the minimum value in right subtree of the node to-be-deleted
			// 2. Copy the value in to-be-deleted node
			// 3. Delete duplicate from right sub-tree (which of course, will not be having two childs) (do you see why..?)
					
			// There is also one more method to do what we have done in above algorithm, that is:
			// 1. Find the maximum value in left subtree of the node to-be-deleted
			// 2. Copy the valu in to-be-deleted node
			// 3. Delete duplicate from left sub-tree
					
		if (root == null)  
			return root; 
		  
        /* Otherwise, recur down the tree */
        
		if (value < root.data) 
            root.left = deleteRec(root.left, value); 
		
		
        else if (value > root.data) 
            root.right = deleteRec(root.right, value); 
  
        // if key is same as root's key, then This is the node to be deleted 
		
        else { 
            
        	// node with only one child or no child 
        	
            if (root.left == null) 
                return root.right; 
            
            
            else if (root.right == null) 
                return root.left; 
  
            // node with two children: Get the inorder successor (smallest in the right subtree) 
            
            root.data = minValue(root.right); 
  
            // Delete the inorder successor 
            root.right = deleteRec(root.right, root.data); 
        } 
  
        return root; 	
	}
	
	public int minValue(NodeChild root) { 
		
        int minv = root.data; 
        
        while (root.left != null) {
        	
            minv = root.left.data; 
            root = root.left; 
            
        } 
        
        return minv; 
    } 
	
}