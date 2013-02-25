package org.uva.sea.ql.ast.types;


public abstract class AbstractMathType extends AbstractType {

    public boolean equals(Object o){
        return o instanceof AbstractMathType;
    }

}
