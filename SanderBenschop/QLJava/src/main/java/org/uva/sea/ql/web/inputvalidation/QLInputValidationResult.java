package org.uva.sea.ql.web.inputvalidation;

import javax.xml.ws.Response;

public interface QLInputValidationResult {

    boolean isCorrect();

    String getMessage();

    javax.ws.rs.core.Response toResponse();
}
