package org.uva.sea.ql.generation.html;

import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.types.Money;
import org.uva.sea.ql.ast.types.StrType;
import org.uva.sea.ql.common.TypeVisitor;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class InputTypeVisitor implements TypeVisitor{
    
    private InputTypes type;
    public InputTypes getType(){
        return type;        
    }

    @Override
    public void visit(BooleanType b) {
        this.type = InputTypes.BOOLEAN;        
    }

    @Override
    public void visit(Money m) {
        this.type = InputTypes.MONEY;
    }

    @Override
    public void visit(StrType s) {
        this.type = InputTypes.STRING;
    }

    @Override
    public void visit(IntType i) {
        throw new NotImplementedException();
    }

}
