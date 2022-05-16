# Business Wiki

## Namensgebung
- In sprechendem Deutsch
- Camel Case
- Java EE Konventionen beachten

## Globale Variablen
- Globale Variablen müssen in die `Call Aktivities` **rein** und **raus** gemapped werden
### Beans
``java
public class KundeBean {
  
  int knr;
  String namen;
  String iban;
  String email;
  String strasse;
  int hausnummer;
  String plz;
  String ort;
  
}
``
``java
public class Artikel {
    
    int anr;
    
  
}
``
