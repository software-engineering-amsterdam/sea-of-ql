package org.uva.sea.ql.gui;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class QLFilter extends FileFilter {

	public QLFilter() {
	}

	@Override
	public boolean accept(File f) {
		if (f.getName().endsWith(".ql")) {
			return true;
		}
		return false;
	}

	@Override
	public String getDescription() {
		return null;
	}

}
