package lecture2_15;

import java.util.ArrayList;
import java.util.Scanner;

public class TrieUse {

	public static void main(String[] args) {
	
		Trie t=new Trie();
		Scanner s=new Scanner(System.in);
		
		System.out.println("ENTER YOUR CHOICE");
		System.out.println("Enter 1  to ADD the Words to Dictionary");
		System.out.println("Enter 2  to SEARCH the Words From Dictionary");
		System.out.println("Enter 3  to REMOVE the Words from Dictionary");
		System.out.println("Enter 4  to COUNT  the number of  Words in Dictionary");
		System.out.println("Enter 5   to Find the patterns in  Dictionary");
		System.out.println("Enter 6   to Get  the Recommendation of words Dictionary");
		System.out.println("Enter -1  EXIT");
		/*
		t.add("ankur");
		String st=s.next();
		System.out.println(t.search(st));
		*/
		
		int ch=s.nextInt();
		
		while(ch!=-1)
		{
			if(ch==1)
			{
				System.out.println("Enter the word that you want to add");
				String st=s.next();
				t.add(st);
			}
			if(ch==2)
			{
				System.out.println("Enter the word that you want to search");
				String st=s.next();
			 boolean b=t.search(st);
			 if(b==true)
			 {
				 System.out.println("the word "+ st + " is Persent in the dictionary");
			 }
			 else {
				 System.out.println("the word "+ st + " is not Persent in the dictionary");
			 }

			}
			
			
			if(ch==3)
			{
				System.out.println("Enter the word that you want to Remove from the dictionary");
				String st=s.next();
				boolean b=t.remove(st);
				 if(b)
				 {
					 System.out.println("the word "+ st + " is removed from the dictionary");
				 }
				 else {
					 System.out.println("the word "+ st + " is already not Persent in the dictionary");
				 }
				
			}
			
			if(ch==4)
			{
				System.out.println("No of word available in the dictionary is " + t.countWords());
			}
			
			if(ch==5)
			{
				System.out.println("first enter the different words in which you find the pattern");
				
				ArrayList<String> a=new ArrayList<String>();
				
				System.out.println("Enter the no of  words that you want to add");
				int n=s.nextInt();
				
				for(int i=0;i<n;i++)
				{
					System.out.println("enter the " + (i+1)+"th" +" word");
					String st=s.next();
					a.add(st);
				}
				
				int cf=0;
				while(cf==0) {
				System.out.println("Enter the pattern that you want to find in the Dictionary");
				
				String st=s.next();
				
				boolean b=t.patternMatching(a,st);
				if(b)
				{
					System.out.println("pattern is found in the dictionary");
					System.out.println();
				}
				else {
					System.out.println("pattern is not found in the dictionary");
					System.out.println();
				}
				
				System.out.println("Do you want to check any other pattern  from already available words in  the dictionary");
				System.out.println("enter 0 if you want or else enter -1 to exit");
				cf=s.nextInt();
				
				
				}
				
			}
			
			
			
			
			
			if(ch==6)
			{
				System.out.println("first add the different words which will help you to give more recommendation");
				
				ArrayList<String> a=new ArrayList<String>();
				
				System.out.println("Enter the no of  words that you want to add");
				int n=s.nextInt();
				
				for(int i=0;i<n;i++)
				{
					System.out.println("enter the " + (i+1)+"th" +" word");
					String st=s.next();
					a.add(st);
				}
				
				int cf=0;
				while(cf==0) {
				System.out.println("Enter the text for which you want Recommendation");
				
				String st=s.next();
				
				boolean b=t.autoComplete(a,st);
				if(b==false)
				{
					System.out.println("there are no recommendation for a given text in the dictionary");
		
				}
				System.out.println("Do you want to find Recommendation for any other text from already available words in  the dictionary");
				System.out.println("enter 0 if you want or else enter -1 to exit");
				cf=s.nextInt();
				}
			}
			
		
			
			
			System.out.println("ENTER YOUR CHOICE");
			System.out.println("1:ADD" + "    2:SEARCH"+ "   3:REMOVE" + "    4:COUNT"+"    5:PATTERN"+"    6:RECOMMENDATION"+"   -1:EXIT");
			ch=s.nextInt();
			
		}
		
		System.out.println("you are exited from the system");
		
	}

}
