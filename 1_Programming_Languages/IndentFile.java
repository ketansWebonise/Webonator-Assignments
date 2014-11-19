import java.io.FileOutputStream;
import java.util.Scanner;

//For Indenting Ruby File
public class IndentFile {
	
	GetProgrammingLanguage g = new GetProgrammingLanguage();
	String test = g.getContentLines("binding.rb");
Scanner sc = new Scanner(test);
public String content = "";
void trim()
{
	String temp="";
	Scanner s = new Scanner(test);
	while(s.hasNext())
	{
		temp+=s.nextLine().trim()+"\n";
	}
	test=temp;
	s.close();
}
void indentFileRuby()
{
	
	this.trim();	
	while(sc.hasNext())
	{
		this.fun();
	}
	try
	{
		FileOutputStream fin = new FileOutputStream("binding.rb",false);
		for(int i=0;i<test.length();i++)
		{
			fin.write(test.charAt(i));
		}
		fin.close();
	}
catch(Exception e)
{
	e.printStackTrace();
}
}
void fun()
{
String s = sc.nextLine();
if(s.contains("class")||s.contains("def"))
{
	content+=s;
	System.out.println(s);
	this.fun();
}
while(!sc.nextLine().contains("end"))
{
	String d="\t"+sc.nextLine();
	System.out.println(d);
	content+=d;
	}
	}

}
