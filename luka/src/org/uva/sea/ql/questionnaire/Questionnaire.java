package org.uva.sea.ql.questionnaire;

import java.util.Map;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.uva.sea.ql.ast.expr.ASTNode;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.stat.Block;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.parser.antlr.QLLexer;
import org.uva.sea.ql.parser.antlr.QLParser;
import org.uva.sea.ql.parser.antlr.QLTreeWalker;

public class Questionnaire extends ASTNode {

	private final String questionnaireName;
	private final Block questionnaireBlock;

	public Questionnaire(String qName, Block block) {
		this.questionnaireName = qName;
		this.questionnaireBlock = block;
	}

	public static void main(String args[]) throws Exception {
		QLLexer lex = new QLLexer(
				new ANTLRFileStream(
						"/Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/questionnaireTemplate/gaming.txt",
						"UTF8"));

		CommonTokenStream tokens = new CommonTokenStream(lex);
		boolean onlyParse = false;
		QLParser parser = new QLParser(tokens);

		try {
			if (onlyParse) {
				parser.parse();
			} else {
				CommonTree tree = (CommonTree) parser.parse().getTree();
				CommonTreeNodeStream nodes = new CommonTreeNodeStream(tree);
				QLTreeWalker walker = new QLTreeWalker(nodes);

				Questionnaire questionnaire = walker.walk();

				Map<Ident, Type> typeEnv = parser.typeEnv;

				QuestionnaireProcessor processor = new QuestionnaireProcessor(
						questionnaire, typeEnv);
				processor.process();
			}

		} catch (RecognitionException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "Questionnaore name: " + this.questionnaireName;
	}

	public Block getBlock() {
		return this.questionnaireBlock;
	}

	public String getName() {
		return this.questionnaireName;
	}

}
