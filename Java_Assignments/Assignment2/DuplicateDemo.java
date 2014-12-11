import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class DuplicateDemo {

	public static void main(String[] args) {
		String testString = "I came I saw I conquered I went";
		DuplicateDemo demoObject = new DuplicateDemo();
		System.out.println("Original String: "+testString);
		testString = demoObject.removeDuplicate(testString);
		System.out.println("Updated String: "+testString);
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
