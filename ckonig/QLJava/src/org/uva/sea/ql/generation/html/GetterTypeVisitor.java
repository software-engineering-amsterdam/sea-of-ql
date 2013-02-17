package org.uva.sea.ql.generation.html;

import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.types.Money;
import org.uva.sea.ql.ast.types.StrType;
import org.uva.sea.ql.common.TypeVisitor;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class GetterTypeVisitor implements TypeVisitor {
    
    private Templates templates;
    private String getter;
    private String name;
    public GetterTypeVisitor(Templates t, String name){
        this.templates = t;
        this.name = name;
    }
    
    @Override
    public void visit(BooleanType b) {
        this.getter = this.templates.getterBool(name);
    }

    @Override
    public void visit(Money m) {
        this.getter = this.templates.getterMoney(name);
    }

    @Override
    public void visit(StrType s) {
        this.getter = this.templates.getterString(name);
    }

    @Override
    public void visit(IntType i) {
        throw new NotImplementedException();
    }
    
    public String getGetter(){
        return getter;
    }

}
