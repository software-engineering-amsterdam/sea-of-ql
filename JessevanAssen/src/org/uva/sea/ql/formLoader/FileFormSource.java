package org.uva.sea.ql.formLoader;

import java.io.*;

public class FileFormSource implements FormSource {

    private final File file;

    public FileFormSource(File file) {
        this.file = file;
    }

    @Override
    public String loadFormData() {
        try {
            return readFile();
        } catch(IOException ex) {
            throw new FormLoaderException(
                    String.format("Reading from the file '%s' failed.", file.getPath()),
                    ex
            );
        }
    }

    private String readFile() throws IOException {
        if(!file.canRead())
            throw new FormLoaderException(String.format("The form file '%s' can't be found or isn't readable.", file.getPath()));
        
        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuilder output = new StringBuilder();
        for(String line; (line = reader.readLine()) != null; )
            output.append(line);
        return output.toString();
    }

}
