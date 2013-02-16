package org.uva.sea.ql.webserver;

import java.io.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.*;
import javax.ws.rs.ext.*;

import org.uva.sea.ql.ast.types.datatypes.DataType;

import com.fasterxml.jackson.databind.ObjectMapper;

@Provider
public class DataTypeReader implements MessageBodyReader<DataType> {

	@Override
	public boolean isReadable(Class<?> type, Type arg1, Annotation[] arg2, MediaType arg3) {
        return DataType.class == arg1;
	}

	@Override
	public DataType readFrom(Class<DataType> type, Type genericType, Annotation[] arg2, MediaType mediaType,
			MultivaluedMap<String, String> httpHeaders, InputStream entityStream) throws IOException, WebApplicationException {
		DataType result;
		
		byte[] buffer = new byte[1024];
		StringBuffer text = new StringBuffer();
		//read it with BufferedReader
		
		/*
    	BufferedReader reader = new BufferedReader(new InputStreamReader(entityStream));
 
    	String line;
    	while ((line = reader.readLine()) != null) {
    		text.append(line);
    	}
    	*/
    	
        /* ObjectMapper mapper = new ObjectMapper();
        mapper.readValue(new InputStream(entityStream), Int)

		System.out.println("read: " + text.toString());
		*/
		return null;
	}
	
}
