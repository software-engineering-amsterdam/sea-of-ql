package org.uva.sea.ql.generation.html;

import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.types.Money;
import org.uva.sea.ql.ast.types.StrType;
import org.uva.sea.ql.common.interfaces.TypeVisitor;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class HTMLInputTypeVisitor implements TypeVisitor {
    private InputTypes type;

    public HTMLInputTypeVisitor() {

    }

    public final InputTypes getType() {
        return this.type;
    }

    @Override
    public final void visit(BooleanType b) {
        this.type = InputTypes.BOOLEAN;
    }

    @Override
    public final void visit(Money m) {
        this.type = InputTypes.MONEY;
    }

    @Override
    public final void visit(StrType s) {
        this.type = InputTypes.STRING;
    }

    @Override
    public final void visit(IntType i) {
        throw new NotImplementedException();
    }

}
