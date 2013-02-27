package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.visitor.statement.StatementVisitor;

/**
 * Created with IntelliJ IDEA.
 * User: dimashifni
 * Date: 2/27/13
 * Time: 11:07 PM
 * To change this template use File | Settings | File Templates.
 */
public interface Statement extends ASTNode {
    <T> T accept(StatementVisitor<T> visitor);
}
