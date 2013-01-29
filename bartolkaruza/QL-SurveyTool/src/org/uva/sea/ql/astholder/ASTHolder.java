package org.uva.sea.ql.astholder;

import org.uva.sea.ql.ast.Form;

public class ASTHolder {
	
	private static Form form;
	
	public static Form getInstance() {
		return form;
	}

}
