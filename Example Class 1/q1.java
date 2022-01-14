public class q1 {

	public static void main(String[] args) {
		final int SIZE = 99999;
		final int S = 5;//S
		int[] array = new int[SIZE];//create array
		
		for(int i = 0; i<SIZE; i++) {//create array
			array[i] = SIZE-i;
		}
		
		long startTime = System.nanoTime();//start time
		insertmergesort.mergesort(array, 0, array.length-1, S);//implement mergesort
		long endTime = System.nanoTime();//end time
		
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");//check for correctness of resultant array
		}
		
		System.out.println();
		
		System.out.println("Q1");
		
		System.out.println("Took: "+(endTime - startTime) + " ns");//time taken
		
	}
}

class insertmergesort{
	static void mergesort(int[] array1, int n, int m, int S) {//main mergesort method
		int mid = (n+m)/2;//find mid of array
		if(m-n+1 <= S)insertion(array1, n, m);//if size of subarray <= S, implement insertion
		else{
			mergesort(array1, n, mid, S);//split subarray into 2
			mergesort(array1, mid+1, m, S);//split subarray into 2
		}
		merge(array1, n, m);//merge subarrays
		
	}
	
	static void merge(int[] array1, int n, int m) {
		if(m-n <= 0)return;
		int mid = (m+n)/2;//find mid of array
		int a = n;//set 'a' at start of subarray
		int b = mid+1;//set 'b' after mid of subarray
		int temp;
		
		while(a<=mid && b<=m) {//while both lists are not empty
			if(array1[a] < array1[b]) {//if 'a' is smaller, leave the element in 'a' to be in the sorted list and increment 'a' by 1
				a++;
			}
			else if(array1[a] > array1[b]) {//if 'b' is smaller, move the element in 'b' to position 'a' to join the sorted list, and move the other elements up by 1 position
				temp = array1[b];//store element in temp
				for(int i = b; i > a; i--) {//move the first subarray up by 1
					array1[i] = array1[i-1];
				}
				array1[a] = temp;//store temp in sorted list
				a++;//increment 'a', mid and 'b'
				mid++;
				b++;
			}
			else {//if elements in 'a' and 'b' are equal
				temp = array1[b];//store element in 'b' in temp
				for(int i = b; i > a+1; i--) {//move the first subarray up by 1
					array1[i] = array1[i-1];
				}
				array1[a+1] = temp;//store element in 'a' and temp in sorted list
				a+=2;//increment 'a', mid and 'b'
				mid++;
				b++;
			}
		}
	}
	
	static void insertion(int[] array1, int n, int m) {
		int temp;
		
		for(int i = n; i <= m; i++) {//find each element's correct position
			for(int j = i; j > 0; j--) {//find correct position to insert element
				if(array1[j] < array1[j-1]) {//move element to the left
					temp = array1[j];
					array1[j] = array1[j-1];
					array1[j-1] = temp;
				}
				else break;//element in correct position
			}
		}
	}
}