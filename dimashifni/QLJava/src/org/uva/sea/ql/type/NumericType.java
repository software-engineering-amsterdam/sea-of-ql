package org.uva.sea.ql.type;

import org.uva.sea.ql.visitor.type.TypeVisitor;

/**
 * Created with IntelliJ IDEA.
 * User: dimashifni
 * Date: 2/28/13
 * Time: 12:06 AM
 * To change this template use File | Settings | File Templates.
 */
public class NumericType extends Type {
    @Override
    public <T> T accept(TypeVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public boolean isCompatibleTo(Type type) {
        return isCompatibleToNumeric();
    }

    public boolean isCompatibleToNumeric()
    {
        return true;
    }
}
