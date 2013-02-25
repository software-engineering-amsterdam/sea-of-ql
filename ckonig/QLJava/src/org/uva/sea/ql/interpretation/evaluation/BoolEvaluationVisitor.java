package org.uva.sea.ql.interpretation.evaluation;

import org.uva.sea.ql.ast.elements.Ident;
import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.common.QLException;
import org.uva.sea.ql.interpretation.SwingRegistry;
import org.uva.sea.ql.interpretation.components.content.QuestionPanel;

class BoolEvaluationVisitor extends AbstractEvaluationVisitor {

    public BoolEvaluationVisitor(SwingRegistry reg, Evaluator eval) {
        super(reg, eval);
        this.registry = reg;
    }

    @Override
    public final void visit(Ident ident) throws QLException {
        final QuestionPanel q = registry.getQuestionPanelByIdent(ident);
        final Class<?> r = registry.lookupReturnType(ident);
        if (r.equals(BooleanType.class)) {
            boolRet = q.getBoolValue();
        }
    }
}
