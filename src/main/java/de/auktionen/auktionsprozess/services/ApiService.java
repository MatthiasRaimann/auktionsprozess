package de.auktionen.auktionsprozess.services;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import spinjar.com.minidev.json.JSONObject;

/**
 * 
 * @author Matthias Raimann
 * Funktionen: Service, der dazu dient aus Java heraus JSON-Requests zu schicken. Wird unter anderem genutzt,
 * um mit einem Dritten zu kommunizieren, der für uns die Emailkommunikation übernimmt.
 * 
 *   Quellen: 	https://stackoverflow.com/questions/3324717/sending-http-post-request-in-java#:~:text=Sending%20a%20POST%20request%20is,method%20to%20set%20our%20method.
 *				https://stackoverflow.com/questions/8997598/importing-json-into-an-eclipse-project
 *
 */

public class ApiService {
	
	/**
	 * author: Matthias Raimann
	 * @param myURL die Url an die der Post-Request geschickt wird
	 * @param data Key-Value-Paare, die später im Body des Requests stehen
	 */
	public static void postJson(String myURL, Map<String, String> data) {
		
		try {
			URL url = new URL(myURL);
			URLConnection con = url.openConnection();
			HttpURLConnection http = (HttpURLConnection) con;
			http.setRequestMethod("POST");
			http.setDoOutput(true);
			
			String dataString = new JSONObject(data).toString();
			
			byte[] out = dataString.getBytes(StandardCharsets.UTF_8);
			
			http.setFixedLengthStreamingMode(out.length);
			http.setRequestProperty("Content-Type", "application/json");
			http.setRequestProperty("charset", "UTF-8");
			http.connect();
			try (OutputStream os = http.getOutputStream()){
				os.write(out);
			}			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
