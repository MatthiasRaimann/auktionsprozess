package de.auktionen.services;

import java.util.HashMap;
import java.util.Map;

public class EmailService {

	/**
	 * @author Matthias Raimann
	 *
	 * @param an Email-Adresse, an die die Mail geschickt werden soll
	 * @param betreff Betreff, den der Empfänger bei Erhalt der Email sehen soll
	 * @param nachricht Nachricht, die im Body der Email liegt
	 *
	 * Der Drittanbieter erwartet folgende JsonFelder im Request-Body: key, to, subject, message
	 * 		key: enhält API-Schlüssel - wenn der Schlüssel nicht korrekt ist, wird die Mail nicht versendet
	 *
	 * Map wird von ApiService in Json umgewandelt und in den Request-Body gelegt.
	 */
	public static void sendeEmail(String an, String betreff, String nachricht) {
		Map<String, String> map = new HashMap<>();
		map.put("key", "^9ZDxal&eTQM87pj7g!H05z^3xiyBG");
		map.put("to", an);
		map.put("subject", betreff);
		map.put("message", nachricht);

		ApiService.postJson("http://matthias-raimann.de:8080/sendMail", map);
	}

	
}
