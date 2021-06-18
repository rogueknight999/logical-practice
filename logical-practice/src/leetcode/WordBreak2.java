package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word. 
 * Return all such possible sentences. 
 * For example, given s = "catsanddog", dict = ["cat", "cats", "and", "sand", "dog"] 
 * The solution is ["cats and dog", "cat sand dog"].
 * 
 */
public class WordBreak2 {

	public static void main(String[] args) {
		String[] wordsArr = new String[] {"Have", "A", "Nice", "Day", "AN", "ice", "yay", "Days"};
		List<String> words = new ArrayList<String>(Arrays.asList(wordsArr));
		
		System.out.println(wordBreak("HaveANiceDay", words));
	}
	
	public static List<String> wordBreak(String ip, List<String> words){
		
		List<String> result = new ArrayList<String>();
		
		ArrayList<String>[] possibleWords = new ArrayList[ip.length()+1];
		
		possibleWords[0]=new ArrayList<String>();
		for(int i=0; i<ip.length(); i++) {
			
			if(possibleWords[i]==null) continue;
			
			for(String word : words) {
				
				int end = i+word.length();
				if(end > ip.length()) continue; 
				
				if(ip.substring(i, end).equals(word)) {
					if(possibleWords[end]==null)
						possibleWords[end] = new ArrayList<String>();
					possibleWords[end].add(word);
				}
			}
			
		}
		
		constructCombo(possibleWords, ip.length(), result, new ArrayList<String>());
		
		return result;
	}
	
	public static void constructCombo(ArrayList<String>[] possibleWords, int end, List<String> result, List<String> temp) {
		
		if(end==0) {
			String combo = "";
			for(String part : temp) {
				combo = part+" "+combo;
			}
			result.add(combo);
		}
		
		ArrayList<String> endList = possibleWords[end];
		
		for(String word : endList) {
			temp.add(word);
			constructCombo(possibleWords, end-word.length(), result, temp);
			temp.remove(temp.size()-1);
		}
	}
	
}
