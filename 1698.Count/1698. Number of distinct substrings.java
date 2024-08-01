/*package whatever //do not write package name here */

import java.io.*;

class GFG {
	static class TrieNode {
		TrieNode children[];
		boolean isEnd;

		TrieNode()
		{
			this.children = new TrieNode[26];
			this.isEnd = false;
		}
	}

	static TrieNode root = new TrieNode();

	static void insert(String str)
	{
		TrieNode cur = root;
		for (char ch : str.toCharArray()) {
			int idx = ch - 'a';

			if (cur.children[idx] == null)
				cur.children[idx] = new TrieNode();

			cur = cur.children[idx];
		}
		cur.isEnd = true;
	}

	public static int distinctSubstringCount(String str)
	{
		// will hold the count of unique substrings
		int cnt = 0;
		for (int i = 0; i <= str.length(); i++) {
			// start from root of trie each time as new
			// starting point
			TrieNode temp = root;
			for (int j = i; j < str.length(); j++) {
				char ch = str.charAt(j);
				// when char not present add it to the trie
				if (temp.children[ch - 'a'] == null) {
					temp.children[ch - 'a']
						= new TrieNode();
					temp.isEnd = true;
					cnt++;
				}
				// move on to the next char
				temp = temp.children[ch - 'a'];
			}
		}
		return cnt;
	}

	public static void main(String[] args)
	{
		int cnt = distinctSubstringCount("aaa");
		System.out.println("Count of distinct substrings: "
						+ cnt);
	}
}
