package org.uva.sea.ql.gui;

import static julius.validation.Assertions.state;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
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
public class VisibleForm extends Application {

	private static final String FILE_ITEM_SAVE = "Save";
	private static final String FILE_MENU_TEXT = "File";
	private static final String RESOURCE_STYLE_CSS = "../../../../../resources/style.css";
	private final int WIDTH = 600;
	private final int HEIGHT = 500;

	private final Model model;
	private final Form form;

	/**
	 * 
	 * @param model
	 *            (not null)
	 * @param form
	 *            (not null)
	 */
	public VisibleForm(final Model model, final Form form) {
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
		stage.setTitle(form.getIdentifier().getName());
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
		VisibleFormNodeCreator visitorBuilder = new VisibleFormNodeCreator(
				model);

		return form.accept(visitorBuilder);
	}

	private VBox createRootWithMenu() {
		VBox root = new VBox();
		root.getChildren().add(createMenuItems());

		return root;
	}

	private MenuBar createMenuItems() {
		MenuItem save = new MenuItem(FILE_ITEM_SAVE);

		Menu fileMenu = new Menu(FILE_MENU_TEXT);
		fileMenu.getItems().add(save);

		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().add(fileMenu);

		return menuBar;
	}

	private Scene createScene(final VBox root, final int width, final int height) {
		Scene scene = new Scene(root, width, height);
		scene.getStylesheets().add(
				ASTNode.class.getResource(RESOURCE_STYLE_CSS).toExternalForm());

		return scene;
	}

}
