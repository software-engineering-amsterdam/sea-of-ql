package org.uva.sea.ql.questionnaire;

import java.util.Map;

import org.uva.sea.ql.ast.expr.ASTNode;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.stat.Block;
import org.uva.sea.ql.ast.type.Type;

public class Questionnaire extends ASTNode {

	private final String questionnaireName;
	private final Block questionnaireBlock;
	private  Map<Ident,Type> typeEnv;
	
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

	public Map<Ident, Type> getTypeEnv() {
		return typeEnv;
	}

	public void setTypeEnv(Map<Ident, Type> typeEnv) {
		this.typeEnv = typeEnv;
	}
	

}
