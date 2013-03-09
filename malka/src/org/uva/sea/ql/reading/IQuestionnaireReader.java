package org.uva.sea.ql.reading;

import java.io.FileNotFoundException;

import org.uva.sea.ql.Questionnaire;

public interface IQuestionnaireReader {
	public Questionnaire read(String filename) throws FileNotFoundException;
}
