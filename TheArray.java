
public class TheArray {
	
	// some algorithms and operation of array except for the ones in BasicArray
	
	private int[] array;
	private int size;
	private int itemsInArray = 0;
	
	public TheArray(int size) {
		this.size = size;
		array = new int[size];
		
	}
	
	public void displayArray() {
		
		
		for(int i=0;i<size;i++) {
			System.out.println(i+" | "+array[i]);
			System.out.println("__|__");
		}
		
		
	}
	
	public void addElement(int element) {
		
		array[itemsInArray++] = element;
		size++;
		
		System.out.println();
		
		displayArray();
		
	}
	
	public void selectionSort() {
		
		for (int c = 0; c < (size - 1); c++)
		  {
		    int position = c;
		   
		    for (int d = c + 1; d < size; d++)
		    {
		      if (array[position] > array[d])
		        position = d;
		    }
		    if (position != c)
		    {
		      int swap = array[c];
		      array[c] = array[position];
		      array[position] = swap;
		    }
		  }
		
	}
	
	public void insertionSort() {
		
		
		for(int i=0;i<size;i++) {
			
			int j=i;
			
			int toInsert = array[i];
			
			while(j>0 && array[j-1]>toInsert) {
				
				
				array[j]=array[j-1];
				j--;
				
				
			}
			
			array[j] = toInsert;
			
		}
		
		
	}
	
	public void generateRandomArray() {
		
		
		for(int i=0;i<size;i++)
			array[i] = (int) (Math.random()*1000) + 10;
		
		
		itemsInArray = size - 1;
	}
	
	
	public void deleteElementAtIndex(int index) {
		
		if(index>size)
			return;
		
		else {
			
			System.out.println("Element found at "+index+" was "+array[index]+" which is now deleted");
			System.out.println();
			
			for(int i=index;i<(size-1);i++) {
				array[i]=array[i+1];
			}
			
			size--;
			
			
			
			displayArray();
				
		}
		
	}
	
	public static void main(String[] args) {
		
		
		TheArray theArray = new TheArray(10);
		theArray.generateRandomArray();
		
		theArray.displayArray();
		
		System.out.println();
		
	//	theArray.deleteElementAtIndex(3);
		
	//	theArray.addElement(256);
		
		theArray.insertionSort();
		
		System.out.println();
		
		theArray.displayArray();
		
		
	}

}
