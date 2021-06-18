package algo;

import util.Util;

public class CountingSort {

	public static void main(String[] args) {
		
		Integer[] arr = new Integer[] {2,5,74,1,3,46,91,32,34,84,63,31,58,41,13,11};
		Integer[] temp = new Integer[arr.length];
		int maxNum=0;
		int minNum=0;
		for(int i:arr) {
			if(i<minNum)
				minNum=i;
			if(i>maxNum)
				maxNum=i;
		}
		
		Integer[] countingArr;
		if(minNum<0) 
			countingArr = new Integer[maxNum+1];
		else
			countingArr = new Integer[(maxNum-minNum)+1];
		for(int i=0; i<countingArr.length; i++)
			countingArr[i]=0;
		
		for(int i=0; i<arr.length; i++)
			countingArr[arr[i]]++;
		for(int i=1; i<countingArr.length; i++)
			countingArr[i]=countingArr[i-1]+countingArr[i];
		
		for(int i=arr.length-1; i>=0; i--)
			temp[--countingArr[arr[i]]]=arr[i];
		for(int i=0; i<temp.length; i++)
			arr[i]=temp[i];

		System.out.println();
		System.out.print("Sorted Array: ");
		Util.printArr(temp);
	}
	
}
