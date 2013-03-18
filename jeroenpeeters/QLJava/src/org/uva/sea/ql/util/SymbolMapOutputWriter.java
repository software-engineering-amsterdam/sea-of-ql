package org.uva.sea.ql.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.IOUtils;
import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.value.Value;

public class SymbolMapOutputWriter {

	private final Map<Identifier, Value> symbolMap;

	public SymbolMapOutputWriter(Map<Identifier, Value> symbolMap) {
		this.symbolMap = symbolMap;
	}
	
	public void writeTo(final File file){
		
		BufferedOutputStream baos = null;
		try {
			baos = new BufferedOutputStream(new FileOutputStream(file));
			Set<Identifier> keySet = symbolMap.keySet();
			for(final Identifier id : keySet){
				final Value value = symbolMap.get(id);
				
				baos.write(id.getName().getBytes());
				baos.write(" -> ".getBytes());
				baos.write(value.toString().getBytes());
				baos.write('\n');
			}
		} catch (IOException e) {
			
		} finally {
			if(baos != null){
				try {
					baos.flush();
				} catch (IOException e) {
				}
			}
			IOUtils.closeQuietly(baos);
		}
		
	}

}
