package org.uva.sea.ql.gui;

import static julius.validation.Assertions.state;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.stm.Form;
import org.uva.sea.ql.lead.Model;

/**
 * Represents a visual form. This class handles also the initial call for creating the gui, its
 * components like menus and the form.
 * 
 */
public class QLForm extends Application {

	private static final String FORM = "Form: ";
	private static final String RESOURCE_STYLE_CSS = "../../../../../resources/style.css";
	private final int WIDTH = 600;
	private final int HEIGHT = 350;

	private final Model model;
	private final Form form;

	/**
	 * 
	 * @param model
	 *            (not null)
	 * @param form
	 *            (not null)
	 */
	public QLForm(final Model model, final Form form) {
		this.model = model;
		this.form = form;

		state.assertNotNull(this.model, "VisibleForm.model");
		state.assertNotNull(this.form, "VisibleForm.form");
	}

	@Override
	public void start(final Stage stage) throws Exception {
		VBox root = createRootWithMenu();

		Scene scene = createScene(root, WIDTH, HEIGHT);

		Node formParts = createFormNode();
		addScrollPane(root, scene, formParts);

		stage.setScene(scene);
		stage.setTitle(FORM + form.getIdentifier().getName());
		stage.show();
	}

	private void addScrollPane(final VBox root, final Scene scene,
			final Node formParts) {
		ScrollPane scrollable = new ScrollPane();
		scrollable.prefHeightProperty().bind(scene.heightProperty());
		scrollable.prefWidthProperty().bind(scene.widthProperty());
		root.getChildren().add(scrollable);

		scrollable.setContent(formParts);
	}

	private Node createFormNode() {
		QLNodeCreator visitorBuilder = new QLNodeCreator(model);

		return form.accept(visitorBuilder);
	}

	private VBox createRootWithMenu() {
		VBox root = new VBox();
		root.getChildren().add(new QLMenuBar(model).create());

		return root;
	}

	private Scene createScene(final VBox root, final int width, final int height) {
		Scene scene = new Scene(root, width, height);
		scene.getStylesheets().add(
				ASTNode.class.getResource(RESOURCE_STYLE_CSS).toExternalForm());

		return scene;
	}

}
