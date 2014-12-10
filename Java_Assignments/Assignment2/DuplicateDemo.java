import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class DuplicateDemo {

	public static void main(String[] args) {
		String testString = "I came I saw I conquered I went";
		DuplicateDemo demoObject = new DuplicateDemo();
		System.out.println(demoObject.removeDuplicate(testString));
	}

	String removeDuplicate(String givenString){
		String updatedString = "";
		try{
			//separating each word in the string
			StringTokenizer myTokenizer = new StringTokenizer(givenString);
		
			//retrieving all the unique words
			LinkedHashSet<String> uniqueWordSet = new LinkedHashSet<>();
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
			System.out.println("Exception: there is no element in the StringTokenizer");
		}
		catch(NullPointerException e){
			System.out.println("Exception in StringTokenizer: the passed String is NULL.");
		}
		return updatedString;
	}
}
