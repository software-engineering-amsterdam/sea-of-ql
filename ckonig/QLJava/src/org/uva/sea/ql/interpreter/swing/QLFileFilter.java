package org.uva.sea.ql.interpreter.swing;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class QLFileFilter extends FileFilter {

	public QLFileFilter() {

	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean accept(File arg0) {
		if (arg0.getName().endsWith(".ql"))
			return true;
		return false;
	}

}
