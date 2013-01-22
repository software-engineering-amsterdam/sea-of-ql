package org.uva.sea.ql.interpreter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

class IOHelper {

	public static void write(String path, String output)
			throws FileNotFoundException {
		PrintWriter out = new PrintWriter(path);
		out.println(output);
		out.close();
	}

	public static String read(String path) throws IOException {
		FileInputStream stream = new FileInputStream(new File(path));
		try {
			FileChannel fc = stream.getChannel();
			MappedByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0,
					fc.size());
			return Charset.defaultCharset().decode(bb).toString();
		} finally {
			stream.close();
		}
	}

	public static Map<String, String> readFolder(String path)
			throws IOException {
		Map<String, String> m = new HashMap<String, String>();
		File folder = new File(path);
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isFile()) {
				m.put(fileEntry.getName().replace(".html", ""), read(path
						+ fileEntry.getName()));
			}
		}

		return m;
	}

}
