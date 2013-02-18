package org.uva.sea.ql.questionnaire;

import java.util.Map;

import org.uva.sea.ql.ast.expr.ASTNode;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.stat.Block;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.parser.antlr.ParserProcessor;

public class Questionnaire extends ASTNode {

	private final String questionnaireName;
	private final Block questionnaireBlock;

	public Questionnaire(String qName, Block block) {
		this.questionnaireName = qName;
		this.questionnaireBlock = block;
	}

	public static void main(String args[]) throws Exception {
		String qlLocation = "/Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/questionnaireTemplate/something.txt";
		ParserProcessor parser = new ParserProcessor();
		Questionnaire questionnaire  = parser.parse(qlLocation,false);
		Map<Ident, Type> typeEnv = parser.getTypeEnv();

		QuestionnaireProcessor processor = new QuestionnaireProcessor(
				questionnaire, typeEnv);
		processor.process();

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
