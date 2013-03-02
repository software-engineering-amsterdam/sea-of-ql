package org.uva.sea.ql.type;

import org.uva.sea.ql.type.Type;
import java.lang.Override;
import org.uva.sea.ql.visitor.type.TypeVisitor;

/**
 * Created with IntelliJ IDEA.
 * User: dimashifni
 * Date: 2/28/13
 * Time: 11:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class BoolType extends Type {

    @Override
    public <T> T accept(TypeVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public boolean isCompatibleTo(Type type) {
        return isCompatibleToBoolean();
    }

    @Override
    public boolean isCompatibleToBoolean() {
        return true;
    }
}
