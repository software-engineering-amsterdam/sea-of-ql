package org.uva.sea.ql.launcher;

import java.io.IOException;

import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.test.ParseError;
import org.uva.sea.ql.qlreader.InputReader;


public class Main {
	
	private static String path="/home/jahn/aa.java";
	private static InputReader reader;

	
	public static void main(String[] args) {
		
		try {
			reader=new InputReader(path);
			ANTLRParser parser=new ANTLRParser();
			parser.parse(reader.getQLCode());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
			
	}

}
