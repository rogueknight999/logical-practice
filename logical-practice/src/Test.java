import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {

		
		
		System.out.println(2%3);
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.peek();

		Queue<Integer[]> q = new LinkedList<Integer[]>();
		//q.remove();
		//q.peek();
		q.isEmpty();
		q.poll();
		q.offer(new Integer[]{1,2});
		
		LinkedList<String> ll = new LinkedList<String>();
		//ll.removeLast();

		PriorityQueue<Integer> pqa = new PriorityQueue<Integer>();
		for(int i=1; i<=10; i++)
			pqa.offer(i);
		//System.out.println(pqa);
		PriorityQueue<Integer> pqd = new PriorityQueue<Integer>((Integer a, Integer b) -> b-a);
		for(int i=1; i<=10; i++) {
			pqd.offer(i);
			//System.out.println(pqd);
		}
		
		Deque<Integer[]> dq = new LinkedList<Integer[]>();
		dq.add(new Integer[]{10,1});
		
		String s1 = "10|10";
		for(String ss : s1.split("\\|")) {
			//System.out.println(ss);
		}
		
		new String(new char[1]);
		
		int[][] matrix = new int[5][5];
		boolean isFirstZero = (matrix[0][0]==0) ? true : false;
		
		Stack<Character> s = new Stack<Character>();
		//s.peek();
		
		//System.out.println(Math.min(0, Math.min(0, 1)));
		
		Map<String, String> map = new HashMap<String, String>();
		map.clear();
		
		Map<Character, List<int[]>> someMap = new HashMap<Character, List<int[]>>();
		
		//for(char c='a'; c<='z'; c++)
			//System.out.println(c);
		
		Map<Character, List<int[]>> copiedMap = new HashMap<Character, List<int[]>>();
		
		//Thread t1 = new Thread(new FutureTask(null));
		
		String str="";
		str.intern();
		
		List<String> list = new ArrayList<String>();
		Set<String> set = list.stream().collect(Collectors.toSet()); 
		
	}
	
	void printMatrix(int[][] matrix, int rowLen, int colLen){
        
        for(int row=0; row<rowLen; row++){
            for(int col=0; col<colLen; col++){
                System.out.print(matrix[row][col]+" ");
            }
            System.out.println();
        }
        System.out.println("-----------------------------------");
        
    }
	
}
