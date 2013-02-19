package org.uva.sea.ql.ast.type;

public interface Type {

    String getName();

    boolean canTakeValue(String value);

    boolean isCompatibleTo(Type type);

    boolean isCompatibleToBooleanType();

    boolean isCompatibleToIntegerType();

    boolean isCompatibleToStringType();
}
