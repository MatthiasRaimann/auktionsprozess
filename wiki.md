# Business Wiki

## Namensgebung
- In sprechendem Deutsch
- Camel Case
- Java EE Konventionen beachten

## Ordnerstruktur `src/main/java/de/auktionen/auktionsprozess/..`
- beans
- vorbereitung
- vertrieb
- abwicklung


## Globale Variablen
- Globale Variablen müssen in die `Call Aktivities` **rein** und **raus** gemapped werden

### Beans
```java
public class KundeBean implements Serializable {
  
  int knr;
  String namen;
  String iban;
  String email;
  String strasse;
  int hausnummer;
  String plz;
  String ort;
  
}
```

```java
public class ArtikelBean implements Serializable {
    
    int anr;
    int neukaufpreis;
    int auktionsstartpreis;
    Date herstellungsdatum;
    Abnutzung abnutzung;
  
}

public enum Abnutzung { 

}
```
