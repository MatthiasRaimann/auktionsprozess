package de.auktionen.beans;

import java.io.Serializable;

/**
 * 
 * @author Merlin
 * @see Implementierung der Bean fuer das Geschaeftsobjekt 'Kunde'
 */
public class KundeBean implements Serializable {
	  
	
	private static final long serialVersionUID = 1L;
	private int knr;
	private String namen;
	private String iban;
	private String email;
	private String strasse;
	private int hausnummer;
	private String plz;
	private String ort;
	
	public KundeBean(int knr, String namen, String iban, String email, String strasse, int hausnummer, String plz,
			String ort) {
		this.knr = knr;
		this.namen = namen;
		this.iban = iban;
		this.email = email;
		this.strasse = strasse;
		this.hausnummer = hausnummer;
		this.plz = plz;
		this.ort = ort;
	}
	
	public KundeBean() {
		this.knr = -1;
		this.namen = null;
		this.iban = null;
		this.email = null;
		this.strasse = null;
		this.hausnummer = -1;
		this.plz = null;
		this.ort = null;
	}
	public int getKnr() {
		return knr;
	}
	public void setKnr(int knr) {
		this.knr = knr;
	}
	public String getNamen() {
		return namen;
	}
	public void setNamen(String namen) {
		this.namen = namen;
	}
	public String getIban() {
		return iban;
	}
	public void setIban(String iban) {
		this.iban = iban;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStrasse() {
		return strasse;
	}
	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}
	public int getHausnummer() {
		return hausnummer;
	}
	public void setHausnummer(int hausnummer) {
		this.hausnummer = hausnummer;
	}
	public String getPlz() {
		return plz;
	}
	public void setPlz(String plz) {
		this.plz = plz;
	}
	public String getOrt() {
		return ort;
	}
	public void setOrt(String ort) {
		this.ort = ort;
	}
	
	}