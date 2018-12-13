import java.util.Scanner;

// implementation of arrays and searching with linearSearch and binarySearch

public class BasicArray {

	static int[] array;
	static int size;
	
	public BasicArray() {
		
	}
	
	public BasicArray(int[] array, int size) {
		BasicArray.array = array;
		BasicArray.size = size;
	}
	
	public int searchLinear(int input) {
		
		for(int i=0;i<size;i++) {
			if(array[i] == input)
				return i+1;
		}
		
		return -1;
	}
	
	public static int binarySearch(int input) {
		
		int low = 0;
		int high = size-1;
		int curIn;
		
		while(true) {
			
			curIn = (low+high)/2;
			
			if(array[curIn]==input)
				return curIn+1;
			
			else if(array[curIn]<input) {
				low = curIn+1;
			}
			
			else if(array[curIn]>input) {
				high = curIn -1;
			}
			
		}
		
	}
	
	
	public static void displayArray() {
		
		
		for(int i=0;i<size;i++)
			System.out.print(array[i]+" | ");
		
	}
	
	public void setSize(int size) {
		BasicArray.size = size;
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the array elements");
		
		
		int[] strings = new int[10];
		
		for(int i=0;i<strings.length;i++) {
			strings[i]= scanner.nextInt();
			scanner.nextLine();
		}
		
		displayArray();
		
		
		BasicArray arr = new BasicArray(strings,10);
		
		
		int k = binarySearch(5);
		
		
		System.out.println(k);
			
		scanner.close();
		
	}
	
}
