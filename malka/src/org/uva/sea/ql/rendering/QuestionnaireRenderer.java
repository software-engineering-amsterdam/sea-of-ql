package org.uva.sea.ql.rendering;

import javax.swing.JFrame;

import org.uva.sea.ql.visitor.VisitingException;

public interface QuestionnaireRenderer {
	public void render(JFrame frame) throws VisitingException;
}
