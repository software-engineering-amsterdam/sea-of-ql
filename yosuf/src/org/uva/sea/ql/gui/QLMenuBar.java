package org.uva.sea.ql.gui;

import static julius.validation.Assertions.state;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.uva.sea.ql.lead.LogPrinter;
import org.uva.sea.ql.lead.Model;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class QLMenuBar {

	private static final String EXIT_TEXT = "Exit";
	private static final String FILE_ITEM_SAVE = "Save";
	private static final String FILE_MENU_TEXT = "File";

	private final Model model;
	private final Stage stage;

	/**
	 * @param model
	 *            (not null)
	 */
	public QLMenuBar(final Model model, final Stage stage) {
		this.model = model;
		this.stage = stage;
		state.assertNotNull(this.model, "QLMenuBar.model");
		state.assertNotNull(this.stage, "QLMenuBar.stage");
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
				LogPrinter.debugInfo("Exiting");
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

	// TODO : Unfinished.
	private void performSave() {
		DocumentBuilderFactory docFactory = DocumentBuilderFactory
				.newInstance();
		try {
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// root elements
			Document doc = docBuilder.newDocument();

			Element rootElement = doc.createElement("Questions");
			Element staff = doc.createElement("Question");
			rootElement.appendChild(staff);

			Attr attr = doc.createAttribute("attribute");
			attr.setValue("attribute value");
			staff.setAttributeNode(attr);

			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);

			FileChooser fileChooser = new FileChooser();

			// Set extension filter
			FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
					"XML files (*.xml)", "*.xml");
			fileChooser.getExtensionFilters().add(extFilter);

			// Show save file dialog
			File file = fileChooser.showSaveDialog(stage);
			if (file != null) {
				StreamResult result = new StreamResult(file);
				transformer.transform(source, result);
			}

		} catch (ParserConfigurationException e) {
			LogPrinter.debugInfo("Parse " + e);
		} catch (TransformerConfigurationException e) {
			LogPrinter.debugInfo("Transformation Config " + e);
		} catch (TransformerException e) {
			LogPrinter.debugInfo("Transformer " + e);
		}
	}
}
