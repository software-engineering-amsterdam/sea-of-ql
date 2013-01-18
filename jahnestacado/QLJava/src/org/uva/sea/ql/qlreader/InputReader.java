package org.uva.sea.ql.qlreader;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputReader {
	
	private  String fileContent="";
	
	
	public InputReader(String src) throws IOException{
		
            FileInputStream fstream  = new FileInputStream(src);
            DataInputStream in       = new DataInputStream(fstream);
            BufferedReader  br       = new BufferedReader(new InputStreamReader(in));
            String strLine;
            

           while ((strLine = br.readLine()) != null) {
        	   fileContent+=strLine;
           }
		
		
	}
	
	public String getQLCode(){
			return fileContent;
	}
		
	

}
