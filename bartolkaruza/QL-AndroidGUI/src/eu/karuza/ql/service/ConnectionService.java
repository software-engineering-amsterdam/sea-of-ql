package eu.karuza.ql.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import eu.karuza.ql.QLFrontEndException;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class ConnectionService {

	public InputStream createGetConnection(ConnectivityManager connectionManager, String urlString) throws QLFrontEndException {
		if (isNetworkAvailable(connectionManager)) {
			URLConnection connection;
			URL url;
			try {
				url = new URL(urlString);
			} catch (MalformedURLException e) {
				throw new QLFrontEndException();
			}
			try {
				connection = url.openConnection();
				return connection.getInputStream();
			} catch (IOException e) {
				throw new QLFrontEndException();
			}
		} else {
			throw new QLFrontEndException("No connection available");
		}
	}

	public InputStream createPostConnection(ConnectivityManager connectionManager, String urlString, String postBody) throws QLFrontEndException {

		if (isNetworkAvailable(connectionManager)) {
			HttpClient client = new DefaultHttpClient();
			HttpPost post = new HttpPost(urlString);
			StringEntity entity;
			try {
				entity = new StringEntity(postBody);
				post.setEntity(entity);
				HttpResponse response = client.execute(post);
				return response.getEntity().getContent();
			} catch (UnsupportedEncodingException e) {
				throw new QLFrontEndException();
			} catch (ClientProtocolException e) {
				throw new QLFrontEndException();
			} catch (IOException e) {
				throw new QLFrontEndException();
			}
		} else {
			throw new QLFrontEndException("No connection available");
		}
	}

	private boolean isNetworkAvailable(ConnectivityManager manager) {
		NetworkInfo info = manager.getActiveNetworkInfo();
		if (info != null && info.isConnected()) {
			return true;
		} else {
			return false;
		}
	}

}
