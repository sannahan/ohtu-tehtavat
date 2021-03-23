package ohtu.verkkokauppa;

public interface Maksu {

    boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa);
    
}
