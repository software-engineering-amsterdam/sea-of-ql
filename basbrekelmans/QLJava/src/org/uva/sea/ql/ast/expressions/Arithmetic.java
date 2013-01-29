package org.uva.sea.ql.ast.expressions;
import org.uva.sea.ql.ICodeLocationInformation;

public abstract class Arithmetic extends Binary {
	public Arithmetic(ICodeLocationInformation codeLocation, Expression left, Expression right) {
		super(codeLocation, left, right);
	}
}
