package org.uva.sea.ql.gui;

import static julius.validation.Assertions.state;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.stage.FileChooser;
import julius.utilities.FileHelper;

import org.uva.sea.ql.ast.stm.Computed;
import org.uva.sea.ql.lead.Model;
import org.uva.sea.ql.visitor.ExpressionEvaluator;
import org.uva.sea.ql.visitor.UnmodifiedException;

/**
 * Use {@link #create()} to initialize a menu bar for QL.
 */
public class QLMenuBar {

	private static final String LINE_SEPARATOR = System.getProperty("line.separator");
	private static final String ANSWER_SEPARATOR = " => ";
	private static final String ANSWER_HEADER = "Key" + ANSWER_SEPARATOR + "answer"
			+ LINE_SEPARATOR;
	private static final String FILE_ITEM_SAVE = "Save";
	private static final String FILE_MENU_TEXT = "File";
	private static final String EXIT_TEXT = "Exit";

	private final Model model;

	/**
	 * @param model
	 *            (not null)
	 */
	public QLMenuBar(final Model model) {
		this.model = model;
		state.assertNotNull(this.model, "QLMenuBar.model");
	}

	public MenuBar create() {
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().add(createFileMenu());

		return menuBar;
	}

	private Menu createFileMenu() {
		Menu fileMenu = new Menu(FILE_MENU_TEXT);
		fileMenu.getItems().add(createSave());
		fileMenu.getItems().add(new SeparatorMenuItem());
		fileMenu.getItems().add(createExit());

		return fileMenu;
	}

	private MenuItem createExit() {
		MenuItem exit = new MenuItem(EXIT_TEXT);
		exit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(final ActionEvent arg0) {
				System.exit(0);
			}

		});
		return exit;
	}

	private MenuItem createSave() {
		MenuItem save = new MenuItem(FILE_ITEM_SAVE);
		save.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(final ActionEvent arg0) {
				performSave();
			}

		});
		return save;
	}

	private void performSave() {
		List<String> preparedQuestions = prepareComputeds();
		File file = new FileChooser().showSaveDialog(null);

		if (file != null) {
			StringBuffer buffer = new StringBuffer(ANSWER_HEADER);
			buffer.append(join(preparedQuestions, LINE_SEPARATOR));

			FileHelper.writeFile(buffer.toString(), file.getPath());
		}
	}

	private String join(final Collection<String> collection, final String joiner) {
		StringBuffer buffer = new StringBuffer();

		for (String item : collection) {
			buffer.append(item).append(joiner);
		}
		return buffer.toString();
	}

	private List<String> prepareComputeds() {
		List<String> prepared = new ArrayList<String>();
		ExpressionEvaluator evaluator = new ExpressionEvaluator(model);

		for (Computed computed : model.getComputeds()) {

			try {
				prepared.add(computed.getIdentifier().getName() + ANSWER_SEPARATOR
						+ computed.getExpression().accept(evaluator).getAsString());
			} catch (UnmodifiedException e) {
				// since not all the values of the computed questions is known/answered, it is
				// caught here and continued.
				continue;
			}
		}
		return prepared;
	}
}
