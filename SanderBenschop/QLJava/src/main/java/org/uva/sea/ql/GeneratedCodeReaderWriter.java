package org.uva.sea.ql;

import org.apache.commons.io.FileUtils;

import java.io.*;

public final class GeneratedCodeReaderWriter {

    private static final String FILE_NAME = "./target/generatedQLCode.qlang";

    public static void writeGeneratedCode(String code) throws IOException {
        File file = new File(FILE_NAME);
        FileUtils.writeStringToFile(file, code);
    }

    public static String readGeneratedCode() throws IOException {
        File file = new File(FILE_NAME);
        return FileUtils.readFileToString(file);
    }
}
