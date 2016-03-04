/**
 *
 *  @author Loshchinin Illia S13579
 *
 */

package zad2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Finder {
		
	private String fileName;
	private int valueIf;
	private int valueTmp;
	private String stringTmp;
	
	public Finder(String fileName){
		if(fileName != null)
			this.fileName = fileName;
	}
	
	String findIf = "[^\";]?if\\(.*[^\"]\\)\\{?"; 
	String tmp;
	
	
	private void doThisForIf() throws IOException{
		
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		Pattern p = Pattern.compile(findIf);
		Matcher m, m1;

		while((tmp = reader.readLine()) != null){
			m = p.matcher(tmp);
			if(m.find()){
				Pattern p1 = Pattern.compile("\\/(\\/|\\*).+");
				m1 = p1.matcher(tmp);
				if(!m1.find())
					valueIf++;
			}
		}
		reader.close();
	}
	
	private void doThisForTmp() throws IOException{
		
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		Pattern p = Pattern.compile(stringTmp);
		Matcher m;

			while((tmp = reader.readLine()) != null){
				m = p.matcher(tmp);
					if(m.find())
						valueTmp++;	
			}
		reader.close();
	}
	

	public int getIfCount() throws IOException{
		doThisForIf();
		return valueIf;
	}
	
	public int getStringCount(String tmp) throws IOException{
		stringTmp = tmp;
		doThisForTmp();
		return valueTmp;
	}
	

}    
