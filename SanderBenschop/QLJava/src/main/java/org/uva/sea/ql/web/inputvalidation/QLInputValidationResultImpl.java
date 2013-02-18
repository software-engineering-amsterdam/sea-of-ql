package org.uva.sea.ql.web.inputvalidation;

public class QLInputValidationResultImpl implements QLInputValidationResult {

    private final boolean correct;
    private final String message;

    public QLInputValidationResultImpl(boolean correct, String message) {
        this.correct = correct;
        this.message = message;
    }

    @Override
    public boolean isCorrect() {
        return correct;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
