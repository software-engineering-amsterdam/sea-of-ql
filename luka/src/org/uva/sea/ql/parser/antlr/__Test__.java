package org.uva.sea.ql.parser.antlr;
import org.antlr.runtime.*;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;


public class __Test__ {

    public static void main(String args[]) throws Exception {
        QLLexer lex = new QLLexer(new ANTLRFileStream("/Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/__Test___input.txt", "UTF8"));
        CommonTokenStream tokens = new CommonTokenStream(lex);
        QLParser parser = new QLParser(tokens,49100,null); //
        
        // TREE
     //   CommonTree t  = (CommonTree) parser.parse().getTree();
     //   CommonTreeNodeStream nodes = new CommonTreeNodeStream(t);
    //    Eval2 evaluator = new Eval2(nodes);
       // evaluator.prog();
        
       
        try {
        	parser.parse();
        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }
}