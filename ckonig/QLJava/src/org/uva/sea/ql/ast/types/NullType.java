package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.interpretation.TypeVisitor;

public class NullType extends AbstractType {
    
    public NullType(){
        
    }
    
    @Override
    public final void accept(TypeVisitor v) {
       v.visit(this);
    }

}
