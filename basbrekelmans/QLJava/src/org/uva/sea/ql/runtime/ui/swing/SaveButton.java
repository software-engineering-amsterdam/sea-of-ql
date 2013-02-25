package org.uva.sea.ql.runtime.ui.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.uva.sea.ql.runtime.OutputPrinter;
import org.uva.sea.ql.runtime.ui.IControl;

class SaveButton implements IControl {

	private final JButton button;
	private final OutputPrinter printer;

	public SaveButton(final OutputPrinter printer) {
		this.button = new JButton("Save");
		this.printer = printer;
		this.button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent arg0) {
				SaveButton.this.onClick();

			}

		});
	}

	@Override
	public JButton getUnderlyingComponent() {
		return this.button;
	}

	@Override
	public boolean isEnabled() {
		return this.button.isEnabled();
	}

	private void onClick() {
		final JFileChooser chooser = new JFileChooser();
		final int result = chooser.showSaveDialog(this.button);
		if (result == JFileChooser.APPROVE_OPTION) {
			try {
				final PrintWriter writer = new PrintWriter(
						chooser.getSelectedFile());
				try {
					this.printer.printCurrentState(writer);
				} catch (final IOException ex) {
					this.showErrorDialog(ex);
				} finally {
					writer.close();
				}
			} catch (final FileNotFoundException ex) {
				this.showErrorDialog(ex);
			}

		}

	}

	@Override
	public void setEnabled(final boolean value) {
		this.button.setEnabled(value);
	}

	private void showErrorDialog(final Exception ex) {
		JOptionPane.showMessageDialog(this.button, ex.getMessage(),
				"Error saving file", JOptionPane.ERROR_MESSAGE);
	}

}
