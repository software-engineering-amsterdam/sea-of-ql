package org.uva.sea.ql.parser.antlr;

import java.util.Map;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.questionnaire.Questionnaire;

public class ParserProcessor {

	private Map<Ident, Type> typeEnv;

	public Expr checkExpression(String src) throws RecognitionException{
		QLLexer lex= new QLLexer(new ANTLRStringStream(src));
		CommonTokenStream tokens = new CommonTokenStream(lex);
		QLParser parser = new QLParser(tokens);

		CommonTree tree = (CommonTree) parser.orExpr().getTree();
		CommonTreeNodeStream nodes = new CommonTreeNodeStream(tree);
		QLTreeWalker walker = new QLTreeWalker(nodes);
		return walker.expression();
		
		
	}
	public Questionnaire parse(String src, boolean test) {
		Questionnaire questionnaire = null;
		QLLexer lex;
		try {

			if (test) {
				lex = new QLLexer(new ANTLRStringStream(src));
			} else {
				lex = new QLLexer(new ANTLRFileStream(src, "UTF8"));
			}

			CommonTokenStream tokens = new CommonTokenStream(lex);
			// boolean onlyParse = false;
			QLParser parser = new QLParser(tokens);

			CommonTree tree = (CommonTree) parser.parse().getTree();
			CommonTreeNodeStream nodes = new CommonTreeNodeStream(tree);
			QLTreeWalker walker = new QLTreeWalker(nodes);
			
			questionnaire = walker.walk();
			this.typeEnv = parser.typeEnv;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return questionnaire;
	}

	public Map<Ident, Type> getTypeEnv() {
		return this.typeEnv;
	}
}
