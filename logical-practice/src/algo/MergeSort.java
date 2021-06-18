package algo;

import util.Util;

public class MergeSort {

	
	public static void main(String[] args) {
		
		int[] arr = new int[] {2,5,74,1,3,46,91,32,34,84,63,31,58,41,13,11};
		//int[] arr = new int[] {5,4,3,2,1,0};
		
		Integer[] mergedArr = divide(arr, 0, arr.length-1);
		
		System.out.print("Sorted Array: ");
		Util.printArr(mergedArr);
	}
	
	static Integer[] divide(int arr[], int st, int end) {
		
		if(st!=end) {
			int md = (st+end)/2;
			Integer[] l = divide(arr, st, md);
			Integer[] r = divide(arr, md+1, end);
			return merge(l, r);
		} else {
			return new Integer[] {arr[st]};
		}
		
	}
	
	static Integer[] merge(Integer[] l, Integer[] r) {
	
		Integer[] merged = new Integer[l.length+r.length];
		int lCount=0;
		int rCount=0;
		
		for(int i=0; i<merged.length; i++) {
			if(lCount<l.length && rCount<r.length) {
				if(l[lCount]<r[rCount])
					merged[i]=l[lCount++];
				else
					merged[i]=r[rCount++];
			} else {
				if(lCount<l.length)
					merged[i]=l[lCount++];
				else
					merged[i]=r[rCount++];
			}
				
		}
		
		return merged;
	}
	

}
