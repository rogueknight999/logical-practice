package logical;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * given m*n sorted arrays, merge them to form one sorted array 
 */
public class MergeSortedArrays {

	public static void main(String[] args) {
		
		int[][] ip = new int[][] {{1,2,3,4}, {2,2,4,5}, {3,4}, {4,5,6,7}, {3,4}};
		
		List<Integer> arrL = new ArrayList<Integer>();
		
		Map<Integer, Integer> ipMap = new HashMap<Integer, Integer>();
		for(int[] arr : ip)
			for(int a : arr)
				if(ipMap.containsKey(a))
					ipMap.put(a, ipMap.get(a)+1);
				else
					ipMap.put(a, 1);
		
		for(int key : ipMap.keySet())
			for(int i=1; i<=ipMap.get(key); i++)
				arrL.add(key);
		
		System.out.println("merged and sorted: "+arrL);
		
	}
	
}
