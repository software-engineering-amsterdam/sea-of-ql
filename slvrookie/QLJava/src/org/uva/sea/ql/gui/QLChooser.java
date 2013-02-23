package org.uva.sea.ql.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.ql.parser.antlr.ParseError;

public class QLChooser extends JFrame {

	private static final long serialVersionUID = 168935475998687670L;
	private JButton open = new JButton("Open QL");
	private JPanel buttonPanel = new JPanel(new MigLayout("fillx,insets 0"));
	private final JFileChooser fileChooser = new JFileChooser();

	public static void main(String[] args) throws IOException, ParseError {
		new QLChooser();
	}

	private QLChooser() throws IOException, ParseError {
		fileChooser.setFileFilter(new QLFilter());
		addOpenListener(open);
		setInitialFrame();
	}

	private void addOpenListener(JButton b) {
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					setQLChooser();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ParseError e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void setQLChooser() throws IOException, ParseError {
		final int returnVal = fileChooser.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			final File file = fileChooser.getSelectedFile();
			QLFileLoader.openFile(file);
			dispose();
		}
	}

	private void setInitialFrame() {
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new MigLayout());
		open.setMnemonic('O');
		buttonPanel.add(open, "split,left,width 100!");
		add(buttonPanel, "wrap");
		pack();
		setVisible(true);
	}
}
