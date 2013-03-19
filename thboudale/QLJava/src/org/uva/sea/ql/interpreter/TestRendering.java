package org.uva.sea.ql.interpreter;

import java.io.FileNotFoundException;

import org.uva.sea.ql.parser.test.ParseError;

public class TestRendering {
	
	public static void main(String[] args) throws ParseError, FileNotFoundException {
		ApplicationFrame appFrame = new ApplicationFrame();
		appFrame.showFrame(args[0], args[1]);
	}
}