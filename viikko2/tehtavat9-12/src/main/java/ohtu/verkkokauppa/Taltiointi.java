package ohtu.verkkokauppa;

import java.util.ArrayList;

public interface Taltiointi {

    ArrayList<String> getTapahtumat();

    void lisaaTapahtuma(String tapahtuma);
    
}
