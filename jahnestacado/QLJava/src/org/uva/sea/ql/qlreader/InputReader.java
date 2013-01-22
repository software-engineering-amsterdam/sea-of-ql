package org.uva.sea.ql.qlreader;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputReader {
	
	private  String fileContent="";
	
	
	public InputReader(String src) throws IOException{
		     
		    File file = new File(src);
            FileReader fstream  = new FileReader(file);
            BufferedReader  bufReader  = new BufferedReader(fstream);
            String strLine;
            

           while ((strLine = bufReader.readLine()) != null) {
        	   fileContent+=strLine;
        	  
           }
	
           bufReader.close();
		
	}
	
	public String getQLCode(){
			return fileContent;
	}
		
	

}
