package org.uva.sea.ql.interpretation.swing;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class QLFileFilter extends FileFilter {

	public QLFileFilter() {

	}

	@Override
	public final String getDescription() {
		return null;
	}

	@Override
	public final boolean accept(File arg0) {
		if (arg0.getName().endsWith(".ql"))
			return true;
		return false;
	}

}
