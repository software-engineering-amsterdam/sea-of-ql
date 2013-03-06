package org.uva.sea.ql.gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.ql.ast.formelements.Form;
import org.uva.sea.ql.parser.antlr.ParseError;
import org.uva.sea.ql.visitors.rendering.Renderer;
import org.uva.sea.ql.visitors.typechecking.ElementChecker;
import org.uva.sea.ql.visitors.utils.Errors;
import org.uva.sea.ql.visitors.utils.State;

public class Gui extends JFrame {

	private static final long serialVersionUID = 168935475998687670L;
	private Form ast;
	private final State state = new State();
	private final Errors errors = new Errors();
	private JPanel errorLog = new JPanel(new MigLayout());
	private JButton open = new JButton("Open QL");
	private JButton export = new JButton("Export XML");
	private JPanel buttonPanel = new JPanel(new MigLayout("fillx,insets 0"));
	private JPanel centerPanel = new JPanel(new MigLayout());
	private final JFileChooser fileChooser = new JFileChooser();
	private final JFileChooser xmlChooser = new JFileChooser();

	public Gui(Form ast) throws IOException, ParseError {
		this.ast = ast;
		fileChooser.setFileFilter(new QLFilter());
		xmlChooser.setFileFilter(new XMLFilter());
		addOpenListener(open);
		addExportListener(export);
		setInitialFrame();
		checkForConsistency();
	}

	private void addOpenListener(JButton b) {
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setQLChooser();
			}
		});
	}
	
	private void addExportListener(JButton b) {
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setOutputFile();
			}
		});
	}
	
	private void setOutputFile() {
		final int returnVal = fileChooser.showSaveDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			final File file = fileChooser.getSelectedFile();
			new XMLConverter(state.getValueEnv(), file);
		}
	}

	private void setQLChooser() {
		final int returnVal = fileChooser.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			final File file = fileChooser.getSelectedFile();
			try {
				QLFileLoader.openFile(file);
				dispose();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParseError e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * If there are no errors return render the QL else render the Error Panel
	 */

	private void checkForConsistency() {
		errors.clear();
		state.clear();
		ElementChecker.check(ast, state, errors);
		if (errors.isEmpty()) {
			setQuestionPanel();
		} else {
			setErrorPanel();
		}
	}

	private void setInitialFrame() {
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new MigLayout());
		setTitle("QL Interpreter");
		pack();
		setVisible(true);
	}

	private void setErrorPanel() {
		setButtonPane();
		for (String error : errors.returnErrors()) {
			errorLog.add(new JLabel(error), "wrap");
			errorLog.setBorder(BorderFactory.createTitledBorder("ERRORS"));
			setButtonPane();
			add(errorLog);
			pack();
			validate();
			repaint();
		}
	}

	public void setQuestionPanel() {
		cleanOldPanels();
		setButtonPane();
		add(centerPanel.add(Renderer.render(ast, state, this)));
		pack();
		centerPanel.validate();
		centerPanel.repaint();
	}

	private void setButtonPane() {
		export.setMnemonic('E');
		open.setMnemonic('O');
		buttonPanel.add(open, "split,left,width 100!");
		buttonPanel.add(export);
		add(buttonPanel, "wrap");
	}

	private void cleanOldPanels() {
		Component[] components = getContentPane().getComponents();
		for (int i = 0; i < components.length; i++) {
			remove(components[i]);
		}
	}

}
