package org.uva.sea.ql.questionnaire;

import org.uva.sea.ql.ast.expr.ASTNode;
import org.uva.sea.ql.ast.stat.Block;

public class Questionnaire extends ASTNode {

	private final String questionnaireName;
	private final Block questionnaireBlock;


	public Questionnaire(String qName, Block block) {
		this.questionnaireName = qName;
		this.questionnaireBlock = block;
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

	// public Map<Ident, Type> getTypeEnv() {
	// return typeEnv;
	// }

	// public void setTypeEnv(Map<Ident, Type> typeEnv) {
	// this.typeEnv = typeEnv;
	// }

}
