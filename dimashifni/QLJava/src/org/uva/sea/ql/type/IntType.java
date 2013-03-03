package org.uva.sea.ql.type;

import org.uva.sea.ql.visitor.type.TypeVisitor;

/**
 * Created with IntelliJ IDEA.
 * User: dimashifni
 * Date: 2/27/13
 * Time: 10:58 PM
 * To change this template use File | Settings | File Templates.
 */
// TODO define BoolType, StrType, MoneyType
public class IntType extends NumericType {
    @Override
    public <T> T accept(TypeVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public boolean isCompatibleTo(Type type) {
        return type.isCompatibleToInteger();
    }

    @Override
    public boolean isCompatibleToInteger() {
        return true;
    }
}
