package org.uva.sea.ql.ast.literal;

import java.util.List;

import org.uva.sea.ql.ast.elements.Question;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.interfaces.ReturnTypes;
import org.uva.sea.ql.ast.interfaces.Returns;
import org.uva.sea.ql.ast.interfaces.ReturnsMathOperands;

public class IntLiteral extends Expr implements ReturnsMathOperands, Returns{

	private final int value;

	public IntLiteral(int n) {
		this.value = n;
	}

	public final int getValue() {
		return this.value;
	}

    @Override
    public ReturnTypes getReturnType(List<Question> questions) {
       return ReturnTypes.MATH;
    }
	

}
