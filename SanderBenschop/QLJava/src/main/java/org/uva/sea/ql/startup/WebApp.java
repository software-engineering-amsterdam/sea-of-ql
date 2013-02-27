package org.uva.sea.ql.startup;

import org.uva.sea.ql.general.SymbolTable;

/**
 * Interface for classes that wrap a WebApp.
 */
public interface WebApp {

    boolean isCorrect();

    String getGeneratedQLCode();

    SymbolTable getSymbolTable();
}
