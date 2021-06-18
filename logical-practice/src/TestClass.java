import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class TestClass {

	//Driver code
	public static void main(String[] args) {
		
		new Stack<String>();
		
		// make dictionary
		Set<String> D = new HashSet<String>();
		//D.add("poon"); D.add("plee"); D.add("same"); D.add("poie"); D.add("plie"); D.add("poin"); D.add("plea");
		D.add("hot"); D.add("lot"); D.add("dot"); D.add("log"); D.add("dog"); D.add("cog"); 
		
		String start = "toon";
		String target = "plea";
		start.replaceFirst("o", "");
		
		//System.out.print("Length of shortest chain is: " + shortestChainLen(start, target, D));
		//System.out.println(shortestChainLen("hit", "cog", D));
	}	

	private static int shortestChainLen(String start, String target, Set<String> dict) {
		
		int level=0;
		int wordLen = start.length();
		if(target.length() != wordLen)
			return 0;
		if(!dict.contains(target))
			return 0;
		
		Queue<String> bfsQueue = new LinkedList<String>();  
		bfsQueue.add(start);
		
		int wordsInNextLevel = 0;

		while(!bfsQueue.isEmpty()) {
		
			if(wordsInNextLevel==0) {
				wordsInNextLevel=bfsQueue.size();
				level++;
				System.out.println(bfsQueue);
			}
			System.out.println("Before Words In Next Level: "+wordsInNextLevel);
			
			String currWord = bfsQueue.remove();
			char[] newWordArr = currWord.toCharArray();
			String newWord=currWord;
			
			for(int i=0; i<currWord.length(); i++) {
				
				char og = newWordArr[i];
				for(char replace='a'; replace<='z'; replace++) {
					
					newWordArr[i]=replace;
					newWord=String.valueOf(newWordArr);
					
					//System.out.println(String.valueOf(newWord));
					if(target.equals(newWord)) {
						break;
					}
					
					if(dict.contains(newWord)) {
						bfsQueue.add(newWord);
						dict.remove(newWord);
					}
				}
				newWordArr[i]=og;
			}
			wordsInNextLevel--;
			System.out.println("After Words In Next Level: "+wordsInNextLevel);
			
		}
		target.indexOf("");
		
		System.out.println("Found after: "+level);
		return level;
	}
	
}
