
import java.io.*;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetProgrammingLanguage {

	
	String getContentLines(String fileName) {			//function to get content separated in lines

		String contentLines = new String("");
		BufferedReader forReadingFile = null;

		try 
		{

			String CurrentLine;
			forReadingFile = new BufferedReader(new FileReader(fileName));
			while ((sCurrentLine = br.readLine()) != null) 
			{
				contentLines += CurrentLine + "\n";
			}

		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try {
				forReadingFile.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return contentLines;
	}

	String getFileContent(String fileName) {			//function to get content as whole
		String content = "";
		BufferedReader forReadingFile = null;
		try {
			String CurrentLine;
			forReadingFile = new BufferedReader(new FileReader(fileName));
			while ((CurrentLine = forReadingFile.readLine()) != null) 
			{
				content += CurrentLine;
			}

		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				forReadingFile.close();
			}
			catch (IOException ex)
			{
				ex.printStackTrace();
			}
		}
		
		return content;
	}

	String getLanguage(String filename) {				//function to determine language
		
		GetProgrammingLanguage readingFile = new GetProgrammingLanguage();
		String test = readingFile.getFileContent(filename);
		if (test.matches("(\\<)(\\?)(\\w|\\W|\\s)*"))
		{
			return "PHP";
		}
		else if (test.matches(".*class.*[\\{].*[\\}]")||test.matches("(\\s+|\\t+)*(import|package)(\\s)+java"))
		{
			return "Java";
		}
		else if (test.matches(".*class.*end")||test.matches(".*def.*end")||test.matches("puts|gets|@+|\\$"))
		{
			return "Ruby";
		}
	}

	void showClassName(String fileName)
	{				//function to determine classes' name
		String classKeyword = "class";
		System.out.println("Classes found in the file:");
		boolean class_found = false;
		GetProgrammingLanguage d = new GetProgrammingLanguage();
		StringTokenizer st = new StringTokenizer(d.getFileContent(fileName));
		while (st.hasMoreElements())
		{
			String f = st.nextElement().toString();
			if (f.contains(classKeyword))
			{
				class_found = true;
				System.out.println(st.nextElement().toString());
			}
		}
		if (!class_found)
			System.out.println("NO CLASS FOUND");
	}

	void ListFunctions(String fileName)			    //function to list function
	{	
		GetProgrammingLanguage g = new GetProgrammingLanguage();
		String currentLine = g.getContentLines(fileName);
		String lang = g.getLanguage(fileName);
		Scanner scannerObject = new Scanner(currentLine);
		System.out.println("Functions:");
		LinkedHashSet<String> functionList= new LinkedHashSet<String>();
		if (lang.equals("PHP"))
		{
			Pattern pattern = Pattern.compile("(public|protected|private)*(\\s)+(function)*(\\s+|\\W)(\\w+)(\\()");
			while (scannerObject.hasNext())
			{
				String temp = scannerObject.nextLine();
				Matcher matcher = pattern.matcher(temp);
				while (matcher.find())
				{
					functionList.add(matcher.group(5) + "\t"+ matcher.group(1));
				}
			}
			System.out.println(functionList);
		}

		else if (lang.equals("Java"))
		{
			Pattern pattern = Pattern.compile("(\\s|\\w|\\t)*(public|protected|private)(\\s)+(String|int|Integer|float|Float|void|Long|long|Double|double)(\\s+)(\\w+|\\W)+(\\s*)(\\()");
			while (scannerObject.hasNext())
			{
				String temp = scannerObject.nextLine();
				Matcher matcher = pattern.matcher(temp);
				while (matcher.find())
				{
					System.out.print("name: " + matcher.group(6) + "\t");
					System.out.println("Access Specifier: " + matcher.group(2));
				}
			}
		}
		else if (lang.equals("Ruby"))
		{
			Pattern pattern = Pattern.compile("(\\s|\\w|\\t)*(def)(\\s+)(\\w+)");
			while (scannerObject.hasNext())
			{
				String temp = scannerObject.nextLine();
				Matcher matcher = pattern.matcher(temp);
				while (matcher.find())
				{
					System.out.println(matcher.group(4));
				}
			}
		}
		else
		{
			System.out.println("No functions found");
		}
		scannerObject.close();
	}

	void showAttributes(String filename) {				//function to list attributes

		GetProgrammingLanguage readingFile = new GetProgrammingLanguage();
		String currentLine = readingFile.getContentLines(filename);
		String lang = readingFile.getLanguage(filename);
		Scanner sc = new Scanner(currentLine);
		System.out.println("Attributes:");
		LinkedHashSet<String> attributeList = new LinkedHashSet<String>();
		if (lang.equals("PHP"))
		{
			Pattern pattern = Pattern.compile("[\\$][a-z|A-Z|0-9|_]+");
			while (sc.hasNext())
			{
				String temp = sc.nextLine();
				Matcher matcher = pattern.matcher(temp);
				while (matcher.find())
				{
					String s="";
					for (int k = matcher.start(); k < matcher.end(); k++)
					{
						s+=temp.charAt(k);
					}
					attributeList.add(s);
				}
			}
			System.out.println(arr);
		}

		else if (lang.equals("Java"))
		{
			Pattern pattern = Pattern.compile("[\\s|\\w|\t]+(String|int|Integer|float|Float|long|Long|double|Double|byte|Byte|char|Character)(\\s)+(\\w)+(\\s|\\+|\\-|\\*|;)");
			while (sc.hasNext()) {
				String temp = sc.nextLine();
				Matcher matcher = pattern.matcher(temp);
				while (matcher.find()) {
					String x = "";
					for (int k = matcher.start(); k < matcher.end() - 1; k++) {
						x += temp.charAt(k);
					}
					attributeList.add(x.replace("\t", ""));
				}
			}
			System.out.println(arr);
		} 
		else if (lang.equals("Ruby"))
		{
			Pattern pattern = Pattern.compile("[\\s|\\w]*[\\$|@][@]*[a-z|A-Z|0-9|_]+[;|\\s+]");
			while (sc.hasNext())
			{
				String temp = sc.nextLine();
				Matcher matcher = pattern.matcher(temp);
				while (matcher.find())
				{
					String x = "";
					for (int k = matcher.start(); k < matcher.end(); k++)
					{
						x += temp.charAt(k);
					}
					x = x.replace("@", "");
					attributeList.add(x.replace("\t", ""));
				}
			}
			
			System.out.println(attributeList);
		}
		sc.close();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GetProgrammingLanguage d = new GetProgrammingLanguage();
		Scanner scannerObject = new Scanner(System.in);
		System.out.print("Enter filename: ");
		String userInput = scannerObject.next();
		sc.close();
		d.showAttributes(p);
		d.showClassName(p);
		d.ListFunctions(p);
		String lang = d.getLanguage(userInput);
		System.out.println("Language: " + lang);
		IndentFile i = new IndentFile();	//object of class to Indent given file
		i.trim();
		if (lang.equals("Ruby"))
		{
			// i.indentFileRuby();
		}
		else if (lang.equals("Java"))
		{
			//i.indentFileJava()
		}
		else if(lang.equals("PHP"))
		{
			//i.indentFilePHP();
		}
	}

}
