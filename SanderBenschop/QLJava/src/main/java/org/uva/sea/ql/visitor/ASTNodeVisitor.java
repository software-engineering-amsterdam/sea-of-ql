package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.binary.BinaryOperation;
import org.uva.sea.ql.ast.formelement.Computation;
import org.uva.sea.ql.ast.formelement.Conditional;
import org.uva.sea.ql.ast.formelement.Question;
import org.uva.sea.ql.ast.primary.Datatype;
import org.uva.sea.ql.ast.primary.Ident;
import org.uva.sea.ql.ast.unary.UnaryOperation;

public interface ASTNodeVisitor {

    void visitComputation(Computation computation);
    void visitConditional(Conditional conditional);
    void visitQuestion(Question question);
    void visitUnaryOperation(UnaryOperation unaryOperation);
    void visitBinaryOperation(BinaryOperation binaryOperation);
    void visitIdent(Ident ident);
    void visitDatatype(Datatype<?> datatype);
}
