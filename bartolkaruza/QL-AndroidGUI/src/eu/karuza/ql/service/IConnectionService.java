package eu.karuza.ql.service;

import java.io.InputStream;

import android.net.ConnectivityManager;
import eu.karuza.ql.QLFrontEndException;

public interface IConnectionService {
	
	public InputStream createGetConnection(ConnectivityManager connectionManager, String urlString) throws QLFrontEndException;
	public InputStream createPostConnection(ConnectivityManager connectionManager, String urlString, String postBody) throws QLFrontEndException;

}
