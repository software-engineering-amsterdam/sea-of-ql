package org.uva.sea.ql.visitor.type;

import org.uva.sea.ql.type.IntType;
import org.uva.sea.ql.type.NumericType;
import org.uva.sea.ql.value.IntegerValue;
import org.uva.sea.ql.value.Value;

/**
 * Created with IntelliJ IDEA.
 * User: dimashifni
 * Date: 2/28/13
 * Time: 12:29 AM
 * To change this template use File | Settings | File Templates.
 */
public class DefaultValue implements TypeVisitor<Value> {
    @Override
    public Value visit(IntType type) {
        return new IntegerValue(0);
    }

    @Override
    public Value visit(NumericType type) {
        throw new UnsupportedOperationException("");
    }
}
