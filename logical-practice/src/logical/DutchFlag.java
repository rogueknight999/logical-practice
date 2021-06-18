package logical;

import java.util.HashMap;
import java.util.Map;

public class DutchFlag {

	public static void traditionalSort(Integer[] arr){
		System.out.print("Unsorted Array: ");
		for(Integer i : arr) {System.out.print(i+" ");}
		System.out.println();
		
		int low=0, hi=arr.length-1, mid=arr.length/2;
		
		while(low<=mid || mid<=hi) {
			if(arr[low]>arr[mid]) {
				int temp = arr[low];
				arr[low]=arr[mid];
				arr[mid]=temp;
				low++;
			}
			if(arr[mid]>arr[hi]) {
				int temp = arr[mid];
				arr[mid]=arr[hi];
				arr[hi]=temp;
				
			}
		}
		
	}
	
	public static void mapBasedSort(Integer[] arr) {
		System.out.print("Unsorted Array: ");
		for(Integer i : arr) {System.out.print(i+" ");}
		System.out.println();
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(Integer i : arr) {
			if(map.containsKey(i)) {
				map.put(i, map.get(i)+1);
			} else {
				map.put(i, 1);
			}
		}
		
		System.out.println("Map: "+map);
		Integer counter=0;
		for(Integer i : map.keySet()) {
			Integer count = map.get(i);
			for(int j=1; j<=count; j++) {
				arr[counter] = i;
				counter++;
			}
		}
		
		System.out.print("Sorted Array: ");
		for(Integer i : arr) {System.out.print(i+" ");}
		System.out.println();
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		Integer[] arr1 = new Integer[] {0,1,2,0,1,2};
		Integer[] arr2 = new Integer[] {0,1,2,0,1,2};
		mapBasedSort(arr1);
		traditionalSort(arr2);
	}
	
}
