package org.uva.sea.ql.ast.primary.typeClasses;

public interface Type {

    String getObjectLiteralSimpleClassName();

    boolean canBeAssignedFrom(String value);

    boolean isCompatibleTo(Type type);
    boolean isCompatibleToBooleanType();
    boolean isCompatibleToIntegerType();
    boolean isCompatibleToStringType();
}
