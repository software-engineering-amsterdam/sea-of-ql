package org.uva.sea.ql.interpretation.evaluation;

import org.uva.sea.ql.ast.elements.Ident;
import org.uva.sea.ql.ast.literals.StringLiteral;
import org.uva.sea.ql.ast.types.AbstractType;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.common.QLException;
import org.uva.sea.ql.interpretation.SwingRegistry;
import org.uva.sea.ql.interpretation.components.content.QuestionPanel;
import org.uva.sea.ql.interpretation.exception.EmptyInputException;
import org.uva.sea.ql.interpretation.exception.EvaluationException;

class MathEvaluationVisitor extends AbstractEvaluationVisitor {
    private boolean replaceEmtyWithZero = true;

    public MathEvaluationVisitor(SwingRegistry reg, Evaluator eval,
            boolean replaceEmptyWithZero) {
        super(reg, eval);
    }

    @Override
    public void visit(Ident i) throws QLException {
        final QuestionPanel questionPanel = registry.getQuestionPanelByIdent(i);
        final AbstractType result = questionPanel.getQuestionType();
        if (result.equals(new IntType())) {
            final StringLiteral val = questionPanel.getStringValue();
            if (val.isEmpty()) {
                this.tryToReplaceEmptyInput();
            } else {
                this.tryToParseInput(questionPanel);
            }
        }
    }

    private void tryToReplaceEmptyInput() throws EmptyInputException {
        if (this.replaceEmtyWithZero) {
            mathRet = 0;
        } else {
            throw new EmptyInputException();
        }
    }

    private void tryToParseInput(QuestionPanel questionPanel)
            throws EvaluationException {
        try {
            questionPanel.setValid(true);
            mathRet = Float.parseFloat(questionPanel.getStringValue()
                    .replaceCommaWithDot().toString());
        } catch (NumberFormatException ex) {
            questionPanel.setValid(false);
        }
    }

}
