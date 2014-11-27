import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class InputFile{

	private int javaAttributes=0;
	private int rubyAttributes=0;
	private int phpAttributes=0;
	private String content = "";
	
	public InputFile(String fileName)					//constructor which initializes the contents from the file
	{
		File file = new File(fileName);
		
		try {
			Scanner scanFile = new Scanner(new FileReader(file));
			while(scanFile.hasNext())
			{
				String currentToken = scanFile.next();
				if(currentToken.contains("//"))					//avoiding java/PHP single line comment content
				{
					scanFile.nextLine();
					phpAttributes++;
					javaAttributes++;
				}
				else if(currentToken.contains("#"))				//avoiding ruby/PHP style single line comment
				{
					scanFile.nextLine();
					phpAttributes++;
					rubyAttributes++;
				}
				else if(currentToken.contains("=begin"))			//avoiding Ruby style multiple line comment
				{
					while(!scanFile.next().contains("=end")){}
					this.rubyAttributes++;
				}
				else if(currentToken.contains("/*"))				//avoiding Java/PHP style multiple line comment
				{
					while(!scanFile.next().contains("*/")){}
					phpAttributes++;
					javaAttributes++;
				}
				else
				{
					content += currentToken + " ";
				}
			}
			scanFile.close();
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public int getJavaAttributes() {
		return javaAttributes;
	}
	public int getRubyAttributes() {
		return rubyAttributes;
	}
	public int getPhpAttributes() {
		return phpAttributes;
	}
	
	public String getContent() {
		return content;
	}
	public void increamentJavaAttributes() {
		javaAttributes++;
	}
	public void increamentPhpAttributes() {
		phpAttributes++;
	}
	public void increamentRubyAttributes() {
		rubyAttributes++;
	}

}
