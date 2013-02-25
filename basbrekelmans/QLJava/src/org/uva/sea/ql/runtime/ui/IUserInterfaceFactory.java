package org.uva.sea.ql.runtime.ui;

import org.uva.sea.ql.ast.form.Form;

public interface IUserInterfaceFactory {
	IWindow create(Form form);
}
