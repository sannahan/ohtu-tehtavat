package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Summa extends Komento {
    private int edellinen;
    
    public Summa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
        edellinen = 0;
    }
    
    @Override
    public void suorita() {
        int arvo = super.lueArvo();
        
        sovellus.plus(arvo);
        edellinen = arvo;
        
        super.naytaTulos();
    }
    
    @Override
    public void peru() {
        sovellus.miinus(edellinen);
        edellinen = 0;
        
        super.naytaTulos();
    }
}
