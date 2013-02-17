package org.uva.sea.ql.generation.html;

import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.types.Money;
import org.uva.sea.ql.ast.types.StrType;
import org.uva.sea.ql.common.interfaces.TypeVisitor;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class GetterTypeVisitor implements TypeVisitor {

    private Templates templates;
    private String getter;
    private String name;

    public GetterTypeVisitor(Templates t, String n) {
        this.templates = t;
        this.name = n;
    }

    @Override
    public final void visit(BooleanType b) {
        this.getter = this.templates.getterBool(this.name);
    }

    @Override
    public final void visit(Money m) {
        this.getter = this.templates.getterMoney(this.name);
    }

    @Override
    public final void visit(StrType s) {
        this.getter = this.templates.getterString(this.name);
    }

    @Override
    public final void visit(IntType i) {
        throw new NotImplementedException();
    }

    public final String getGetter() {
        return this.getter;
    }

}
