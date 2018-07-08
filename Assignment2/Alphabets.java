import java.util.*;
import java.io.*;
import java.lang.*;
//package com.string;

class Alphabets{

	public void checkingAlphabets(String s)
	{
        int count = 0;
 	      String str = s.toLowerCase();
        boolean[] hash = new boolean[26];                              // Creating hash array for alphabets
        int i;
        //String ans="";
        for(i=0; i<str.length(); i++)
         {
 	        if((str.charAt(i)-'a')>=0 && (str.charAt(i)-'a')<=26)
                   hash[(str.charAt(i)-'a')]=true;                        // Indexing alphabets
         }

        for(i=0; i<26; i++)
          {

            if(hash[i])
              {
    	        hash[i]=false;
                count++;                                        // Counting all alphabets present or not
              }
          }

        if(count==26)
        {
          System.out.println("String contains all alphabets a-z(case insensitive) \n "); // Checking if a-z alphabets present or not
        }                                           
            
        else
        {
           //ans = "String doesn't contains 26 alphabets";
           System.out.println("String doesn't contains 26 alphabets");

        }

    }

public static void main(String[] args)
{
while(true)
{
System.out.println("Enter string \n");
Scanner sc = new Scanner(System.in);                   

String s = sc.next();                                  // Taking input string from console
Alphabets alphabet = new Alphabets();
alphabet.checkingAlphabets(s);
}
}
}

/*

Time complexity - O(n) here "n" is size of string i.e linear in time

Space complexity - O(1) constant  

*/
