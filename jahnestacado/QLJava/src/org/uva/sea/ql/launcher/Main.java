package org.uva.sea.ql.launcher;

import java.io.IOException;

import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.test.ParseError;
import org.uva.sea.ql.qlreader.InputReader;


public class Main {
	
	
	public static void main(String[] args) {
		final String path="/home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/qlreader/SampleCode.ql";

		try {
			InputReader reader=new InputReader(path);
			ANTLRParser parser=new ANTLRParser();
			parser.parseForm(reader.getQLCode());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
			
	}

}
