import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TestImpl {

	public static void main(String[] args) {
		
		List<Integer[]> list = new ArrayList<Integer[]>();
		list.add(new Integer[] {2, -10});
		list.add(new Integer[] {24, 10});
		list.add(new Integer[] {2, -15});
		list.add(new Integer[] {24, 15});
		list.add(new Integer[] {5, -12});
		list.add(new Integer[] {24, 12});
		list.add(new Integer[] {15, -10});
		list.add(new Integer[] {24, 10});
		list.add(new Integer[] {24, 8});
		list.add(new Integer[] {24, 8});
		
		list.sort((Integer[] a, Integer[] b) -> {
			int ans=0;
			if(a[0]>b[0])
				ans=1;
			else if(a[0]<b[0])
				ans=-1;
			else if(a[0]==b[0])
				if(a[1]>b[1])
					ans=1;
				else if(a[1]<b[1])
					ans=-1;
			
			return ans;
		});
		
		for(Integer[] a : list) {
			for(int i : a)
				System.out.print(i+" ");
			System.out.println();
		}
		
	}
	
}

