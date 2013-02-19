package org.uva.sea.ql.parser.test.types;

import org.uva.sea.ql.parser.typechecking.FormTypeChecker;

public abstract class AbstractFormTypeTest {
	private FormTypeChecker formTypeChecker;
	private Environment environment;
	
	public AbstractFormTypeTest() {
		super();
		
		formTypeChecker = new FormTypeChecker(null, null);
	}
}
