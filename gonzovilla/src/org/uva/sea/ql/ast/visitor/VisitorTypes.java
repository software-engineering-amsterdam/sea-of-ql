package org.uva.sea.ql.ast.visitor;

import org.uva.sea.ql.ast.types.TypeBool;
import org.uva.sea.ql.ast.types.TypeError;
import org.uva.sea.ql.ast.types.TypeInt;
import org.uva.sea.ql.ast.types.TypeString;

public interface VisitorTypes <T> {

	T visit(TypeBool typeBool);
	T visit(TypeError typeError);
	T visit(TypeInt typeInt);
	T visit(TypeString typeString);

}
