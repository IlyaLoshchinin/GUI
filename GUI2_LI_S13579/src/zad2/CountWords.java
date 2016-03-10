/**
 *
 *  @author Loshchinin Illia S13579
 *
 */

package zad2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountWords {
	
	String fname;
	List<String> str = new ArrayList<String>();
	public CountWords(String fname) throws IOException{
		this.fname = fname;
		doIt();
	}
	
	private void doIt() throws IOException{
		try{
		BufferedReader reader = new BufferedReader(new FileReader(fname));
		
		StringBuffer strBuf = new StringBuffer();
		String tmp;
		
		LinkedHashMap<String,Integer> lHashMap = new LinkedHashMap<String,Integer>();
		
		Pattern p = Pattern.compile("(?=(.?|^))[\\w]+(?=(.?|$))");
		Matcher m ;
		while((tmp = reader.readLine()) != null){
			m = p.matcher(tmp);
			
			while(m.find()){
				strBuf.append(m.group() + " ");
				lHashMap.put(m.group(), 0);
			}
		}
		reader.close();
	
		System.out.println(strBuf);
		Pattern p1;
		Matcher m1;
		int i = 0;
		
		for (Map.Entry<String, Integer> entry: lHashMap.entrySet()){
			p1 = Pattern.compile("(?<=\\W|^)"+entry.getKey()+"(?=\\W|$)");
			m1 = p1.matcher(strBuf);
			
			while(m1.find()){
				i++;
			}
			entry.setValue(i);
			i = 0;
			
			str.add(entry.getKey() + " "+ entry.getValue());
		}
		}catch(FileNotFoundException e){
			System.out.print("Nie ma takiego pliku");
		}
	}

	public List<String> getResult() {
		return this.str;
	}


}  
