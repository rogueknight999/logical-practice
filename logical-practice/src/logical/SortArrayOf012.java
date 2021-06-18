package logical;

public class SortArrayOf012 {

	public static void main(String[] args) {
		
		int[] arr = {0,2,0,1,2,1,0,0,2,1};
		int j=0;
		int k=0;
		int temp=0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i]==0) {
				if(arr[j]==1) {
					temp=arr[j];
					arr[j]=arr[i];
					arr[i]=temp;
				}
				j++;

				if(arr[k]==2) {
					temp=arr[k];
					arr[k]=arr[i];
					arr[i]=temp;
				}
				k++;
			} else if(arr[i]==1) {
				if(arr[k]==2) {
					temp=arr[k];
					arr[k]=arr[i];
					arr[i]=temp;
				}
				k++;
			}
		}
		
		for(int i : arr) {
			System.out.print(i+" ");
		}
		
	}
	
}
