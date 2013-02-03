package org.uva.sea.ql.ast.primary.typeClasses;

public interface Type {

    String getObjectLiteralSimpleClassName();

    boolean isCompatibleTo(Type type);
    boolean isCompatibleToBooleanType();
    boolean isCompatibleToIntegerType();
    boolean isCompatibleToStringType();
}
