package org.uva.sea.ql.ast.types;

import java.util.List;

import org.uva.sea.ql.ast.elements.Question;
import org.uva.sea.ql.ast.interfaces.ReturnTypes;
import org.uva.sea.ql.ast.interfaces.Returns;

public class IntType extends Type implements Returns {
    public IntType(){
        
    }
    @Override
    public ReturnTypes getReturnType(List<Question> questions) {
       return ReturnTypes.MATH;
    }
}
