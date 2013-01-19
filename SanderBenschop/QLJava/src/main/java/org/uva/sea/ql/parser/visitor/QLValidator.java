package org.uva.sea.ql.parser.visitor;

import java.util.Collection;

public interface QLValidator {

    Collection<QLError> getErrors();
}
