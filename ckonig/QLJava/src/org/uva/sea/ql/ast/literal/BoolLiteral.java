package org.uva.sea.ql.ast.literal;

import java.util.List;

import org.uva.sea.ql.ast.elements.Question;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.interfaces.ReturnTypes;
import org.uva.sea.ql.ast.interfaces.Returns;

public class BoolLiteral extends Expr implements Returns{
	private boolean value;
	public BoolLiteral(Boolean b) {
		this.value = b;
	}
	public final boolean getValue(){
		return this.value;
	}
    @Override
    public ReturnTypes getReturnType(List<Question> questions) {
       return ReturnTypes.BOOLEAN;
    }
}
