package org.uva.sea.ql.gui;

import static julius.validation.Assertions.state;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

import org.uva.sea.ql.lead.LogPrinter;
import org.uva.sea.ql.lead.Model;

public class QLMenuBar {

	private static final String FILE_ITEM_SAVE = "Save";
	private static final String FILE_MENU_TEXT = "File";

	private final Model model;

	/**
	 * @param model
	 *            (not null)
	 */
	public QLMenuBar(final Model model) {
		this.model = model;

		state.assertNotNull(this.model, "VisibleForm.model");
	}

	public MenuBar create() {
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().add(createFileMenu());

		return menuBar;
	}

	private Menu createFileMenu() {
		Menu fileMenu = new Menu(FILE_MENU_TEXT);
		fileMenu.getItems().add(createSave());
		return fileMenu;
	}

	private MenuItem createSave() {
		MenuItem save = new MenuItem(FILE_ITEM_SAVE);
		save.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(final ActionEvent arg0) {
				// TODO: implement save
				LogPrinter.debugInfo("TODO: save still to implement ;)");
			}
		});

		return save;
	}
}
