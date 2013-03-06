package org.uva.sea.ql.gui;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class XMLFilter extends FileFilter{

	@Override
	public boolean accept(File file) {
		if (file.getName().endsWith("*xml")) {
			return true;
		}
		return false;
	}

	@Override
	public String getDescription() {
		return null;
	}

}
