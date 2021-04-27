package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Erotus extends Komento {
    private int edellinen;
    
    public Erotus(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
        this.edellinen = 0;
    }
    
    @Override
    public void suorita() {
        int arvo = super.lueArvo();
        
        sovellus.miinus(arvo);
        edellinen = arvo;
        
        super.naytaTulos();
    }
    
    @Override
    public void peru() {
        sovellus.plus(edellinen);
        edellinen = 0;
        
        super.naytaTulos();
    }
}
