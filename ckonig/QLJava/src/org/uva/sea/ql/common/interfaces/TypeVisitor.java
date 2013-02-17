package org.uva.sea.ql.common.interfaces;

import org.uva.sea.ql.ast.types.*;

public interface TypeVisitor {
    
    public void visit(BooleanType b);
    
    public void visit(Money m);
    
    public void visit(StrType s);
    
    public void visit(IntType i);
}
