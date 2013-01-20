package org.uva.sea.ql.parser.visitor;

import org.uva.sea.ql.ast.nodetypes.binary.BinaryOperation;
import org.uva.sea.ql.ast.nodetypes.formelement.Computation;
import org.uva.sea.ql.ast.nodetypes.formelement.Conditional;
import org.uva.sea.ql.ast.nodetypes.formelement.Question;
import org.uva.sea.ql.ast.nodetypes.primary.Ident;
import org.uva.sea.ql.ast.nodetypes.primary.Datatype;
import org.uva.sea.ql.ast.nodetypes.unary.UnaryOperation;

public interface ASTNodeVisitor {

    void visitComputation(Computation computation);
    void visitConditional(Conditional conditional);
    void visitQuestion(Question question);
    void visitUnaryOperation(UnaryOperation unaryOperation);
    void visitBinaryOperation(BinaryOperation binaryOperation);
    void visitIdent(Ident ident);
    void visitPrimary(Datatype datatype);
}
