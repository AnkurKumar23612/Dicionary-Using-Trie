package lecture2_15;

import java.util.ArrayList;

class TrieNode{
	char data;
	boolean isTerminating;
	TrieNode children[];
	int childCount;

	public TrieNode(char data) {
		this.data = data;
		isTerminating = false;
		children = new TrieNode[26];
		childCount = 0;
	}
}


public class Trie {

	private TrieNode root;
	private int numWords;

	public Trie() {
		root = new TrieNode('\0');
		numWords = 0;
	}
	
  
	public boolean search(String word){
		return search(root, word);
	}

	private boolean search(TrieNode root, String word) {
		if(word.length() == 0){
			return root.isTerminating;
		}
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if(child == null){
			return false;
		}
		return search(child, word.substring(1));
	}
	
	
	
	public boolean remove(String word){
		boolean b=false;
		if(remove(root, word)) {
			numWords--;
			b=true;
			return b;
		}
		return b;
	}
	

	private boolean remove(TrieNode root, String word) {
		if(word.length() == 0){
			if(root.isTerminating) {
				root.isTerminating = false;
				return true;
			}
			else {
				return false;
			}
		}
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if(child == null){
			return false;
		}
		boolean ans = remove(child, word.substring(1));
		// We can remove child node only if it is non terminating and its number of children are 0	

		if(!child.isTerminating && child.childCount == 0){
			root.children[childIndex] = null;
			child = null;
			root.childCount--;
		}
		return ans;
	}

	private boolean add(TrieNode root, String word){
		if(word.length() == 0){
			if(root.isTerminating) {
				return false;
			}
			else {
				root.isTerminating = true;
				return true;
			}
		}		
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if(child == null){
			child = new TrieNode(word.charAt(0));
			root.children[childIndex] = child;
			root.childCount++;
		}
		return add(child, word.substring(1));
	}

	public void add(String word){
		
		if(add(root, word)) {
			numWords++;
			
		}
		
	}
	
	public int countWords() {
		
      
        return numWords;
     
	}
	
	

	public boolean patternMatching(ArrayList<String> input, String pattern) {
		
    
        for(int i=0;i<input.size();i++)
        {
            String word=input.get(i);
            
            
            for(int j=0;j<word.length();j++)
            {
                add(word.substring(j));
            }
        }
    
      return search(pattern);
      
	}
	
	
	
	public TrieNode findRoot(TrieNode root,String word)
	{
		if(word.length()==0)
		{
			return root;
		}
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		
		if(child==null)
		{
			return null;
		}
		return findRoot(child,word.substring(1));
		
	}
	
	public boolean autoComplete(ArrayList<String> input,String word)
	{
		for(String w:input)
		{
			add(w);
		}
		
		TrieNode node=findRoot(root,word);
		if(node==null || node.childCount==0)
		{
			return false;
		}
		
		System.out.println("Recommended words are  :");
		String output="";
		allRootToLeafpaths(node,output,word);
		
		return true;
	}


	private void allRootToLeafpaths(TrieNode node, String output, String word) {
		
		if(node.childCount==0)
		{
			if(output.length()>0)
			{
				System.out.println(word+output);
			}
			
			return ;
		}
		if(node.isTerminating==true)
		{
			System.out.println(word+output);
		}
		
		for(int i=0;i<node.children.length;i++)
		{
			if(node.children[i]!=null)
			{
				String ans=output+node.children[i].data;
				allRootToLeafpaths(node.children[i],ans,word);
			}
		}
		
	}
		
}
