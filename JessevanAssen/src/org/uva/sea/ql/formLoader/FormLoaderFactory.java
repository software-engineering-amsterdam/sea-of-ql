package org.uva.sea.ql.formLoader;

import org.uva.sea.ql.parser.ParserFactory;

import java.io.File;

public class FormLoaderFactory {

    public static FormLoader createFormLoader() {
        File formFile = new File("C:\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\Box1HouseOwning.ql");

        return new FormLoaderImpl(
                new FileFormSource(formFile),
                ParserFactory.createParser());
    }

}
