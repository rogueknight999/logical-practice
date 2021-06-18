package logical;

import util.Util;

public class NextEqOrMoreNum {

	public static void main(String[] args) {
		
		Integer[] numbers = new Integer[] {25, 24, 25, 26, 24, 26};
		Integer[] diff = new Integer[numbers.length];
		for(int i=0; i<diff.length; i++) {
			diff[i]=0;
		}
		divide(numbers, diff, 0, numbers.length-1);
		
		Util.printArr(diff);
	}
	
	public static void divide(Integer[] nums, Integer[] diff, int st, int end) {
		
		int md = (st+end)/2;
		if(st!=end) {
			divide(nums, diff, st, md);
			divide(nums, diff, md+1, end);
		}
		merge(nums, diff, st, md, end);
		
	}
	
	public static void merge(Integer[] nums, Integer[] diff, int st, int md, int end) {
		
		int l=st;
		int r=md+1;
		
		while(l<=md && r<= end) {
			if(nums[l]<=nums[r]) {
				if(diff[l]==0) {
					diff[l] = r-l;
				}
				l++;
			} else {
				r++;
			}
		}
		
	}
	
}
