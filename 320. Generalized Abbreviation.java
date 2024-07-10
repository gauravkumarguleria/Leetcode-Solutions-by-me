import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
	static ArrayList<String> ways;

	public static void printPaths(String input, int idx, String output, int count){
		if(idx == input.length()){
			output += (count>0)?(""+count):"";
			ways.add(output);
			return;
		}

		//no
		printPaths(input,idx+1,output, count+1);

		//yes
		char ch = input.charAt(idx);
		output += ((count>0)?(""+count):"")+ch;
		printPaths(input, idx+1, output,0);
	}




	public static ArrayList < String > findAbbr(String str) {
		// Write your code here.
		ways = new ArrayList<>();
		printPaths(str,0,"",0);
		Collections.sort(ways);
		return ways;
	}
}
