package algo;

import java.util.List;

import ds.MaxHeap;

public class HeapSort {

	public static void main(String[] args) {
		
		Integer[] arr = new Integer[] {2,5,74,1,3,46,91,32,34,84,63,31,58,41,13,11};
		MaxHeap heap = new MaxHeap(arr);
		for(int i=0; i<arr.length; i++) {
			heap.getMax();
		}
		List<Integer> sortedList = heap.getMaxHeap();
		System.out.println("HeapSize: "+heap.getHeapSize());
		System.out.print("Sorted Heap: ");
		for(int i : sortedList) {
			System.out.print(i+", ");
		}
	}
	
}
