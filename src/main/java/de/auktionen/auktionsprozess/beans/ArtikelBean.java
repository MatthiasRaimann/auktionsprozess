package de.auktionen.auktionsprozess.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Merlin
 * @see Implementierung der Bean fuer das Geschaeftsobjekt 'Artikel'
 */
public class ArtikelBean implements Serializable {
 
	private static final long serialVersionUID = 1L;
	int anr;
    int neukaufpreis;
    int auktionsstartpreis;
    Date herstellungsdatum;
    Abnutzung abnutzung;
  
}