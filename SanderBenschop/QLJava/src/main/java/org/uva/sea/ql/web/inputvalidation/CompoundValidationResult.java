package org.uva.sea.ql.web.inputvalidation;

import java.util.ArrayList;
import java.util.List;

public class CompoundValidationResult implements QLInputValidationResult {

    private final List<QLInputValidationResult> erroneousValidationResults;

    public CompoundValidationResult() {
        this.erroneousValidationResults = new ArrayList<QLInputValidationResult>();
    }

    @Override
    public boolean isCorrect() {
        return erroneousValidationResults.isEmpty();
    }

    @Override
    public String getMessage() {
        if (erroneousValidationResults.isEmpty()) {
            return OK_MESSAGE;
        } else {
            StringBuilder errorMessageBuilder = new StringBuilder();
            for (QLInputValidationResult erroneousValidationResult : erroneousValidationResults) {
                errorMessageBuilder.append(erroneousValidationResult.getMessage());
            }
            return errorMessageBuilder.toString();
        }
    }

    public void addInputValidationResult(QLInputValidationResult validationResult) {
        if (!validationResult.isCorrect()) {
            this.erroneousValidationResults.add(validationResult);
        }
    }
}
