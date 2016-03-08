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
	
	String tmp;
	
	private void doThisForIf() throws IOException{
		
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		
		Pattern p = Pattern.compile("if\\s*\\([\\S\\s]*?\\)\\{?");
		Pattern p1 = Pattern.compile("(\\/\\/.+)|(\\/(\\/|\\*).+?\\*\\/)|(\".*\")|(\\/\\*[\\s\\S]*?\\*\\/)");
		
		Matcher m, m1;
		StringBuffer strBuf = new StringBuffer();
		 
		while((tmp = reader.readLine()) != null){
			strBuf.append(tmp+ "\n" );
		}
		reader.close();
		
		if(!strBuf.toString().isEmpty()){	
		boolean chek = true;
		m1 = p1.matcher(strBuf); 
		while(chek) {
			if(m1.find(1)){
				strBuf.delete(m1.start(), m1.end());}
			else{
				chek = false;
			}
		}
		
		chek = true;
		m = p.matcher(strBuf);
		
		while(chek) {
			if( m.find()){ valueIf++; }
			else{ chek = false; }
		}
		
		}
	}
	
	private void doThisForTmp() throws IOException{
		
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		Pattern p = Pattern.compile(stringTmp); 
		Matcher m;
		boolean chek;
			
		while((tmp = reader.readLine()) != null){
				m = p.matcher(tmp);
				chek = true;
				
				while(chek) {
					if(m.find()){ valueTmp++; }
					else{ chek = false; }
				}
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
