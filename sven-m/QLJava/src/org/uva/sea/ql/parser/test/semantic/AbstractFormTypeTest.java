package org.uva.sea.ql.parser.test.semantic;

import org.uva.sea.ql.parser.typechecker.FormTypeChecker;

public abstract class AbstractFormTypeTest extends TypeTest {
	private FormTypeChecker typeChecker;
	
	public AbstractFormTypeTest() {
		typeChecker = new FormTypeChecker(getEnvironment());
	}
	
	protected FormTypeChecker getTypeChecker() {
		return typeChecker;
	}
}
