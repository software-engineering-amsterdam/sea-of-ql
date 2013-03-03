package org.uva.sea.ql.visitor.statement;

import org.uva.sea.ql.ast.statement.*;

/**
 * Created with IntelliJ IDEA.
 * User: dimashifni
 * Date: 2/28/13
 * Time: 12:12 AM
 * To change this template use File | Settings | File Templates.
 */
public interface StatementVisitor<T> {
    T visit(Assignment node);
    T visit(IfStatement node);
    T visit(ComputedAssignment node);
    T visit(Block node);
    T visit(ObservableStatement node);
}
