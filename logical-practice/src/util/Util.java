package util;

public class Util {

	public static void printArr(Object[] arr) {
		for(Object i : arr) {
			System.out.print(i+" ");
		}
	}
	
	public static void swap(Object[] arr, int i1, int i2) {
		Object temp = arr[i1];
		arr[i1] = arr[i2];
		arr[i2] = temp;
	}
	
}
