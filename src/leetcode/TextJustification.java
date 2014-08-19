package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class TextJustification {
	/**
	 * Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

	 * @param words
	 * @param L
	 * @return
	 */
	public ArrayList<String> fullJustify(String[] words, int L) {
		
		ArrayList<String> ans = new ArrayList<String>();
		
		ArrayList<String> wordPerLine = new ArrayList<String>();
		
		int sumWordLen = 0;
 		
		for(String word : words){
			if(sumWordLen + wordPerLine.size() + word.length() > L){ // finish the current line and start a new one
				StringBuilder sb = new StringBuilder();
				if(wordPerLine.size() == 1){ // one word per line
					sb.append(wordPerLine.get(0));
					char [] spaces = new char[L - sumWordLen]; 
					Arrays.fill(spaces, ' '); 
					sb.append(spaces);			//left justified		
				}else{
					int numSpacePerWord = (L - sumWordLen) / (wordPerLine.size() - 1);
					int moreSpace = (L - sumWordLen) % (wordPerLine.size() - 1);
					for(int i = 0; i < wordPerLine.size() - 1; i++){
						sb.append(wordPerLine.get(i));
						char [] spaces;
						if(i < moreSpace){
							spaces = new char[numSpacePerWord + 1];
						}	else{
							spaces = new char[numSpacePerWord];
						}
						Arrays.fill(spaces, ' ');
						sb.append(spaces);						
					}
					//last word
					sb.append(wordPerLine.get( wordPerLine.size() - 1));
				}
				
				ans.add(sb.toString());
				wordPerLine = new ArrayList<String>();
				sumWordLen = 0;
			}			
			sumWordLen += word.length();
			wordPerLine.add(word);						 
		}
		//The Last Line
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < wordPerLine.size() - 1; i++){
			sb.append(wordPerLine.get(i));
			sb.append(" ");	
		}
		sb.append(wordPerLine.get( wordPerLine.size() - 1));
		char [] spaces = new char[L - sb.length()];
		Arrays.fill(spaces, ' ');
		sb.append(spaces);
		ans.add(sb.toString());

		return ans;
    }

}
