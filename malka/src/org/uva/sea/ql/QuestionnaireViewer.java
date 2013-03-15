package org.uva.sea.ql;

import java.io.FileNotFoundException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.reading.FormReader;
import org.uva.sea.ql.rendering.FormRenderer;
import org.uva.sea.ql.rendering.QuestionnaireRenderer;
import org.uva.sea.ql.validation.FormTypeChecker;
import org.uva.sea.ql.validation.IQuestionnaireTypeChecker;
import org.uva.sea.ql.validation.TypeCheckerException;
import org.uva.sea.ql.visitor.VisitingException;

public class QuestionnaireViewer extends JFrame{
	private static final long serialVersionUID = 1L;
	
	public QuestionnaireViewer(QuestionnaireRenderer renderer) {
		setTitle("Questionnaire");
		setSize(600, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		try{
			renderer.render(this);
		} catch (VisitingException e) {
			e.printStackTrace();
			System.err.println("Internal visitor error");
		}
	}
	
	public static void main(final String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FormReader reader = new FormReader();
				IQuestionnaireTypeChecker type_checker = new FormTypeChecker();
				Form form = null;
				
				if (args.length > 0) {
					try {
						form = reader.read(args[0]);
						if (type_checker.checkTypes(form)) {
							QuestionnaireViewer questionnaire_viewer = new QuestionnaireViewer(new FormRenderer(form));
							questionnaire_viewer.setVisible(true);
						} else {
							System.err.println("Type error!");
						}
					} catch(FileNotFoundException e) {
						System.err.println("File not found!");
					} catch(TypeCheckerException e) {
						System.err.println("Error type checking");
					} catch (VisitingException e) {
						e.printStackTrace();
						System.err.println("Internal visitor error");
					} catch(Exception e) {
						//System.err.println(e.getClass());
						System.err.println("Unknown error!");
					}
            	}
            }
        });
	}
}
