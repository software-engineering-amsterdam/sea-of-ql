package org.uva.sea.ql.formLoader;

import org.uva.sea.ql.parser.ParserFactory;

import java.io.File;

public class FormLoaderFactory {

    public static FormLoader createFormLoaderFromFile(File formFile) {
        return new FormLoaderImpl(
                new FileFormSource(formFile),
                ParserFactory.createParser());
    }

}
