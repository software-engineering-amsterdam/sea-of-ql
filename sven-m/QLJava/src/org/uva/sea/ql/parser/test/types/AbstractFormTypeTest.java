package org.uva.sea.ql.parser.test.types;

import org.uva.sea.ql.parser.typechecking.FormTypeChecker;

public abstract class AbstractFormTypeTest extends TypeTest {
	private FormTypeChecker typeChecker;
	
	public AbstractFormTypeTest() {
		typeChecker = new FormTypeChecker(getEnvironment());
	}
	
	protected FormTypeChecker getTypeChecker() {
		return typeChecker;
	}
}
