package org.uva.sea.ql.interpretation.evaluation;

import org.uva.sea.ql.ast.elements.Ident;
import org.uva.sea.ql.ast.types.AbstractMathType;
import org.uva.sea.ql.common.QLException;
import org.uva.sea.ql.common.returnfinder.ReturnFinder;
import org.uva.sea.ql.interpretation.SwingRegistry;
import org.uva.sea.ql.interpretation.components.content.QuestionPanel;
import org.uva.sea.ql.interpretation.exception.EmptyInputException;
import org.uva.sea.ql.interpretation.exception.EvaluationException;

class MathEvaluationVisitor extends EvaluationVisitor {
    private boolean replaceEmtyWithZero;

    public MathEvaluationVisitor(boolean replaceEmptyWithZero,
            SwingRegistry reg, Evaluator eval) {
        super(reg, eval);
    }

    @Override
    public void visit(Ident i) throws QLException {
        final QuestionPanel questionPanel = registry.getQuestionPanelByIdent(i);
        final Class<?> result = ReturnFinder.getResult(
                registry.getQuestionsAst(), questionPanel.getQuestionType());
        if (result.equals(AbstractMathType.class)) {
            final String val = questionPanel.getStringValue();
            if (val.trim().equals("")) {
                this.tryToReplaceEmptyInput();
            } else {
                this.tryToParseInput(questionPanel);
            }
        }
    }

    private void tryToReplaceEmptyInput() throws EmptyInputException {
        if (replaceEmtyWithZero) {
            mathRet = 0;
        } else {
            throw new EmptyInputException();
        }
    }

    private void tryToParseInput(QuestionPanel questionPanel)
            throws EvaluationException {
        try {
            questionPanel.setValid(true);
            mathRet = Float.parseFloat(questionPanel.getStringValue().replace(
                    ',', '.'));
        } catch (NumberFormatException ex) {
            questionPanel.setValid(false);
        }
    }

}
