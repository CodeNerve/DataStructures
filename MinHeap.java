
public class MinHeap {
	
	// min Heap has the root as the smallest value element and value grows as we move downwards
	
	int capacity = 10;
	int size = 0;
	
	int[] items = new int[capacity];
	
	public int getLeftChildIndex(int parentIndex) {
		return 2*parentIndex + 1;
		
	}
	
	public int getRightChildIndex(int parentIndex) {
		return 2*parentIndex + 2;
		
	}
	
	public int getParentIndex(int childIndex) {
		return (childIndex-1)/2;
		
	}
	
	public boolean hasLeftChild(int index) {
		return getLeftChildIndex(index) < size;
		
	}
	
	public boolean hasRightChild(int index) {
		return getRightChildIndex(index) < size;
		
	}
	
	public boolean hasParent(int index) {
		return getParentIndex(index) >=0;

	}
	
	public int leftChild(int index) {
		return items[getLeftChildIndex(index)];
		
	}
	
	public int rightChild(int index) {
		return items[getRightChildIndex(index)];
		
	}
	
	public int parent(int index) {
		return items[getParentIndex(index)];
		
	}
	
	public int peek() {
		
		if(size==0) 
			throw new IllegalStateException();
		
		return items[0];
		
	}
	
	public int poll() {
		
		// remove minimum value node
		// 1. Remove the root by replacing it's value by the last indexed item in array
		// 2. Heapify down
		
		if(size==0)
			throw new IllegalStateException();
		
		int item = items[0];
		items[0] = items[size-1];
		size--;
		heapifyDown();
		
		return item;
		
	}
	
	public void swap(int index1, int index2) {
		
		int temp = items[index1];
		items[index1] = items[index2];
		items[index2] = temp;
		
	}
	
	public void add(int item) {
		
		// adding of elements is always done in the empty position in the last nodes of the heap
		
		items[size] = item;
		size++;
		heapifyUp();
		
	}
	
	public void heapifyUp() {
		
		int index = size - 1;
		
		while(hasParent(index) && parent(index)>items[index]) {
			// order needs to be adjusted
			swap(getParentIndex(index),index);
			
			index = getParentIndex(index);
			
		}
		
		
	}
	
	public void heapifyDown() {
		
		int index = 0;
		
		while(hasLeftChild(index)) {
			
			int smallerChildIndex = getLeftChildIndex(index);
			
			if(hasRightChild(index) && rightChild(index)<leftChild(index)) {
				smallerChildIndex = getRightChildIndex(index);
				
			}
			
			if(items[index]<items[smallerChildIndex])
				break;
			
			else {
				
				swap(index,smallerChildIndex);
				
			}
			
			index = smallerChildIndex;
			
		}
		
		
	}
	

}
