package org.uva.sea.ql.type;

import org.uva.sea.ql.visitor.type.TypeVisitor;

/**
 * Created with IntelliJ IDEA.
 * User: dimashifni
 * Date: 3/2/13
 * Time: 6:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class MoneyType extends NumericType {

    @Override
    public <T> T accept(TypeVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public boolean isCompatibleTo(Type type) {
        return isCompatibleToMoney();
    }

    @Override
    public boolean isCompatibleToMoney() {
        return true;
    }
}
