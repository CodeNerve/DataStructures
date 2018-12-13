
public class Heaps {
	
	// Heap is very similar to a Tree but it implements array for its working
	
	// In a Heap the left child is not always smaller than right child unlike Binary trees
	
	// Heap provides very fast insertion and deletion
	// But very slow in searching and traversal
	
	
	private int[] theHeap;
	private int itemsInArray = 0;
	private int maxSize;
	
	public Heaps(int size) {
		
		maxSize = size;
		theHeap = new int[maxSize];
	}
	
	public void insert(int index,int input) {
		
		theHeap[index] = input;
		incrementTheArray();
	
	}
	
	public int pop() {
		
		if(itemsInArray!=0) {
			
			int root = theHeap[0];
			theHeap[0] = theHeap[--itemsInArray];
			
			heapTheArray(0);
			
			return root;
			
		}
		
		return -1;
		
	}
	
	public void heapTheArray(int index) {
		
		int largestChild;
		
		int root = theHeap[index];
		
		while(index<itemsInArray/2) {
			
			int leftChild = 2*index+1;
			
			
			
			
		}
		
	}
	
	public void incrementTheArray() {
		
		itemsInArray++;
	}
	
	
	public static void main(String[] args) {
		
		
		
		
		
		
		
	}

}
