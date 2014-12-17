import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;


public class MethodLister {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MethodLister myLister = new MethodLister();
		System.out.print("Enter a Class name: ");
		Scanner userInput = new Scanner(System.in);
		String passedName = userInput.next();
		myLister.listMethodsAndFields(passedName);
		userInput.close();
	}
	
	void listMethodsAndFields(String passedName){
		
		//search by default in java.lang package if package is not mentioned
		if(!passedName.contains("java.")){
			passedName = "java.lang."+passedName;
			System.out.println(passedName);
		}
		
		Class<?> givenClass=null;
		try {
			givenClass = Class.forName(passedName);

		Method[] methods = givenClass.getDeclaredMethods();
		System.out.println("\tMETHODS:");
		//listing out methods
		for(int i=0;i<methods.length;i++)
		System.out.println(methods[i].getName());
		
		System.out.println("\tFIELDS:\n");
		//listing out fields
		Field[] fields = givenClass.getFields();
		for(int i=0;i<fields.length;i++)
		System.out.println(fields[i].getName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception: no such Clas available.");
		}
	}
}
