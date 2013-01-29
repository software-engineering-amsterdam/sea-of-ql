package org.uva.sea.ql.ast.primary.typeClasses;

public interface Type {

    boolean isCompatibleTo(Type type);
    boolean isCompatibleToBooleanType();
    boolean isCompatibleToIntegerType();
    boolean isCompatibleToStringType();
}
