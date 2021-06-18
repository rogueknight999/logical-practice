package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;


/*
 *  Input: buildings = [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]
 *	Output: [[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]
 *	Explanation:
 *	Figure A shows the buildings of the input.
 *	Figure B shows the skyline formed by those buildings. The red points in figure B represent the key points in the output list.
 */
public class SkylineProblem {

	public static void main(String[] args) {
		
		int[][] buildings = new int[][] {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
		//int[][] buildings = new int[][] {{4,9,10},{4,9,15},{4,9,12},{10,12,10},{10,12,8}};
		//int[][] buildings = new int[][] {{1,10001,10000},{2,10001,9999},{3,10001,9998},{4,10001,9997},{5,10001,9996},{6,10001,9995},{7,10001,9994},{8,10001,9993},{9,10001,9992},{10,10001,9991},{11,10001,9990},{12,10001,9989}};
        usingPQ(buildings);
		veryNaiveSoln(buildings);
        usingTreeMap(buildings);
        
	}
	
	static void usingPQ(int[][] buildings){
		List<List<Integer>> skyline = new ArrayList<List<Integer>>();
		
		List<Integer[]> sortedBuildings = new ArrayList<Integer[]>();
        //n
		for(int[] building : buildings){
            sortedBuildings.add(new Integer[] {building[0], -building[2]});
            sortedBuildings.add(new Integer[] {building[1], building[2]});
        }
		//nlogn
        sortedBuildings.sort((Integer[] a, Integer[] b) -> {
        	if(a[0].compareTo(b[0])!=0)
        		return a[0].compareTo(b[0]);
        	else
        		return a[1].compareTo(b[1]);
        });
        /*for(Integer[] a : sortedBuildings) {
			for(int i : a)
				System.out.print(i+" ");
			System.out.println();
		}*/
        
        
        PriorityQueue<Integer> skylineBuilder = new PriorityQueue<Integer>((Integer a, Integer b) -> b-a);
        skylineBuilder.offer(0);
        
        //2n*(n+logn)
        for(Integer[] building : sortedBuildings){
            boolean insert = (building[1]<0) ? true : false;
            int prevMax = skylineBuilder.peek();
            if(insert){
            	//System.out.println("Inserting: "+building[1]);
                skylineBuilder.offer(-building[1]);
                if(prevMax!=skylineBuilder.peek()){
                    List<Integer> newPoint = new ArrayList<Integer>();
                    newPoint.add(building[0]);
                    newPoint.add(-building[1]);
                    skyline.add(newPoint);
                }
            } else{
            	//System.out.println("Removing: "+building[1]);
            	//n+logn 
            	skylineBuilder.remove(building[1]);
                if(prevMax!=skylineBuilder.peek()){
                    List<Integer> newPoint = new ArrayList<Integer>();
                    newPoint.add(building[0]);
                    newPoint.add(skylineBuilder.peek());
                    skyline.add(newPoint);
                }
            }
            //System.out.println(skylineBuilder);
        }
        System.out.println(skyline);
	}

	static void usingTreeMap(int[][] buildings) {
		
		List<List<Integer>> skyline = new ArrayList<List<Integer>>();
		
		//n
		List<Integer[]> points = new ArrayList<Integer[]>();
		for(int[] building : buildings) {
			points.add(new Integer[] {building[0], -building[2]});
			points.add(new Integer[] {building[1], building[2]});
		}
		
		//nlogn
		points.sort((Integer[] a, Integer[] b) -> {
			if(a[0].compareTo(b[0])!=0)
				return a[0].compareTo(b[0]);
			else
				return a[1].compareTo(b[1]);
		});
		
		//nlogn
		TreeMap<Integer, Integer> builder = new TreeMap<Integer, Integer>();
		builder.put(0, 1);
		for(Integer[] point : points) {
			int height = point[1];
			int currMax = builder.lastKey();
			if(height<0) {
				if(builder.containsKey(-height))
					builder.put(-height, builder.get(-height)+1);
				else
					builder.put(-height, 1);
			} else {
				if(builder.get(height)>1)
					builder.put(height, builder.get(height)-1);
				else
					builder.remove(height);
			}
			int newMax = builder.lastKey();
			if(currMax != newMax) {
				List<Integer> temp = new ArrayList<Integer>();
				temp.add(point[0]);
				temp.add(newMax);
				skyline.add(temp);
			}
		}
		
		System.out.println(skyline);
	}
	
	static void veryNaiveSoln(int[][] buildings) {
		
		List<List<Integer>> skyline = new ArrayList<List<Integer>>();
		
		//n
		int skylineEnd=0;
		for(int[] building : buildings)
			if(skylineEnd<building[1])
				skylineEnd=building[1];
		
		//widthOfSkyline^2
		int[] fullSkyline = new int[skylineEnd+2];
		for(int[] building : buildings) 
			for(int i=building[0]; i<=building[1]; i++) 
				if(fullSkyline[i]<building[2])
					fullSkyline[i]=building[2];
		
		/*for(int i : fullSkyline)
			System.out.print(i+" ");*/
		
		//widthOfSkyline
		for(int i=1; i<fullSkyline.length; i++)
			if(fullSkyline[i]!=fullSkyline[i-1]) {
				List<Integer> temp = new ArrayList<Integer>();
				if(fullSkyline[i]>fullSkyline[i-1])
					temp.add(i);
				else
					temp.add(i-1);
				temp.add(fullSkyline[i]);
				skyline.add(temp);
			}
				
		//System.out.println();
		System.out.println(skyline);
	}

	/*
	 * [2,9,10] -> [2,10],[9,0]    			-> [2,10],[3,15],[7,10][9,0]			-> [2,10],[3,15],[7,10],[12,0],[15,10],[20,0]
	 * [3,7,15] -> [3,15],[7,0]   
	 * 
	 * [5,12,12] -> [5,12],[12,0]			-> [5,12],[12,0],[15,10],[20,0]
	 * [15,20,10] -> [15,10],[20,0]
	 * 
	 * recursively break down till one building remains
	 * create skyline for one building and return
	 * merge 2 skylines
	 * 		a[0[0]]<b[0[0]]
	 * 			copy a[0[0]] else copy b[0[0]]
	 * 			
	 * 
	 * repeat till all skylines have been merged
	 * 
	 * */
	static void usingDivideAndConquer(int[][] buildings) {
		
	}
	
}
