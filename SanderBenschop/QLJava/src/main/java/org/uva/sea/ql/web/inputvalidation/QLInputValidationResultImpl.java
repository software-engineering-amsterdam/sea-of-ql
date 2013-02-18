package org.uva.sea.ql.web.inputvalidation;

import javax.ws.rs.core.Response;

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

    @Override
    public Response toResponse() {
        Response.ResponseBuilder builder = null;
        if (correct) {
            builder = Response.status(Response.Status.OK);
        } else {
            builder = Response.status(Response.Status.BAD_REQUEST);
        }
        return builder.entity(message).build();
    }
}
