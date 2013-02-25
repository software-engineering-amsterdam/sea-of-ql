package org.uva.sea.ql.validation;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.elements.Ident;
import org.uva.sea.ql.ast.elements.IfStatement;
import org.uva.sea.ql.ast.elements.Question;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.types.AbstractType;
import org.uva.sea.ql.common.QLException;
import org.uva.sea.ql.common.Registry;
import org.uva.sea.ql.common.returnfinder.ReturnFinder;

public class ValidationRegistry implements Registry {
    private List<Question> questions;
    private List<IfStatement> ifStatements;

    public ValidationRegistry() {
        this.questions = new ArrayList<Question>();
        this.ifStatements = new ArrayList<IfStatement>();
    }

    public final void addQuestion(Question q) {
        this.questions.add(q);
    }

    public final void addIfStatement(IfStatement i) {
        this.ifStatements.add(i);
    }

    @Override
    public final List<Question> getQuestions() {
        return this.questions;
    }

    @Override
    public final List<IfStatement> getIfStatements() {
        return this.ifStatements;
    }

    public final AbstractType getQuestionTypeByIdent(Ident i) {
        for (Question q : this.questions) {
            if (q.getIdentName().equals(i.getName())) {
                return q.getType();
            }
        }
        throw new RuntimeException("question not found: " + i.getName());
    }

    @Override
    public final AbstractType lookupReturnType(Expr condition) throws QLException {
        return ReturnFinder.getResult(this.getQuestions(), condition);
    }
}
