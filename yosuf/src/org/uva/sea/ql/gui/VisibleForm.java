package org.uva.sea.ql.gui;

import static julius.validation.Assertions.state;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import org.uva.sea.ql.ast.stm.Form;
import org.uva.sea.ql.lead.Model;

/**
 * Represents a visual form
 * 
 */
public class VisibleForm extends Application {

	private final int WIDTH = 600;
	private final int HEIGHT = 500;

	private final Model model;
	private final Form form;

	public VisibleForm(final Model model, final Form form) {
		this.model = model;
		this.form = form;

		state.assertNotNull(this.model, "VisibleForm.model");
		state.assertNotNull(this.form, "VisibleForm.form");
	}

	@Override
	public void start(final Stage stage) throws Exception {
		VBox root = new VBox();
		Scene scene = createScene(root, WIDTH, HEIGHT);

		Node formParts = createFormNode();
		root.getChildren().add(formParts);
		stage.setScene(scene);
		stage.show();
	}

	private Node createFormNode() {
		VisibleFormNodeCreator visitorBuilder = new VisibleFormNodeCreator();

		return form.accept(visitorBuilder);
	}

	private Scene createScene(final VBox root, final int width, final int height) {
		Scene scene = new Scene(root, width, height);
		return scene;
	}
}
