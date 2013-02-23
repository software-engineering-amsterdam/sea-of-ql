package org.uva.sea.ql.interpretation.exception;

import org.uva.sea.ql.interpretation.components.content.QuestionPanel;

public class InvalidInputException extends EvaluationException {

    private static final long serialVersionUID = 7198037478207889231L;
    private final QuestionPanel questionPanel;

    public InvalidInputException(QuestionPanel q) {
        super("invalid input");
        this.questionPanel = q;
    }
    public final QuestionPanel getQuestionPanel(){
        return this.questionPanel;
    }
}
