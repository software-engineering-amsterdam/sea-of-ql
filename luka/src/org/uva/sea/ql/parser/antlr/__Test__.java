package org.uva.sea.ql.parser.antlr;
import org.antlr.runtime.*;


public class __Test__ {

    public static void main(String args[]) throws Exception {
        QLLexer lex = new QLLexer(new ANTLRFileStream("/Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/__Test___input.txt", "UTF8"));
        CommonTokenStream tokens = new CommonTokenStream(lex);

        QLParser g = new QLParser(tokens,49100,null); //
        try {
           g.parse();
        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }
}