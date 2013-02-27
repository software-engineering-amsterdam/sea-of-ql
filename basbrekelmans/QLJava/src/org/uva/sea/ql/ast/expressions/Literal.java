package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ICodeLocationInformation;

public abstract class Literal extends Simple {

	Literal(final ICodeLocationInformation codeLocation) {
		super(codeLocation);
	}
}