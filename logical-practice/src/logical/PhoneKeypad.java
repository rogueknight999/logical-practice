package logical;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneKeypad {
	
	static final Map<String, String> dict = new HashMap<String, String>(){{
		put("2","abc");
		put("3","def");
		put("4","ghi");
		put("5","jkl");
		put("6","mno");
		put("7","pqrs");
		put("8","tuv");
		put("9","wxyz");
	}};
	
	public static void main(String[] args) {
		
		int num = 24567;
		
		System.out.println(dailedString(num+""));
		
	}
	
	private static List<String> dailedString(String num){
		
		List<String> returnList = new ArrayList<String>();

		if(num.length()==1) {
			for(char s1 : dict.get(num).toCharArray()) {
				returnList.add(s1+"");
			}
			return returnList;
		}
		
		String currDigit = num.charAt(0)+"";
		List<String> receivedList = dailedString(num.substring(1, num.length()));
		
		for(String s : receivedList) {
			for(char s1 : dict.get(currDigit).toCharArray()) {
				returnList.add(s1+s);
			}
		}
		
		return returnList;
	}
	
}
