package algo;

import util.Util;

public class QuickSort {

	public static void main(String[] args) {
		//Integer[] arr = new Integer[] {2,5,74,1,3,46,91,32,30,34,84,63,31,58,41,13,11};
		//Integer[] arr = new Integer[] {1,2,3,4,5,6,7,8,9,10};
		//Integer[] arr = new Integer[] {10,9,8,7,6,5,4,3,2,1};
		Integer[] arr = new Integer[] {3,2,1,5,6,4,10,7};
		System.out.print("Before Sort: ");
		Util.printArr(arr);
		sort(arr, 0, arr.length-1);
		System.out.println();
		System.out.print("After Sort: ");
		Util.printArr(arr);
	}
	
	static void sort(Integer[] arr, int st, int end) {

		int l=st;
		int r=end;
		int pivot = st;
		
		if(st>=end) {
			return;
		}
		
		while(true) {
			while(l<=end && arr[l]<=arr[pivot])
				l++;
			while(r>=st && arr[r]>arr[pivot])
				r--;
			if(l>r)
				break;
			if(arr[l]>arr[pivot] && arr[r]<arr[pivot]) {
				Util.swap(arr, l, r);
			}
		}
		System.out.println();
		Util.printArr(arr);
		
		Util.swap(arr, pivot, r);
		pivot = r;
		
		sort(arr, st, pivot-1);
		sort(arr, pivot+1, end);
	}
	
}
