package main.java.es.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * 
 * @author Jorge F Oliva
 *
 */
public class Files {

	private String path;

	/**
	 * 
	 * @param pPath
	 */
	public Files(String pPath) {
		this.path = pPath;
	}

	/**
	 * 
	 * @return
	 */
	public String loadFile() {
		BufferedReader in = null;

		try {
			StringBuilder strJsonResp = new StringBuilder();
			String cadena;

			URL ficheroUrl = new File(path).toURI().toURL();
			in = new BufferedReader(new InputStreamReader(ficheroUrl.openStream()));

			while ((cadena = in.readLine()) != null) {
				strJsonResp.append(cadena.trim());
			}

			in.close();

			return strJsonResp.toString();
		} catch (Exception e) {
			e.getMessage();
			return null;
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				e.getMessage();
			}
		}
	}
}
