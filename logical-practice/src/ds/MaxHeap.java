package ds;

import java.util.ArrayList;
import java.util.List;

public class MaxHeap {

	private List<Integer> maxHeap;
	private int heapSize;
	
	public List<Integer> getMaxHeap() {return this.maxHeap;}
	public int getHeapSize() {return this.heapSize;}

	public MaxHeap(){
		this.maxHeap = new ArrayList<Integer>();
		heapSize=0;
	}
	
	public MaxHeap(Integer[] arr){
		
		this.maxHeap = new ArrayList<Integer>();
		for(int i : arr) {
			this.maxHeap.add(i);
		}
		heapSize=maxHeap.size();
		heapifyList();
	}
	
	public void add(int val) {
		maxHeap.add(heapSize++, val);
		heapifyList();
	}
	
	public int getMax() {
		int val = maxHeap.get(0);
		maxHeap.set(0, maxHeap.get(--heapSize));
		maxHeap.set(heapSize, val);
		heapify(0);
		return val;
	}
	
	public void heapifyList() {
		
		int listLength = maxHeap.size();
		for(int i=listLength/2; i>=0; i--) {
			heapify(i);
		}
	}
	
	public void heapify(int index) {
		
		int child1 = ((index+1)*2)-1;
		int child2 = ((index+1)*2);
		boolean hasC1 = child1<heapSize;
		boolean hasC2 = child2<heapSize;
		if(hasC2 || hasC1) {
			Integer val = maxHeap.get(index);
			Integer child1Val = maxHeap.get(child1);
			Integer child2Val=null;
			if (hasC2)
				child2Val = maxHeap.get(child2);
			
			if(val<child1Val && (hasC2 && val<child2Val)) {
				if(child1Val>child2Val) {
					maxHeap.set(index, child1Val);
					maxHeap.set(child1, val);
					heapify(child1);
				} else {
					maxHeap.set(index, child2Val);
					maxHeap.set(child2, val);
					heapify(child2);
				}
			} else if(val<child1Val) {
				maxHeap.set(index, child1Val);
				maxHeap.set(child1, val);
				heapify(child1);
			} else if(hasC2 && val<child2Val) {
				maxHeap.set(index, child2Val);
				maxHeap.set(child2, val);
				heapify(child2);
			}
		}
		
	}
	
	public static void main(String[] args) {
		/*Integer[] arr = new Integer[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		MaxHeap heap = new MaxHeap(arr);
		List<Integer> maxHeap = heap.getMaxHeap();
		*/
		
		MaxHeap heap = new MaxHeap();
		heap.add(1);
		heap.add(2);
		heap.add(3);
		heap.add(4);
		heap.add(5);
		heap.add(6);
		heap.add(7);
		int max = heap.getMax();
		System.out.println();
		System.out.println("maxInHeap: "+max);
		heap.add(8);
		heap.add(7);
		
		System.out.println();
		System.out.print("MaxHeap: ");
		for(int i=0; i<heap.heapSize; i++) {
			System.out.print(heap.maxHeap.get(i)+", ");
		}
	}
	
}
