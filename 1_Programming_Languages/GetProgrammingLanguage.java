import java.io.*;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetProgrammingLanguage {

	
	String getContentLines(String fileName) {			//function to get content separated in lines

		String arr = new String("");
		BufferedReader br = null;

		try {

			String sCurrentLine;

			br = new BufferedReader(new FileReader(fileName));

			while ((sCurrentLine = br.readLine()) != null) {

				arr += sCurrentLine + "\n";

			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {
				br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return arr;
	}

	String getFileContent(String fileName) {			//function to get content as whole
		String content = "";
		BufferedReader br = null;

		try {

			String sCurrentLine;

			br = new BufferedReader(new FileReader(fileName));

			while ((sCurrentLine = br.readLine()) != null) {
				content += sCurrentLine;
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {
				br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		return content;
	}

	String getLanguage(String filename) {				//function to determine language
		

		GetProgrammingLanguage s = new GetProgrammingLanguage();
		String test = s.getFileContent(filename);
		if (test.matches("(\\<)(\\?)(\\w|\\W|\\s)*")||test.matches("(\\s+|\\t+)*(import|package)(\\s)+java")) {

			return "PHP";
		} else if (test.matches(".*class.*[\\{].*[\\}]")) {

			return "Java";
		} else {
			return "Ruby";
		}
	}

	void showClassName(String filename) {				//function to determine classes' name
		String test1 = "class";
		System.out.println("Classes found in the file:");
		boolean class_found = false;
		GetProgrammingLanguage d = new GetProgrammingLanguage();
		StringTokenizer st = new StringTokenizer(d.getFileContent(filename));
		while (st.hasMoreElements()) {
			String f = st.nextElement().toString();
			if (f.contains(test1)) {
				class_found = true;
				System.out.println(st.nextElement().toString());
			}
		}
		if (!class_found)
			System.out.println("NO CLASS FOUND");

	}

	void ListFunctions(String fileName) {				//function to list function
		GetProgrammingLanguage g = new GetProgrammingLanguage();
		String currentLine = g.getContentLines(fileName);
		String lang = g.getLanguage(fileName);
		Scanner sc = new Scanner(currentLine);
		System.out.println("Functions:");
		LinkedHashSet<String> arr= new LinkedHashSet<String>();
		if (lang.equals("PHP")) {
			Pattern pattern = Pattern
					.compile("(public|protected|private)*(\\s)+(function)*(\\s+|\\W)(\\w+)(\\()");
			while (sc.hasNext()) {
				String temp = sc.nextLine();
				Matcher matcher = pattern.matcher(temp);
				while (matcher.find()) {
					arr.add(matcher.group(5) + "\t"+ matcher.group(1));
				}
			}
			System.out.println(arr);
		}

		else if (lang.equals("Java")) {
			Pattern pattern = Pattern
					.compile("(\\s|\\w|\\t)*(public|protected|private)(\\s)+(String|int|Integer|float|Float|void|Long|long|Double|double)(\\s+)(\\w+|\\W)+(\\s*)(\\()");
			while (sc.hasNext()) {

				String temp = sc.nextLine();
				Matcher matcher = pattern.matcher(temp);
				while (matcher.find()) {

					System.out.print("name: " + matcher.group(6) + "\t");
					System.out.println("Access Specifier: " + matcher.group(2));
				}
			}
		}

		/*
		 * else if(language.equals("Java")) { //code for java while
		 * (st.hasMoreElements()) { String s = st.nextElement().toString();
		 * for(int i=0;i<s.length(); i++) { if(s.charAt(i)=='(') { s =
		 * s.substring(0, i); func_names[count]=s;
		 * System.out.println(func_names[count]); count++; }
		 * 
		 * } } }
		 */
		else if (lang.equals("Ruby")) {
			Pattern pattern = Pattern
					.compile("(\\s|\\w|\\t)*(def)(\\s+)(\\w+)");
			while (sc.hasNext()) {

				String temp = sc.nextLine();
				Matcher matcher = pattern.matcher(temp);
				while (matcher.find()) {
					System.out.println(matcher.group(4));
				}
			}
		} else {
			System.out.println("No functions found");
		}
		sc.close();
	}

	void showAttributes(String filename) {				//function to list attributes

		GetProgrammingLanguage g = new GetProgrammingLanguage();
		String currentLine = g.getContentLines(filename);
		String lang = g.getLanguage(filename);
		Scanner sc = new Scanner(currentLine);
		System.out.println("Attributes:");
		LinkedHashSet<String> arr = new LinkedHashSet<String>();
		if (lang.equals("PHP")) {
			Pattern pattern = Pattern.compile("[\\$][a-z|A-Z|0-9|_]+");
			while (sc.hasNext()) {
				String temp = sc.nextLine();
				Matcher matcher = pattern.matcher(temp);
				while (matcher.find()) {
					String s="";
					for (int k = matcher.start(); k < matcher.end(); k++) {
						s+=temp.charAt(k);
					}
					arr.add(s);
				}
			}
			System.out.println(arr);
			
		}

		else if (lang.equals("Java")) {

			Pattern pattern = Pattern
					.compile("[\\s|\\w|\t]+(String|int|Integer|float|Float|long|Long|double|Double|byte|Byte|char|Character)(\\s)+(\\w)+(\\s|\\+|\\-|\\*|;)");
			while (sc.hasNext()) {

				String temp = sc.nextLine();
				Matcher matcher = pattern.matcher(temp);
				while (matcher.find()) {
					String x = "";
					for (int k = matcher.start(); k < matcher.end() - 1; k++) {
						x += temp.charAt(k);
					}
					arr.add(x.replace("\t", ""));
				}
			}
			System.out.println(arr);
		} 
		else if (lang.equals("Ruby")) {
			Pattern pattern = Pattern
					.compile("[\\s|\\w]*[\\$|@][@]*[a-z|A-Z|0-9|_]+[;|\\s+]");
			while (sc.hasNext()) {

				String temp = sc.nextLine();
				Matcher matcher = pattern.matcher(temp);
				while (matcher.find()) {
					String x = "";
					for (int k = matcher.start(); k < matcher.end(); k++) {
						x += temp.charAt(k);

					}
					x = x.replace("@", "");
					arr.add(x.replace("\t", ""));

				}
			}
			
			System.out.println(arr);
		}
		sc.close();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GetProgrammingLanguage d = new GetProgrammingLanguage();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter filename: ");
		String p = sc.next();
		sc.close();
		d.showAttributes(p);
		d.showClassName(p);
		d.ListFunctions(p);
		String lang = d.getLanguage(p);
		System.out.println("Language: " + lang);
		IndentFile i = new IndentFile();	//object of class to Indent given file
		i.trim();
		if (lang.equals("Ruby")) {
			// i.indentFileRuby();
		} else if (lang.equals("Java")) {
			//i.indentFileJava()
		}
		else if(lang.equals("PHP"))
		{
			//i.indentFilePHP();
		}
	}

}
