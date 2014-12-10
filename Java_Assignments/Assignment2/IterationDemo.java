import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class IterationDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
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
