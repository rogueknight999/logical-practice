package logical;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code". 
 */
public class WordBreak {

	public static void main(String[] args) {
		
		String ip = "HaveANiceDay";
		String[] wordsArr = new String[] {"Have", "A", "Nice", "Day"};
		Set<String> words = new HashSet<String>(Arrays.asList(wordsArr));
 		
 		if(dpSoln(ip, words))
 			System.out.println("words combo found in dp");
 		
 		if(regSoln(ip, words))
 			System.out.println("words combo found in reg");
 		
	}
	
	public static boolean dpSoln(String ip, Set<String> words) {
		
		boolean[] ipBool = new boolean[ip.length()+1];
		ipBool[0]=true;
		
 		for(int i=0; i<ip.length(); i++) {
 			
 			if(!ipBool[i])
 				continue;
 			
			for(String word : words) {
				int end = i+word.length();
				if(end > ip.length())
					continue;
				if(ip.substring(i, end).equals(word))
					ipBool[end]=true;				
			}
			
		}
 		
 		return ipBool[ip.length()];
	}
	
	public static boolean regSoln(String ip, Set<String> words) {
		
		boolean[] ipBool = new boolean[ip.length()+1]; 
		ipBool[0]=true;
		
		for(int i=0; i<ip.length(); i++) {
			if(!ipBool[i])
				continue;
			
			for(int j=i+1; j<=ip.length(); j++) {
				System.out.println("searching for: "+ip.substring(i, j));
				if(words.contains(ip.substring(i, j)))
					ipBool[j] = true;
					
			}
		}
		
		return ipBool[ip.length()];
	}
}
