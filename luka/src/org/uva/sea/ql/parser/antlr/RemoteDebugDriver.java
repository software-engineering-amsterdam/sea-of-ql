package org.uva.sea.ql.parser.antlr;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;

public class RemoteDebugDriver {
	 public static void main(String[] args) throws Exception {
		 
       //  InputStream stream = new ByteArrayInputStream("SOME TEXT TO PARSE".getBytes()); // defaults to ISO-1
       //  ANTLRInputStream inputStream = new ANTLRInputStream(stream);
         QLLexer lex = new QLLexer(new ANTLRFileStream("/Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/__Test___input.txt", "UTF8"));
         
     	CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(lex);
          QLParser parser = new QLParser(tokens);
         parser.parse();
         System.exit(0);
    }
}
