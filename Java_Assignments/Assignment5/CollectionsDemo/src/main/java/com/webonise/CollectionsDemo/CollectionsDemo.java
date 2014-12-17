package com.webonise.CollectionsDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class CollectionsDemo {

	public static void main(String[] args) {
		String testString = "I came I saw I conquered I went";
		CollectionsDemo demoObject = new CollectionsDemo();
		System.out.println("Original String: "+testString);
		testString = demoObject.removeDuplicate(testString);
		System.out.println("Updated String: "+testString);
		ArrayList<String> myArrayList = new ArrayList<String>();
		HashMap<String, String> myHashMap = new HashMap<String,String>();
		//adding elements to myArrayList
		myArrayList.add("Lorem");
		myArrayList.add("Ipsum");
		myArrayList.add("is");
		myArrayList.add("simply");
		myArrayList.add("dummy");
		myArrayList.add("text");

		//adding elements to HashMap
		myHashMap.put("101", "ketan");
		myHashMap.put("102", "will");
		myHashMap.put("103", "iterate");
		myHashMap.put("104", "this");
		myHashMap.put("105", "hashmap");
		myHashMap.put("106", "also");
		
		//iterating both
		CollectionIterator myOwnIterator = new CollectionIterator();
		myOwnIterator.iterateCollection(myArrayList);
		myOwnIterator.iterateCollection(myHashMap);
	}

	String removeDuplicate(String givenString){
		String updatedString = "";
		try{
			//separating each word in the string
			StringTokenizer myTokenizer = new StringTokenizer(givenString);
		
			//retrieving all the unique words
			LinkedHashSet<String> uniqueWordSet = new LinkedHashSet<String>();
			while(myTokenizer.hasMoreElements())
			{
				uniqueWordSet.add(myTokenizer.nextElement().toString());
			}

			//generating a string with duplicate words removed
			Iterator<String> listIterator = uniqueWordSet.iterator();
			while(listIterator.hasNext())
			updatedString+=listIterator.next().toString()+" ";
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Exception: there are no more tokens in this tokenizer's string");
		}
		catch(NullPointerException e){
			System.out.println("Exception: the passed String to the StringTokenizer is NULL.");
		}
		return updatedString;
	}
}

class CollectionIterator{
	public void iterateCollection(ArrayList<String> passedList){
		Iterator<String> myOwnIterator = passedList.iterator();
		System.out.println("Traversing ArrayList: ");
		while(myOwnIterator.hasNext())
		{
			System.out.println(myOwnIterator.next());
		}
	}
	public void iterateCollection(HashMap<String,String> passedHashMap){
		//storing the keyValues in a List
		List<String> newList = new ArrayList<String>(passedHashMap.keySet());

		//reversing the List to maintain the insertion order
		Collections.reverse(newList);
		System.out.println("Traversing HashMap: ");
		//iterating through passed HashMap via key-values
		for(String key: newList)
		{
			System.out.println("Key:  "+key+" Value: "+passedHashMap.get(key));
		}
	}
}
