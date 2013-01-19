package org.uva.sea.ql.parser.visitor;

import java.util.Collection;

public interface QLValidator<T extends QLError> {

    Collection<T> getErrors();
}
