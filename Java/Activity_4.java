package Activitiy1;

public class Activity_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers= {5,2,9,1,6,3};
		
		System.out.println("before soring:");
		printArray(numbers);
		
		insertionSort(numbers);
		
		System.out.println("after sorting:");
		printArray(numbers);
		
	}	


	private static void insertionSort(int[] arr) {
		for (int i = 1; i< arr.length; i++) {
			int key = arr[i];
			int j=i-1;
			
			while(j>= 0 && arr[j] > key) {
				arr[j+ 1] = key;
				j--;
			}
		
		    arr[j+1] = key;
		}
	}
	
		private static void printArray(int[] arr) {
			for(int n : arr) {
				System.out.print(n + " ");
		}
			
		System.out.println();
	}
}
		
