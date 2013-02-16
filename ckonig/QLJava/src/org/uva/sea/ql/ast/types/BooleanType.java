package org.uva.sea.ql.ast.types;

import java.util.List;

import org.uva.sea.ql.ast.elements.Question;
import org.uva.sea.ql.ast.interfaces.ReturnTypes;

public class BooleanType extends Type  {

	public BooleanType() {

	}
	 @Override
	    public ReturnTypes getReturnType(List<Question> questions) {
	       return ReturnTypes.BOOLEAN;
	    }
}
